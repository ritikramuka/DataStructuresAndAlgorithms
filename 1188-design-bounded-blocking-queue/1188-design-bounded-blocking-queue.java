class BoundedBlockingQueue {

    private Queue<Integer> que;
    private int maxSize;
    
    private ReentrantLock lockQ;
    private Condition dataRemoved;
    private Condition dataAdded;
    
    public BoundedBlockingQueue(int capacity) {
        this.que = new LinkedList<>();
        this.maxSize = capacity;
        this.lockQ = new ReentrantLock();
        this.dataRemoved = lockQ.newCondition();
        this.dataAdded = lockQ.newCondition();
    }
    
    public void enqueue(int element) throws InterruptedException {
        this.lockQ.lock();
        try {
            while (this.que.size() == this.maxSize) {
                dataRemoved.await();
            }
            
            this.que.add(element);
            this.dataAdded.signal();
        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.lockQ.unlock();
        }
    }
    
    public int dequeue() throws InterruptedException {
        int data = 0;
        
        this.lockQ.lock();
        try {
            while (this.que.size() == 0) {
                dataAdded.await();
            }
            
            data = this.que.poll();
            this.dataRemoved.signal();
        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.lockQ.unlock();
        }
        
        return data;
    }
    
    public int size() {
        this.lockQ.lock();
        try {
            return this.que.size();    
        } finally {
            this.lockQ.unlock();   
        }
    }
}