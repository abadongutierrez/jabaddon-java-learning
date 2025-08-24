package com.jabaddon.java.learning.collectionframework;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

public class SetFactoryMethodExample {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5);
        System.out.println("numbers = " + numbers);

        Set<Integer> uniqueNumbers = ThreadLocalRandom.current().ints(1000, 0, 5).boxed().collect(Collectors.toSet());
        System.out.println("uniqueNumbers = " + uniqueNumbers);
    }
}
