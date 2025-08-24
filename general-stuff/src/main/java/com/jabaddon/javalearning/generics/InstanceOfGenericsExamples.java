package com.jabaddon.javalearning.generics;

import java.util.ArrayList;
import java.util.List;

public class InstanceOfGenericsExamples {
    public static void main(String[] args) {
        List<Integer> myInts = new ArrayList<>();

        System.out.println(myInts instanceof List<Integer>);
        System.out.println(myInts instanceof List<? extends Integer>);
        System.out.println(myInts instanceof List<? extends Number>);
        System.out.println(myInts instanceof List<? super Integer>);
    }
}
