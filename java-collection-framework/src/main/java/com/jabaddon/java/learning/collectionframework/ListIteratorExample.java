package com.jabaddon.java.learning.collectionframework;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        ListIterator<Integer> litForward = numbers.listIterator();
        while (litForward.hasNext()) {
            System.out.println("next = " + litForward.next());
        }

        ListIterator<Integer> litBackward = numbers.listIterator(numbers.size());
        while (litBackward.hasPrevious()) {
            System.out.println("previous = " + litBackward.previous());
        }
    }
}
