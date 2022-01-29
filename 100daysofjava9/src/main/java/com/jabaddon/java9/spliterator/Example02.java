package com.jabaddon.java9.spliterator;

import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Example02 {

    public static void main(String... args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        Stream<Integer> stream = StreamSupport.stream(new IntegerSpliterator(numbers.spliterator(), 10), false);

        stream.forEach(System.out::println);
    }

    private static class IntegerSpliterator implements Spliterator<Integer> {
        private final Spliterator<Integer> spliterator;
        private int number;

        public IntegerSpliterator(Spliterator<Integer> spliterator, int number) {
            this.spliterator = spliterator;
            this.number = number;
        }

        @Override
        public boolean tryAdvance(Consumer<? super Integer> action) {
            AtomicReference<Integer> aux = new AtomicReference<>();
            if (spliterator.tryAdvance(num -> aux.set(num))) {
                action.accept(number + aux.get());
            }
            return true;
        }

        @Override
        public Spliterator<Integer> trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return 0;
        }

        @Override
        public int characteristics() {
            return 0;
        }
    }
}
