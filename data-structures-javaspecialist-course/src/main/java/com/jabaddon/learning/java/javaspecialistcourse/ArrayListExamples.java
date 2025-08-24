package com.jabaddon.learning.java.javaspecialistcourse;

import java.util.ArrayList;

public class ArrayListExamples {
    public static void main(String[] args) {
        ArrayList<String> days = new ArrayList<>(3);
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        System.out.println(days);

        System.out.println("days.get(0) = " + days.get(0));

        for (int i = 0; i < 1000; i++) {
            days.add("Weird day");
        }

        days.removeIf(item -> item.equals("Weird day"));
        System.out.println(days);

        days.trimToSize(); // DO NOT USE!
    }
}
