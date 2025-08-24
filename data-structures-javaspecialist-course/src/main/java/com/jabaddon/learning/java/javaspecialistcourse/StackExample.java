package com.jabaddon.learning.java.javaspecialistcourse;

import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedDeque;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println("next = " + next);
        }

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            System.out.println("pop = " + pop);
        }

        // do no use it, instead use
        Deque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.push(3);
        deque.push(2);
        deque.push(1);

        Iterator<Integer> iterator1 = deque.iterator();
        while (iterator1.hasNext()) {
            Integer next = iterator1.next();
            System.out.println("next = " + next);
        }
    }
}
