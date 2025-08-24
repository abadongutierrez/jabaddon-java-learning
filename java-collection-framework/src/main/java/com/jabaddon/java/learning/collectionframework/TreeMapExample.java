package com.jabaddon.java.learning.collectionframework;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>(
                Map.of("C", 345, "A", 123, "D", 12, "B", 45667, "E", 124556));
        System.out.println("map = " + map);
        System.out.println("map.lastEntry() = " + map.lastEntry());
        System.out.println("map.firstEntry() = " + map.firstEntry());
        System.out.println("map.tailMap(\"C\") = " + map.tailMap("C"));
        System.out.println("map.lowerEntry(\"F\") = " + map.lowerEntry("F"));
        System.out.println("map.higherEntry(\"B\") = " + map.higherEntry("B"));
    }
}
