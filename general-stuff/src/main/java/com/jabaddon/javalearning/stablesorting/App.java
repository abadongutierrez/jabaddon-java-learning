package com.jabaddon.javalearning.stablesorting;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        var now = LocalDate.now();
        var list = List.of(
                new ToDo(1, now.minusDays(2), "t1-2"),
                new ToDo(2, now.minusDays(2), "t2-2"),
                new ToDo(3, now.minusDays(2), "t3-2"),
                new ToDo(1, now.minusDays(5), "t1-5"),
                new ToDo(2, now.minusDays(5), "t2-5"),
                new ToDo(3, now.minusDays(5), "t3-5"),
                new ToDo(1, now, "t1-0"),
                new ToDo(2, now, "t1-0"),
                new ToDo(3, now, "t1-0")
        );

        Comparator<ToDo> comparator1 = Comparator.comparing(ToDo::priority).thenComparing(ToDo::dueDate);
        Comparator<ToDo> comparator2 = Comparator.comparing(ToDo::dueDate).thenComparing(ToDo::priority);

        list.stream().toList().forEach(System.out::println);
        System.out.println("---");
        list.stream().sorted(comparator1).toList().forEach(System.out::println);
        System.out.println("---");
        list.stream().sorted(comparator2).toList().forEach(System.out::println);
    }
}
