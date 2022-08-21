package com.jabaddon.java.learning.monads;

import java.util.Optional;

public class App {
    
    public static void main(String[] args) {
        // sum returns Optinal<Integer>
        // divideBy2 returns Optional<Integer>
        // map wraps the value in Optional<T>
        // so get return Optional<Integer>
        System.out.println(sum(2, 2).map(App::divideBy2).get());
        // map wraps the value in flat Optional<T>
        // so get returns Integer
        System.out.println(sum(2, 2).flatMap(App::divideBy2).get());
    }

    public static Optional<Integer> sum(Integer a, Integer b) {
        return Optional.of(a + b);
    }

    public static Optional<Integer> divideBy2(Integer num) {
        return Optional.of(num / 2);
    }
}
