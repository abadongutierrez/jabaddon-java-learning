package com.jabaddon.java.learning.collectionframework;

public record Person(int age) implements Comparable<Person> {
    @Override
    public int compareTo(Person o) {
        return Integer.compare(o.age, age);
    }
}
