package com.jabaddon.learning.java.javaspecialistcourse;

import java.util.*;

public class IteratorExamples {
    public static void main(String[] args) {
        Vector<String> v = new Vector<>(Arrays.asList("One", "Two", "Three"));
        Enumeration<String> enumeration = v.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

        enumeration = v.elements();
        while (enumeration.hasMoreElements()) {
            String s = enumeration.nextElement();
            if (s.contains("o") || s.contains("O")) {
                v.remove(s);
            }
        }

        System.out.println("v = " + v);

        removeElementsWithOV1(new ArrayList<>(Arrays.asList("One", "Two", "Three")));
        removeElementsWithOV2(new ArrayList<>(Arrays.asList("One", "Two", "Three")));
    }

    private static void removeElementsWithOV1(List<String> l) {
        Iterator<String> iterator = l.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.contains("o") || next.contains("O")) {
                iterator.remove();
            }
        }

        System.out.println("l = " + l);
    }

    private static void removeElementsWithOV2(List<String> l) {
        Iterator<String> iterator = l.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.contains("o") || next.contains("O")) {
                l.remove(next);
            }
        }

        System.out.println("l = " + l);
    }
}
