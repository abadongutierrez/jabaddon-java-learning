package com.jabaddon.java.learning.collectionframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FactoryMethods {
    static Collection<Integer> createCollection(Integer... number) {
        return new ArrayList<>(Arrays.stream(number).toList());
    }

    public static List<String> createList(String... names) {
        return new ArrayList<>(Arrays.stream(names).toList());
    }
}
