package com.jabaddon.learning.java.javaspecialistcourse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetExamples {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 4, 5));
        System.out.println("numbers = " + numbers);

        try {
            numbers = Set.of(1, 2, 3, 4, 4, 5);
            System.out.println("numbers = " + numbers);
        } catch (IllegalArgumentException ex) {
            System.out.println("You tried to add a duplicate!");
        }


        Set<Integer> zeroToFive = new HashSet<>();
        zeroToFive.add(1);
        zeroToFive.add(2);
        zeroToFive.add(3);
        zeroToFive.add(3);
        zeroToFive.add(4);
        zeroToFive.add(5);
        System.out.println("zeroToFive = " + zeroToFive);
        
        Set<Integer> fiveToNine = new HashSet<>();
        fiveToNine.add(5);
        fiveToNine.add(6);
        fiveToNine.add(7);
        fiveToNine.add(8);
        fiveToNine.add(8);
        fiveToNine.add(9);
        System.out.println("fiveToNine = " + fiveToNine);

        zeroToFive.addAll(fiveToNine);
        System.out.println("zeroToFive = " + zeroToFive);


        zeroToFive.retainAll(fiveToNine);
        System.out.println("zeroToFive = " + zeroToFive);
    }
}
