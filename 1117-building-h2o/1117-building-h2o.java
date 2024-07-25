class H2O {
    
    ReentrantLock lock = new ReentrantLock();
    Boolean isOxygenBlocked = false;
    int numOfHydrogenReleased = 0;
    Condition canReleaseHydrogen = lock.newCondition();
    Condition canReleaseOxygen = lock.newCondition();

    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		lock.lock();
        try {
            while (!isOxygenBlocked || numOfHydrogenReleased >= 2) {
                canReleaseHydrogen.await();
            }

            releaseHydrogen.run();
            numOfHydrogenReleased++;

            if (numOfHydrogenReleased == 2) {
                isOxygenBlocked = false;
                canReleaseOxygen.signal();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        try {
            while(isOxygenBlocked) {
                canReleaseOxygen.await();
            }

            releaseOxygen.run();
            numOfHydrogenReleased = 0;

            isOxygenBlocked = true;

            canReleaseHydrogen.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}