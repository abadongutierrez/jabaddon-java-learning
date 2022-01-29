package com.jabaddon.javalearning.general.javamemorymodel.example01;

public class SequencialExample {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        runnable.run();
        runnable.run();
        System.out.println("At the end, Count is " + runnable.getCount());
    }
}
