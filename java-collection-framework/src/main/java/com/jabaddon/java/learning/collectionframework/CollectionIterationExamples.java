package com.jabaddon.java.learning.collectionframework;

import java.util.Collection;
import java.util.Iterator;

public class CollectionIterationExamples {
    public static void main(String[] args) {
        // Iterar una coleccion con for-each
        Collection<Integer> numbers = FactoryMethods.createCollection(1, 2, 3);

        for (Integer number : numbers) {
            System.out.println("number = " + number);
        }

        // Iterar una coleccion con Iterator
        Collection<Integer> moreNumbers = FactoryMethods.createCollection(100, 200, 300, 400);

        Iterator<Integer> it = moreNumbers.iterator();
        while (it.hasNext()) {
            System.out.println("value = " + it.next());
        }
    }

}
