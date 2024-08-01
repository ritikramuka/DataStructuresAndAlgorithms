/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    private int maxNumberOrWorkers = 8;
    
    private void work(int workerId, String hostName, Queue<String> urlQ, HashSet<String> visUrl, ReentrantLock urlQLock, Condition urlQCdn, AtomicInteger idleWorkers, HtmlParser htmlParser) {
        while (true) {
            String currUrl = null;
            
            urlQLock.lock();
            try {
                while (urlQ.isEmpty()) {
                    // starting to be idle
                    idleWorkers.getAndIncrement();
                    if (idleWorkers.get() == maxNumberOrWorkers) {
                        urlQCdn.signalAll();
                        return;
                    }
                    
                    urlQCdn.await();
                    
                    // might become non idle
                    idleWorkers.getAndDecrement();
                }
                
                currUrl = urlQ.poll();
            } catch (InterruptedException e) {
                e.printStackTrace();  
            } finally {
                urlQLock.unlock();
            }
            
            if (currUrl != null) {
                List<String> nextUrls = htmlParser.getUrls(currUrl);
                
                urlQLock.lock();
                try {
                    for (String nextUrl: nextUrls) {
                        String localHostName = getHostName(nextUrl);
                        
                        if (!visUrl.contains(nextUrl) && localHostName.equals(hostName)) {
                            urlQ.add(nextUrl);
                            visUrl.add(nextUrl);
                            
                            urlQCdn.signal();
                        }
                    }
                } finally {
                    urlQLock.unlock();
                }
            }
        }
    }
    
    private String getHostName(String url) {
        String hostName = url.substring(7).split("/")[0];
        return hostName;
    }
    
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        
        String hostName = getHostName(startUrl);
        
        Queue<String> urlQ = new LinkedList<>();
        HashSet<String> visUrl = new HashSet<>();
        
        urlQ.offer(startUrl);
        visUrl.add(startUrl);
        
        Thread[] workers = new Thread[maxNumberOrWorkers];
        ReentrantLock urlQLock = new ReentrantLock();
        Condition urlQCdn = urlQLock.newCondition();
        AtomicInteger idleWorkers = new AtomicInteger(0);
        
        for (int i = 0; i < maxNumberOrWorkers; i++) {
            int workerId = i;
            
            Thread worker = new Thread(() -> work(workerId, hostName, urlQ, visUrl, urlQLock, urlQCdn, idleWorkers, htmlParser));
            workers[workerId] = worker;
            workers[workerId].start();
        }
        
        for (int i = 0; i < maxNumberOrWorkers; i++) {
            int workerId = i;
            
            try {
                workers[workerId].join();    
            } catch (InterruptedException e) {
                e.printStackTrace();  
            }
        }
        
        return new ArrayList<>(visUrl);
    }
}