package com.jabaddon.java.learning.collectionframework;

import java.util.PriorityQueue;

public class PriorityQueueAgeExample {
    public static void main(String[] args) {
        PriorityQueue<Person> queueByAge = new PriorityQueue<>();
        queueByAge.add(new Person(30));
        queueByAge.add(new Person(31));
        queueByAge.add(new Person(29));
        // cashier calls next person (by priority)
        System.out.println("queueByAge.poll() = " + queueByAge.poll());
        queueByAge.add(new Person(78));
        queueByAge.add(new Person(60));
        // cashier calls next person (by priority)
        System.out.println("queueByAge.poll() = " + queueByAge.poll());
        // cashier looks at the queue
        System.out.println("queueByAge = " + queueByAge);
        while (!queueByAge.isEmpty()) {
            System.out.println("queueByAge = " + queueByAge.poll());
        }
    }
}
