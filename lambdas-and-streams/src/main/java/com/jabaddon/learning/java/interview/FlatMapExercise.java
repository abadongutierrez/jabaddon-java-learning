package com.jabaddon.learning.java.interview;

import java.util.Collection;
import java.util.List;

public class FlatMapExercise {
    public static void main(String[] args) {
        List<List<Integer>> lists = List.of(
                List.of(1,2,3),
                List.of(4,5),
                List.of(6),
                List.of(7,8,9,10)
        );
        System.out.println(lists);

        // solution
        System.out.println(lists.stream().flatMap(Collection::stream).toList());
    }
}
