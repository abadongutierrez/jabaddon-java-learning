package com.jabaddon.learning.java.javaspecialistcourse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorExamples {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>(Arrays.asList("1", "2", "3"));

        // if you need thread safety
        List<String> tSafe = Collections.synchronizedList(Arrays.asList("1", "2", "3"));
    }
}
