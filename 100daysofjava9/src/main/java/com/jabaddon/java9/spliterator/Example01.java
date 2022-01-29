package com.jabaddon.java9.spliterator;

import java.util.List;
import java.util.Spliterator;

public class Example01 {

    public static void main(String... args) {
        List<Integer> ints = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ints.forEach(System.out::print);

        System.out.println("\n---- spliterator ----");
        Spliterator<Integer> spliterator = ints.spliterator();
        spliterator.tryAdvance(System.out::print);
        System.out.println("\n---- spliterator: remaining ----");
        spliterator.forEachRemaining(System.out::print);

        System.out.println("\n---- spliterator ----");
        Spliterator<Integer> spliterator1 = ints.spliterator();
        Spliterator<Integer> spliterator2 = spliterator1.trySplit();
        System.out.println("\n---- spliterator1: ----");
        spliterator1.forEachRemaining(System.out::print);
        System.out.println("\n---- spliterator2: ----");
        spliterator2.forEachRemaining(System.out::print);
    }
}
