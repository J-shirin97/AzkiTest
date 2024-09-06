package Main.test;

import Main.azki.Foo;

public class FooTestService {
    public static StringBuilder startAndJoinThreads(int[] order) throws InterruptedException {

        Foo foo = new Foo();
        StringBuilder output = new StringBuilder();

        int first = order[0];
        int second = order[1];
        int third = order[2];


        Thread a = new Thread();
        Thread b = new Thread();
        Thread c = new Thread();

        Runnable printFirst = () -> output.append("first");
        Runnable printSecond = () -> output.append("second");
        Runnable printThird = () -> output.append("third");

        switch (first) {
            case 1:
                a = new Thread(() -> {
                    try {
                        foo.first(printFirst);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                break;
            case 2:
                a = new Thread(() -> {
                    try {
                        foo.second(printSecond);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                break;
            case 3:
                a = new Thread(() -> {
                    try {
                        foo.third(printThird);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                break;
            default:
                throw new IllegalArgumentException("Invalid value for 'first': " + first);
        }


        switch (second) {
            case 1:
                b = new Thread(() -> {
                    try {
                        foo.first(printFirst);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                break;
            case 2:
                b = new Thread(() -> {
                    try {
                        foo.second(printSecond);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                break;
            case 3:
                b = new Thread(() -> {
                    try {
                        foo.third(printThird);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                break;
            default:
                throw new IllegalArgumentException("Invalid value for 'second': " + second);
        }

        switch (third) {
            case 1:
                c = new Thread(() -> {
                    try {
                        foo.first(printFirst);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                break;
            case 2:
                c = new Thread(() -> {
                    try {
                        foo.second(printSecond);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                break;
            case 3:
                c = new Thread(() -> {
                    try {
                        foo.third(printThird);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                break;
            default:
                throw new IllegalArgumentException("Invalid value for 'third': " + third);
        }


        // Start Thread
        a.start();
        b.start();
        c.start();

        // Wait for all threads to complete
        a.join();
        b.join();
        c.join();

        return output;
    }
}
