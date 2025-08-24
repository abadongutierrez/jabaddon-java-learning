package com.jabaddon.java.learning.collectionframework;

import java.time.Period;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class PriorityQueueIterationExample {
    public static void main(String[] args) {
        PriorityQueue<Person> persons = new PriorityQueue<>();
        persons.add(new Person(30));
        persons.add(new Person(31));
        persons.add(new Person(29));
        persons.add(new Person(78));
        persons.add(new Person(60));

        System.out.println("persons.toString() = " + persons);
        persons.forEach(System.out::println);
        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }
        List<Person> list = Stream.generate(persons::poll).takeWhile(Objects::nonNull).toList();
        System.out.println("list = " + list);
        List<Person> limit = Stream.generate(persons::poll).limit(2).toList();
        System.out.println("limit = " + limit);
    }
}
