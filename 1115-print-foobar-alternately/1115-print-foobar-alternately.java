class FooBar {
    private int n;
    private Semaphore f = new Semaphore(1);
    private Semaphore b = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            // f has one permite          
            f.acquire();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run(); 
            b.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            // b will wait           
            b.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            f.release();
        }
    }
}