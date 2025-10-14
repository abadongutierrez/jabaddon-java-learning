package com.jabaddon.learning.concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        System.out.println("Hello, Semaphore!");
        // permits = 1 -> means it can be acquired by one thread
        Semaphore oddTurn = new Semaphore(1);
        // permits = 0 -> means it cannot be acquired by any thread
        Semaphore evenTurn = new Semaphore(0);

        new Thread(() -> {
            for (int i = 1; i <= 10; i += 2) {
                try {
                    oddTurn.acquire();
                    System.out.println("Odd: " + i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    evenTurn.release();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                try {
                    evenTurn.acquire();
                    System.out.println("Even: " + i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    oddTurn.release();
                }
            }
        }).start();
    }
}
