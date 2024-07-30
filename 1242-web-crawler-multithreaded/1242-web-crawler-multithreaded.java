/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    private int maxWorker = 5;
    
    public String getHostname(String url) {
        int startIdx = url.indexOf("//") + 2;
        int endIdx = url.indexOf('/', startIdx);

        // Remember case when endIdx return -1, end of string
        if (endIdx == -1) {
            return url.substring(startIdx);
        }

        return url.substring(startIdx, endIdx);
    }
    
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostName = getHostname(startUrl);
        HashSet<String> parsed = new HashSet<>();
        Queue<String> urlQ = new LinkedList<>();
        
        urlQ.add(startUrl);
        parsed.add(startUrl);
        
        ReentrantLock urlQLock = new ReentrantLock();
        Condition urlQCdn = urlQLock.newCondition();
        HashSet<Integer> idleWorker = new HashSet<>();
        
        Thread[] workers = new Thread[maxWorker];
        for (int i = 0; i < maxWorker; i++) {
            int workerId = i;
            Thread thread = new Thread(() -> {
                while (true) {
                    String currUrl = null;

                    try {
                        urlQLock.lock();
                        while (urlQ.isEmpty()) {
                            idleWorker.add(workerId);
                            if (idleWorker.size() == maxWorker) {
                                urlQCdn.signalAll();
                                return;
                            }

                            try {
                                urlQCdn.await(); 
                            } catch (InterruptedException e) {
                                return;
                            }

                            idleWorker.remove(workerId);
                        }

                        currUrl = urlQ.poll();
                        if (currUrl == null) {
                            continue;
                        }
                    } finally {
                        urlQLock.unlock();
                    }

                    // get next urls
                    List<String> nextUrls = htmlParser.getUrls(currUrl);

                    urlQLock.lock();
                    for (String nurl: nextUrls) {
                        String localHostName = getHostname(nurl);
                        if (parsed.contains(nurl) == false && localHostName.equals(hostName)) {
                            urlQ.add(nurl);
                            parsed.add(nurl);
                            urlQCdn.signal();
                        }
                    }
                    
                    if (urlQ.isEmpty()) {
                        idleWorker.add(workerId);
                        urlQCdn.signalAll();
                    }
                    urlQLock.unlock();                 
                }
            });
            workers[i] = thread;
            workers[i].start();
        }
        
        for (int i = 0; i < maxWorker; i++) {
            try {
                workers[i].join();  
            } catch(InterruptedException e) {
                System.out.println("Error occurred");
                return new ArrayList();
            }
        }
        
        return new ArrayList(parsed);
    }
}