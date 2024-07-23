class DiningPhilosophers {
    ReentrantLock lock = new ReentrantLock();
    Condition thinking = lock.newCondition();
    AtomicBoolean isLeftAvailable = new AtomicBoolean(true);
    AtomicBoolean isRightAvailable = new AtomicBoolean(true);

    public DiningPhilosophers() {
        
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat, Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
        lock.lock();
        try {
            while (!isLeftAvailable.get() || !isRightAvailable.get()) {
                thinking.await();
            }
            
            pickLeftFork.run();
            isLeftAvailable.set(false);

            pickRightFork.run();
            isRightAvailable.set(false);
            
            eat.run();
            
            putLeftFork.run();
            isLeftAvailable.set(true);
            
            putRightFork.run();
            isRightAvailable.set(true);
            
            thinking.signal();
        } finally {
            lock.unlock();
        }
    }
}