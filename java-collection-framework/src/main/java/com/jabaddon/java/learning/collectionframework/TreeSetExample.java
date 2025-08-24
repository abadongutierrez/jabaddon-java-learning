package com.jabaddon.java.learning.collectionframework;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<String> abc = new TreeSet<>(Set.of("C", "E", "A", "D", "B", "G", "F"));
        System.out.println("abc = " + abc);
        System.out.println("abc.last() = " + abc.last());
        System.out.println("abc.first() = " + abc.first());
        System.out.println("abc.tailSet(\"C\") = " + abc.tailSet("C"));
        System.out.println("abc.lower(\"F\") = " + abc.lower("F"));
        System.out.println("abc.higher(\"B\") = " + abc.higher("B"));
    }
}
