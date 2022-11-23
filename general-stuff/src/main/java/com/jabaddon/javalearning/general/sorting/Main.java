package com.jabaddon.javalearning.general.sorting;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private enum Priority {
        LOW, MID, HIGH
    }

    private record MyClass(Priority priority) {
    }

    public static void main(String[] args) {
        List<MyClass> list = List.of(new MyClass(Priority.HIGH), new MyClass(Priority.MID), new MyClass(Priority.LOW));
        List<MyClass> collect = list.stream().sorted(Comparator.comparing(MyClass::priority)).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(collect);
    }
}
