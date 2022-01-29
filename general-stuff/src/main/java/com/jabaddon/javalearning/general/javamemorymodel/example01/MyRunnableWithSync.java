package com.jabaddon.javalearning.general.javamemorymodel.example01;

public class MyRunnableWithSync implements Runnable {
    private int count;

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            synchronized (this) {
                count++;
            }
        }
        synchronized (this) {
            System.out.printf("Count (in thread: %s) is: %d\n", Thread.currentThread().getName(), count);
        }
    }

    public synchronized int getCount() {
        return count;
    }
}
