package com.jabaddon.javalearning.general.javamemorymodel.example01;

public class ThreadsSharingWithSyncExample {
    public static void main(String[] args) throws InterruptedException {
        MyRunnableWithSync runnable1 = new MyRunnableWithSync();

        Thread thread1 = new Thread(runnable1, "Thread 1");
        Thread thread2 = new Thread(runnable1, "Thread 2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("At the end, Count is " + runnable1.getCount());
    }
}
