package com.jabaddon.learning.java.javaspecialistcourse;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteIteratorExample {
    public static void main(String[] args) {
        List<String> numbers = removeItemsWithO(new CopyOnWriteArrayList<>(List.of("One", "Two", "Three")));
        System.out.println("numbers = " + numbers);

        try {
            numbers = removeItemsWithO(new ArrayList<>(List.of("One", "Two", "Three")));
            System.out.println("numbers = " + numbers);
        } catch (Exception ex) {
            System.out.println("Ignoring ex = " + ex);
        }

        List<String> strings = new CopyOnWriteArrayList<>(List.of("One", "Two", "Three"));
        Iterator<String> itSnapshot1 = strings.iterator();
        strings.remove("Three");
        System.out.println("strings = " + strings);
        System.out.println("itSnapshot1 = " + toList(itSnapshot1));
    }

    private static List<String> toList(Iterator<String> itSnapshot1) {
        List<String> newList = new ArrayList<>();
        while (itSnapshot1.hasNext()) {
            String next = itSnapshot1.next();
            newList.add(next);
        }
        return Collections.unmodifiableList(newList);
    }

    private static List<String> removeItemsWithO(List<String> numbers) {
        for (String number : numbers) {
            if (number.contains("o") || number.contains("O")) {
                numbers.remove(number);
            }
        }
        return numbers;
    }
}
