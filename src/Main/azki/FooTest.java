package Main.azki;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FooTest {

    @Test
    public void testThreadOrder() throws InterruptedException {
        // Create a StringBuilder to capture the output
        StringBuilder output ;

        // Define the order in which threads will be started
        int[] order = {1,2,3}; // 3 = thread3, 2 = thread2, 1 = thread1

        // Call the method to start and join threads based on the order
        output = FooTestService.startAndJoinThreads(order);

        // Verify the output is "firstsecondthird"
        Assertions.assertEquals("firstsecondthird", output.toString());
    }

    @Test
    public void testThreadOrder2() throws InterruptedException {
        // Create a StringBuilder to capture the output
        StringBuilder output;

        // Define the order in which threads will be started
        int[] order = {1,3,2}; // 3 = thread3, 2 = thread2, 1 = thread1

        // Call the method to start and join threads based on the order
        output = FooTestService.startAndJoinThreads(order);

        // Verify the output is "firstsecondthird"
        Assertions.assertEquals("firstsecondthird", output.toString());
    }




















//    @Test
//    public void testThreadOrder() throws InterruptedException {
//        // Create a StringBuilder to capture the output
//        StringBuilder output = new StringBuilder();
//
//        // Create a java.FooOriginal.Main.Main.azki.Foo object
//        Foo foo = new Foo();
//
//        // Create Runnable tasks that append "first", "second", and "third" to the output
//        Runnable printFirst = () -> output.append("first");
//        Runnable printSecond = () -> output.append("second");
//        Runnable printThird = () -> output.append("third");
//
//        // Create threads for each method
//        Thread thread1 = new Thread(() -> {
//            try {
//                foo.first(printFirst);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        Thread thread2 = new Thread(() -> {
//            try {
//                foo.second(printSecond);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        Thread thread3 = new Thread(() -> {
//            try {
//                foo.third(printThird);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        // Start threads in a random order
//        thread3.start();
//        thread2.start();
//        thread1.start();
//
//        // Wait for all threads to complete
//        thread1.join();
//        thread2.join();
//        thread3.join();
//
//        // Verify the output is "firstsecondthird"
//        Assertions.assertEquals("firstsecondthird", output.toString());
//    }
//
//    @Test
//    public void testThreadOrderWithExecutorService() throws InterruptedException {
//        // Create a StringBuilder to capture the output
//        StringBuilder output = new StringBuilder();
//
//        // Create a java.FooOriginal.Main.Main.azki.Foo object
//        Foo foo = new Foo();
//
//        // Create Runnable tasks that append "first", "second", and "third" to the output
//        Runnable printFirst = () -> output.append("first");
//        Runnable printSecond = () -> output.append("second");
//        Runnable printThird = () -> output.append("third");
//
//        // Create an ExecutorService to run the tasks in random order
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//
//        // Submit tasks in a random order
//        executorService.submit(() -> {
//            try {
//                foo.third(printThird);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        executorService.submit(() -> {
//            try {
//                foo.second(printSecond);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        executorService.submit(() -> {
//            try {
//                foo.first(printFirst);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        // Shutdown executor and wait for tasks to complete
//        executorService.shutdown();
//        boolean terminated = executorService.awaitTermination(1, TimeUnit.MINUTES);
//        if (!terminated) {
//            System.out.println("Not all tasks finished within the timeout.");
//        }
//
//        // Verify the output is "firstsecondthird"
//        Assertions.assertEquals("firstsecondthird", output.toString());
//    }
}
