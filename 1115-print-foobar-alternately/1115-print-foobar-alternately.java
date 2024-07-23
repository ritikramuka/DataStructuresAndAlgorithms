class FooBar {
    private int n;
    
    ReentrantLock lock = new ReentrantLock();
    Condition fooCdn = lock.newCondition();
    Condition barCdn = lock.newCondition();
    AtomicBoolean printedFoo = new AtomicBoolean(false);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
            
            try {
                while (printedFoo.get()) {
                    fooCdn.await();
                }
                
                printFoo.run(); 
                printedFoo.set(true);
                barCdn.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
            
            try {
                while (!printedFoo.get()) {
                    barCdn.await();
                }
                
                printBar.run();; 
                printedFoo.set(false);
                fooCdn.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}