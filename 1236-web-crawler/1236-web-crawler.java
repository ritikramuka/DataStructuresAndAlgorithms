/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    private int maxWorker = 5;
    private Queue<String> urlToParseQ = new LinkedList<>();
    private HashSet<String> parsed = new HashSet<>();
    private String hostName = "";
    private ReentrantLock qLock = new ReentrantLock();
    private Condition qCdn = qLock.newCondition();
    private HashSet<Integer> workerIdle = new HashSet<>();
    
    public String getHostname(String url) {
        int startIdx = url.indexOf("//") + 2;
        int endIdx = url.indexOf('/', startIdx);

        if (endIdx == -1) {
            return url.substring(startIdx);
        }

        return url.substring(startIdx, endIdx);
    }
    
    public void work(int workerId, HtmlParser htmlParser) {
        while (true) {
            String currUrl = null;
            
            qLock.lock();
            try {
                while (urlToParseQ.isEmpty()) {
                    workerIdle.add(workerId);
                    
                    // if all are idle return
                    if (workerIdle.size() == maxWorker) {
                        qCdn.signalAll();
                        return;
                    }
                    
                    qCdn.await();
                    workerIdle.remove(workerId);
                }
                
                currUrl = urlToParseQ.poll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                qLock.unlock();
            }
            
            if (currUrl == null) {
                continue;
            }
            
            List<String> nextUrls = htmlParser.getUrls(currUrl);
            
            qLock.lock();
            try {
                for (String nextUrl: nextUrls) {
                    if (parsed.contains(nextUrl) == false && hostName.equals(getHostname(nextUrl))) {
                        urlToParseQ.add(nextUrl);
                        parsed.add(nextUrl);
                        
                        qCdn.signal();
                    } 
                }
            } catch (Error e) {
                e.printStackTrace();
            } finally {
                qLock.unlock();
            }
        }
    }
    
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        hostName = getHostname(startUrl);
        
        urlToParseQ.add(startUrl);
        parsed.add(startUrl);
        
        // pool of threads: workers to do work concurrently
        Thread[] workers = new Thread[maxWorker];
        for (int i = 0; i < maxWorker; i++) {
            int workerId = i;
            Thread worker = new Thread(() -> work(workerId, htmlParser));
            workers[workerId] = worker;
            workers[workerId].start();
        }
        
        for (int i = 0; i < maxWorker; i++) {
            try {
                workers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        return new ArrayList<>(parsed);
    }
}