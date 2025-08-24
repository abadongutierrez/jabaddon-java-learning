package com.jabaddon.learning.java.javaspecialistcourse;

import java.util.ArrayList;
import java.util.List;

public class IteratingVsExample {
    public static void main(String[] args) {
        int[] array = new int[10000];
        List<Integer> list = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            array[i] = i+1;
            list.add(i+1);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 10000; j++) {
                int value = array[j] + 1;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 10000; j++) {
                int value = list.get(j) + 1;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
    }
}
