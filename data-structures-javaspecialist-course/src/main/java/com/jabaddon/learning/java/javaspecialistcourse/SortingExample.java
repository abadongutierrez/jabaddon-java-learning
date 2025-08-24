package com.jabaddon.learning.java.javaspecialistcourse;

import java.util.Arrays;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        System.out.println("numbers = " + numbers);
        numbers.sort(null);
        System.out.println("numbers = " + numbers);
        List<Integer> reversed = numbers.reversed();
        System.out.println("reversed = " + reversed);
    }
}
