package com.jabaddon.learning.java.lambdas;

import java.util.*;

public class LambdasVsAnonClassesExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Luke", "Vader", "Leia", "Han", "Anakin", "Obi-wan");

        // <1>
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        System.out.println(names);

        // <2>
        Collections.shuffle(names);
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
        System.out.println(names);

        // <3>
        Collections.shuffle(names);
        Collections.sort(names, String::compareTo);
        System.out.println(names);

        // <4>
        Collections.shuffle(names);
        names.sort(String::compareTo);
        System.out.println(names);
    }
}