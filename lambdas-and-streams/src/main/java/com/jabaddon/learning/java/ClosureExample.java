package com.jabaddon.learning.java;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class ClosureExample {
    public static void main(String[] args) {
        Function<Integer, Integer> closure = closure();
        System.out.println(closure.apply(1));
        System.out.println(closure.apply(1));
        System.out.println(closure.apply(2));
        System.out.println(closure.apply(2));
    }

    private static Function<Integer, Integer> closure() {
        var atomic = new AtomicInteger(0);
        // returns closure (it is capturing the value of atomic)
        return i -> atomic.addAndGet(i);
    }
}
