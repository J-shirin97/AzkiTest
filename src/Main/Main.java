package Main;

import Main.azki.FooThreads;

public class Main {
    public static void main(String[] args) {

        FooThreads fooThreads = new FooThreads();

        fooThreads.threadA.start();
        fooThreads.threadB.start();
        fooThreads.threadC.start();

    }
}