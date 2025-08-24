package com.jabaddon.learning.java.javaspecialistcourse;

import java.util.*;

public class ListExamples {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println(numbers);

        List<String> names = Arrays.asList("John", "Sara", "Arnold");
        System.out.println(names);

        // names is immutable?
        names.set(1, "Sarita");
        System.out.println(names);

        // can I add a value to names?
        try {
            names.add("T-1000");
            System.out.println("I can add values!");
        } catch (UnsupportedOperationException ex) {
            System.out.println("I can NOT add values!");
        }

        try {
            names.clear();
            System.out.println("I can clear!");
        } catch (UnsupportedOperationException ex) {
            System.out.println("I can NOT clear!");
        }

        System.out.println(names.getClass().getSimpleName());
        System.out.println(names instanceof ArrayList);
        System.out.println(names.getClass().getCanonicalName());

        System.out.println(numbers.indexOf(1));
        System.out.println(numbers.lastIndexOf(3));
        numbers.addFirst(0);
        System.out.println(numbers);
        numbers.addLast(4);
        System.out.println(numbers);

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        ListIterator<Integer> integerListIterator = numbers.listIterator();
        while (integerListIterator.hasNext()) {
            System.out.println(integerListIterator.next());
        }

        ListIterator<Integer> backwardIterator = numbers.listIterator(numbers.size());
        while (backwardIterator.hasPrevious()) {
            System.out.println(backwardIterator.previous());
        }
    }
}
