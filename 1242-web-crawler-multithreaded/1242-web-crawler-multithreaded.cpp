class Solution {
private:
    const int maxWorker = 5;
    
    string getHostname(const string& url) {
        int startIdx = url.find("//") + 2;
        int endIdx = url.find('/', startIdx);

        if (endIdx == string::npos) {
            return url.substr(startIdx);
        }

        return url.substr(startIdx, endIdx - startIdx);
    }

public:
    vector<string> crawl(string startUrl, HtmlParser htmlParser) {
        string hostName = getHostname(startUrl);
        unordered_set<string> parsed;
        queue<string> urlQ;
        
        urlQ.push(startUrl);
        parsed.insert(startUrl);
        
        mutex urlQLock;
        condition_variable urlQCdn;
        set<int> idleWorker;
        
        vector<thread> workers;
        
        for (int i = 0; i < maxWorker; ++i) {
            workers.emplace_back([&, i]() {
                while (true) {
                    string currUrl;
                    {
                        unique_lock<mutex> lock(urlQLock);
                        urlQCdn.wait(lock, [&] {
                            if (urlQ.empty()) {
                                idleWorker.insert(i);
                                if (idleWorker.size() == maxWorker) {
                                    urlQCdn.notify_all();
                                    return true;
                                }
                            }
                            return !urlQ.empty();
                        });

                        if (idleWorker.size() == maxWorker) {
                            return;
                        }

                        currUrl = urlQ.front();
                        urlQ.pop();
                    }

                    // get next urls
                    vector<string> nextUrls = htmlParser.getUrls(currUrl);

                    unique_lock<mutex> lock(urlQLock);
                    for (const string& nurl : nextUrls) {
                        string localHostName = getHostname(nurl);
                        if (parsed.find(nurl) == parsed.end() && localHostName == hostName) {
                            urlQ.push(nurl);
                            parsed.insert(nurl);
                            urlQCdn.notify_one();
                        }
                    }
                    
                    if (urlQ.empty()) {
                        idleWorker.insert(i);
                        urlQCdn.notify_all();
                    } else {
                        idleWorker.erase(i);
                    }
                }
            });
        }
        
        for (auto& worker : workers) {
            worker.join();
        }
        
        return vector<string>(parsed.begin(), parsed.end());
    }
};