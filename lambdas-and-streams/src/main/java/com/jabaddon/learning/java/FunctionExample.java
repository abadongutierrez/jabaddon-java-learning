package com.jabaddon.learning.java;

import java.util.List;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        List<String> values = List.of("hi", "there", "how", "are", "you");
        var list = toUpperCase(values, (v) -> v.toUpperCase());
        System.out.println("list = " + list);
    }

    private static List<String> toUpperCase(List<String> values, Function<String, String> f) {
        return values.stream().map(f).toList();
    }
}
