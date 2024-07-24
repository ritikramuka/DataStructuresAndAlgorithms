class H2O {
    
    ReentrantLock lock = new ReentrantLock();
    Condition relO = lock.newCondition();
    Condition relH = lock.newCondition();
    
    AtomicInteger cntOfHReleased = new AtomicInteger(0);
    AtomicBoolean startORelease = new AtomicBoolean(true);

    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        
        try {
            while (startORelease.get()) {
                relH.await();
            }

            releaseHydrogen.run();
            cntOfHReleased.getAndIncrement();
            if (cntOfHReleased.get() == 2) {
                cntOfHReleased.set(0);
                startORelease.set(true);
                relO.signal();
            }
        } finally {
            lock.unlock();
        }
        
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        
        try {
            while (!startORelease.get()) {
                relO.await();
            }

            releaseOxygen.run();
            startORelease.set(false);
            relH.signalAll();
        } finally {
            lock.unlock();
        }
        
    }
}