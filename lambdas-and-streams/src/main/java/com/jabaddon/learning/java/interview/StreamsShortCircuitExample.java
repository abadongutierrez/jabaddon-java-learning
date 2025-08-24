package com.jabaddon.learning.java.interview;

import java.util.List;

public class StreamsShortCircuitExample {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4);

        integers.stream()
                .peek(i -> System.out.println("i = " + i))
                .limit(2)
                .forEach(System.out::println);
        System.out.println("------");
        integers.stream()
                .peek(i -> System.out.println("i = " + i))
                .skip(2)
                .forEach(System.out::println);
    }
}
