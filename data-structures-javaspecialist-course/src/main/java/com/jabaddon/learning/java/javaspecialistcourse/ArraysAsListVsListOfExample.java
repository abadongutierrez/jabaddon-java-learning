package com.jabaddon.learning.java.javaspecialistcourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAsListVsListOfExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        numbers.set(0, 0);
        System.out.println(numbers);

        try {
            numbers.clear();
        } catch (UnsupportedOperationException ex) {
            System.out.println("No sorry, you cannot clear a List from Arrays.asList");
        }

        List<Integer> numbers2 = List.of(1, 2, 3);

        try {
            numbers2.set(0, 0);
            System.out.println(numbers2);
        } catch (UnsupportedOperationException ex) {
            System.out.println("No sorry, you cannot set a List from List.of");
        }

        try {
            numbers2.clear();
        } catch (UnsupportedOperationException ex) {
            System.out.println("No sorry, you cannot clear a List from List.ofs");
        }
    }
}
