package com.jabaddon.learning.java.javaspecialistcourse;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class NaturalOrderExample {
    public static void main(String[] args) {
        List<ToDo> todos = Arrays.asList(
                new ToDo(1, LocalDate.now().minusDays(1)),
                new ToDo(2, LocalDate.now().minusDays(1)),
                new ToDo(3, LocalDate.now()),
                new ToDo(4, LocalDate.now()));
        // sort by the natural order of the elements
        todos.sort(null);
        System.out.println("todos = " + todos);

        Comparator<ToDo> comparator = Comparator.comparing(ToDo::date).reversed().thenComparing(ToDo::priority);
        todos.sort(comparator);
        System.out.println("todos = " + todos);


        List<Integer> randomNumbers = ThreadLocalRandom.current().ints(10000).boxed().toList();
        Integer[] array = randomNumbers.toArray(new Integer[]{});
        Arrays.parallelSort(array);
        List<Integer> list = Arrays.asList(array);
        System.out.println("list = " + list);
    }

    private static record ToDo(int priority, LocalDate date) implements Comparable<ToDo> {
        @Override
        public int compareTo(ToDo o) {
            int compare = Integer.compare(priority, o.priority);
            return compare == 0 ? date.compareTo(o.date) : compare;
        }
    }
}
