package com.jabaddon.java.learning.collectionframework;

import java.util.List;

public class ListFindIndexExamples {
    public static void main(String[] args) {
        List<String> avengers = List.of(
                "Captain America", "Iron Man", "Spider Man", "Thor", "Scarlet Witch", "Thor");

        avengers.indexOf("Spider Man"); // -> 2
        avengers.lastIndexOf("Thor"); // -> 5
    }
}
