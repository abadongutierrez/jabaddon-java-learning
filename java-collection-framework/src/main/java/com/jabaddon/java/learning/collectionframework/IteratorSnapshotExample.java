package com.jabaddon.java.learning.collectionframework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class IteratorSnapshotExample {
    public static void main(String[] args) {
        List<Integer> numbers = new CopyOnWriteArrayList<>(List.of(1, 2, 3, 4, 5));
        Iterator<Integer> snapshot = numbers.iterator();

        numbers.removeLast();
        System.out.println("numbers = " + numbers);

        while (snapshot.hasNext()) {
            System.out.println(snapshot.next());
        }
    }
}
