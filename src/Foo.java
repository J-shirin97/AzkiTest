import java.util.concurrent.CountDownLatch;

public class Foo {

    private CountDownLatch secondLatch = new CountDownLatch(1);
    private CountDownLatch thirdLatch = new CountDownLatch(1);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        secondLatch.countDown(); // Allow second() to proceed
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondLatch.await(); // Wait until first() has been executed
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        thirdLatch.countDown(); // Allow third() to proceed
    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdLatch.await(); // Wait until second() has been executed
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}
