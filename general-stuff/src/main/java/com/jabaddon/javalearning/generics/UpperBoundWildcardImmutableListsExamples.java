package com.jabaddon.javalearning.generics;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundWildcardImmutableListsExamples {
    public static void main(String[] args) {
        List<? extends Number> myNumbers = List.of(1, 2, 3, 4, 5, 6.7);
    }
}
