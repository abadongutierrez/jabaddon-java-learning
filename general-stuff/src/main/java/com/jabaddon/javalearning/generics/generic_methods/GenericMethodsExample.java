package com.jabaddon.javalearning.generics.generic_methods;

public class GenericMethodsExample {
    public static void main(String[] args) {
        TrickyExample<Integer> trickyExample = new TrickyExample<>();
        System.out.println(trickyExample.trickyMethod("hi there!"));
    }
}

record TestCase<T>(T t) {}

// Example using static methods and generic parameters
class Handler {
    public static <T> void prepare(T t) {

    }

    public static <T> TestCase<T> run(T t) {
        return null;
    }
}

class TrickyExample<T> {
    public T returnType() {
        return null;
    }

    // T here hides the type parameter T in class
    public <T> T trickyMethod(T t) {
        return t;
    }
}