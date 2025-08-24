package com.jabaddon.java.learning.collectionframework;

import java.util.Arrays;
import java.util.List;

public class ListIterationExamples {
    public static void main(String[] args) {
        List<String> avengers = Arrays.asList(
                "Iron Man", "El Hombre Verde", "Thor", "Captain America");

        avengers.set(1, "Hulk");
        //avengers.add("Ant-man"); // UnsupportedOperationException

        for (String item: avengers) {
            System.out.println("item = " + item);
        }


        List<String> justiceLeague = List.of(
                "Superman", "Batman", "Wonder Woman", "La Sirenita");

        //justiceLeague.set(4, "Aquaman"); // UnsupportedOperationException
        //justiceLeague.add("Flash"); // UnsupportedOperationException

        for (int i = 0; i < justiceLeague.size(); i++) {
            System.out.println("item = " + justiceLeague.get(i));
        }
    }
}
