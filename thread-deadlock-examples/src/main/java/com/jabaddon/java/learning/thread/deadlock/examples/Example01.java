package com.jabaddon.java.learning.thread.deadlock.examples;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example01 {
    private static final Lock lockA = new ReentrantLock();
    private static final Lock lockB = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        var t1 = new Thread(() -> processingAThenB());
        t1.setName("thread-A");
        var t2 = new Thread(() -> processingBThenA());
        t2.setName("thread-B");
        
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    public static void processingAThenB() {
        lockA.lock();
        // some processing
        lockB.lock();
        // some processing
        lockB.unlock();
        lockA.unlock();
    }

    public static void processingBThenA() {
        lockB.lock();
        // some processing
        lockA.lock();
        // some processing
        lockA.unlock();
        lockB.unlock();
    }
}
