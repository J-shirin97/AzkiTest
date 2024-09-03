package Main.azki;

public class FooTestService {
    public static StringBuilder startAndJoinThreads(int[] order) throws InterruptedException {

        Foo foo = new Foo();
        StringBuilder output = new StringBuilder();
       int first =  order[0];
       int second = order[1];
       int third = order[2];


       Thread a = new Thread();
       Thread b = new Thread();
       Thread c = new Thread();

        Runnable printFirst = () -> output.append("first");
        Runnable printSecond = () -> output.append("second");
        Runnable printThird = () -> output.append("third");

       if (first == 1 ){
           a = new Thread(() -> {
               try {
                   foo.first(printFirst);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           });
       } else if (first == 2) {
           a = new Thread(() -> {
               try {
                   foo.second(printSecond);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           });
       } else if (first == 3) {
           a = new Thread(() -> {
               try {
                   foo.third(printThird);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           });
       }


        if (second == 1 ){
            b = new Thread(() -> {
                try {
                    foo.first(printFirst);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } else if (second == 2) {
            b = new Thread(() -> {
                try {
                    foo.second(printSecond);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } else if (second == 3) {
            b = new Thread(() -> {
                try {
                    foo.third(printThird);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


        if (third == 1 ){
            c = new Thread(() -> {
                try {
                    foo.first(printFirst);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } else if (third == 2) {
            c = new Thread(() -> {
                try {
                    foo.second(printSecond);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } else if (third == 3) {
            c = new Thread(() -> {
                try {
                    foo.third(printThird);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


        // Start Thread
        a.start();
        b.start();
        c.start();

        // Wait for all threads to complete
        a.join();
        b.join();
        c.join();

        return  output;
    }
}
