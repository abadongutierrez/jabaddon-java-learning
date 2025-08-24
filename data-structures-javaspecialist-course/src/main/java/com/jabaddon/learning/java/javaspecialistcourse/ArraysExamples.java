package com.jabaddon.learning.java.javaspecialistcourse;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysExamples {
    public static void main(String[] args) {
        System.out.println("Arrays Examples");
        
        int[] values = {1, 2, 3};
        System.out.println(Arrays.stream(values).boxed().toList());

        String[] names = {"John", "Arnold", "Sara"};
        String[] newNames = new String[names.length + 1];
        System.arraycopy(names, 0, newNames, 0, names.length);
        newNames[names.length] = "New";
        System.out.println(Arrays.stream(newNames).toList());

        System.out.println(values.getClass().getSuperclass().getSimpleName());
        System.out.println(values.getClass().getSuperclass().isArray());
        int[][][] multidimensional = {{{}}};
        System.out.println(multidimensional.getClass().getSuperclass().getSimpleName());
        System.out.println(multidimensional.getClass().getSuperclass().isArray());

        if (values instanceof Object) System.out.println("Its an object");
        if (multidimensional instanceof Object[]) System.out.println("Its an Ob");
    }
}
