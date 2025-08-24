package com.jabaddon.learning.java.streams;

import java.util.stream.IntStream;

public class IntStreamIterateExample {
    public static void main(String[] args) {
        IntStream.iterate(0, i -> i + 1).limit(100).forEach(System.out::println);

        IntStream.iterate(0, i -> i + 1).limit(10).peek(i -> System.out.println("i+1 = " + (i + 1)))
                .count();
    }
}
