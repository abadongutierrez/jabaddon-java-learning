package com.jabaddon.java.learning.collectionframework;

import java.util.Collection;

public class CollectionRemoveIfExample {
    public static void main(String[] args) {
        Collection<Integer> numbers = FactoryMethods.createCollection(1, 2, 3);
        numbers.removeIf(item -> item <= 2);
        System.out.println("numbers = " + numbers);
    }
}
