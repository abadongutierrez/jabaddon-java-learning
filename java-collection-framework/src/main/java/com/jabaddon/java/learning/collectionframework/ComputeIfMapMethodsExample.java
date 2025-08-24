package com.jabaddon.java.learning.collectionframework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class ComputeIfMapMethodsExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        List<Integer> numbers = ThreadLocalRandom.current().ints(1000, 0, 100).boxed().toList();
        for (Integer number : numbers) {
            map.compute(number % 2 == 0 ? "odd" : "even", (k, v) -> v == null ? 1 : v + 1);
        }

        System.out.println("map = " + map);
    }
}
