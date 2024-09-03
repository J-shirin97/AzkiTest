package Main.azki;

public class FooThreads {
    Foo foo = new Foo();

    // Create Runnable objects that print the corresponding strings
    // using lombda function here
    Runnable printFirst = () -> System.out.print("first");
    Runnable printSecond = () -> System.out.print("second");
    Runnable printThird = () -> System.out.print("third");

    // Create threads for each of the java.FooOriginal.Main.Main.azki.Foo class methods
    public Thread threadA = new Thread(() -> {
        try {
            foo.first(printFirst);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

   public Thread threadB = new Thread(() -> {
        try {
            foo.second(printSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

   public Thread threadC = new Thread(() -> {
        try {
            foo.third(printThird);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

}
