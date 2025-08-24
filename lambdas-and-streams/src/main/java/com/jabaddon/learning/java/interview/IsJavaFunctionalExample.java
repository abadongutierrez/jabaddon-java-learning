package com.jabaddon.learning.java.interview;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class IsJavaFunctionalExample {
    public static void main(String[] args) {
        int counter = 0;
        List<String> values = List.of("A", "B", "C");

        // COMPILATION ERROR: Variable used in lambda expression should be final or effectively final
        //Consumer<String> forEachLambda = i -> System.out.println("(i + counter++) = " + (i + counter++));
        //values.forEach(forEachLambda);

        // Let's try to create a clousure wint the primitive counter variable
        Supplier<String> supplierFun = () -> "Value of counter = " + counter;
        System.out.println(supplierFun.get());
        //counter++; // only when trying to modify the counter is when the compilation error happens
        System.out.println(supplierFun.get());

        // Let's try to create a clousure with the n AtomicInteger
        AtomicInteger aCounter = new AtomicInteger(0);
        Supplier<String> supplierFun2 = () -> "Value of counter = " + aCounter;
        System.out.println(supplierFun2.get());
        aCounter.incrementAndGet();
        System.out.println(supplierFun2.get());
    }
}
