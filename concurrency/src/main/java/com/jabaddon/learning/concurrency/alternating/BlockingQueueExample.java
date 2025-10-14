package com.jabaddon.learning.concurrency.alternating;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> evenSignal = new ArrayBlockingQueue<>(1);
        BlockingQueue<Integer> oddSignal = new ArrayBlockingQueue<>(1);

        // First signal is even
        try {
            oddSignal.put(1); // number does not matter, just need to signal
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        new Thread(() -> {
            for (int i = 1; i <= 10; i += 2) {
                try {
                    oddSignal.take(); // Wait for signal
                    System.out.println("Odd: " + i);
                    evenSignal.put(1); // trigger even thread
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                try {
                    evenSignal.take(); // Wait for signal
                    System.out.println("Even: " + i);
                    oddSignal.put(1); // trigger odd thread
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}
