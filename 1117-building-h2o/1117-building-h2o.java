class H2O {
    Semaphore h;
    Semaphore o;

    public H2O() {
        h = new Semaphore(2);
        o = new Semaphore(1);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		h.acquire();
        
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        
        if (h.availablePermits() == 0) {
            o.release(1);
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire();
        
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        
        h.release(2);
    }
}