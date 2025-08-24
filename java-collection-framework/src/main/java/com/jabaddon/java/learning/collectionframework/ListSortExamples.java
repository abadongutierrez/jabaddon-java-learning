package com.jabaddon.java.learning.collectionframework;

import java.util.ArrayList;
import java.util.List;

public class ListSortExamples {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(
                List.of(9, 1, 2, 4, 5, 3, 6, 8, 7, 0));
        numbers.sort(null);
        for (Integer number : numbers) {
            System.out.println("number = " + number);
        }

    }
}
