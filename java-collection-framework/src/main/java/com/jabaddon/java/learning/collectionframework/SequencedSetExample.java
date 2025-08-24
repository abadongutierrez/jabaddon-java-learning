package com.jabaddon.java.learning.collectionframework;

import java.util.SequencedSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class SequencedSetExample {
    public static void main(String[] args) {
        SequencedSet<Integer> numbers = new TreeSet<>();
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);
        SequencedSet<Integer> reversed = numbers.reversed();

        for (Integer number : reversed) {
            System.out.println("number = " + number);
        }

    }
}
