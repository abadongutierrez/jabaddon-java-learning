package com.jabaddon.javalearning.general.javamemorymodel.example01;

public class ThreadsDiffInstancesExample {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable1 = new MyRunnable();
        MyRunnable runnable2 = new MyRunnable();

        Thread thread1 = new Thread(runnable1, "Thread 1");
        Thread thread2 = new Thread(runnable2, "Thread 2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("At the end, Count is " + runnable1.getCount());
        System.out.println("At the end, Count is " + runnable2.getCount());
    }
}
