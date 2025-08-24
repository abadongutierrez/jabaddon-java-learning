package com.jabaddon.learning.java.javaspecialistcourse;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AddingToHeadListsVsExamples {
    public static void main(String[] args) {
        for (int n = 1000; n <= 1024 * 1000; n *= 2) {
            List<Integer> input = IntStream.range(0, n).boxed().collect(Collectors.toList());
            test(new LinkedList<>(input), list -> list.remove(0), (list, element) -> list.addFirst(element));
            test(new ArrayList<>(input), list -> list.remove(0), (list, element) -> list.addFirst(element));
            test(new ArrayDeque<>(input), Deque::removeFirst, Deque::addFirst);
            test(new ConcurrentLinkedDeque<>(input), Deque::removeFirst, Deque::addFirst);
        }
    }

    private static <E extends Collection<Integer>> void test(E list, Function<E, Integer> remove,
                                                             BiConsumer<E, Integer> add) {
        System.out.printf("%s(%d) ", list.getClass().getTypeName(), list.size());
        AtomicBoolean running = new AtomicBoolean(true);
        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                running.set(false);
                timer.cancel();
            }
        }, 1000);
        long removeAddCounter = 0;
        while (running.get()) {
            Integer element = remove.apply(list);
            add.accept(list, element);
            removeAddCounter++;
        }
        System.out.printf(Locale.US, "\t%,d%n", removeAddCounter);
    }
}
