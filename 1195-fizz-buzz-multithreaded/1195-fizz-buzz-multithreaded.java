class FizzBuzz {
    private int n; 
    private Semaphore f;
    private Semaphore b;
    private Semaphore fb;
    private Semaphore num;

    public FizzBuzz(int n) {
        this.n = n;
        this.f = new Semaphore(0);
        this.b = new Semaphore(0);
        this.fb = new Semaphore(0);
        this.num = new Semaphore(1);
    }
    
    private void runNext(int i) {
        if (i % 3 == 0 && i % 5 != 0) {
            f.release();
        } else if (i % 3 != 0 && i % 5 == 0) {
            b.release();
        } else if (i % 3 == 0 && i % 5 == 0) {
            fb.release();
        } else {
            num.release();
        }
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                f.acquire();
                printFizz.run();
                runNext(i + 1);
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                b.acquire();
                printBuzz.run();
                runNext(i + 1);
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fb.acquire();
                printFizzBuzz.run();
                runNext(i + 1);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                num.acquire();
                printNumber.accept(i);
                runNext(i + 1);
            }
        }
    }
}