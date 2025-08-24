package com.jabaddon.learning.java.interview;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamAlreadyClosed01Example {
    public static void main(String[] args) {
        IntStream intStream = List.of(1, 2, 3, 4, 5).stream().mapToInt(n -> n);

        IntStream intStream2 = intStream;

        OptionalInt min = intStream.min();
        OptionalInt max = intStream2.max();

        int sum = min.orElse(5) + min.orElse(5);

        System.out.println("sum = " + sum);
    }
}
