package com.jabaddon.java.learning.collectionframework;

import java.util.HashMap;
import java.util.Map;

public class MapFactoryMethodExamples {
    public static void main(String[] args) {
        Map<String, Integer> numbers = Map.of("Uno", 1, "Dos", 2, "Tres", 3);
        System.out.println("numbers.keySet() = " + numbers.keySet());
        System.out.println("numbers.values() = " + numbers.values());


        Map<String, Integer> otherNumbers = new HashMap<>(Map.of("Uno", 1, "Dos", 2, "Tres", 3));
        otherNumbers.put("Cuatro", 4);
        otherNumbers.putIfAbsent("Cinco", 5);
        otherNumbers.computeIfAbsent("Seis", (k) -> 6);
        otherNumbers.computeIfPresent("Dos", (k, v) -> v * 2);
        System.out.println("otherNumbers = " + otherNumbers);
    }
}
