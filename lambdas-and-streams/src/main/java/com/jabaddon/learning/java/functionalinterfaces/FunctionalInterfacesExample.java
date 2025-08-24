package com.jabaddon.learning.java.functionalinterfaces;

import java.util.function.Function;

public class FunctionalInterfacesExample {
    public static void main(String[] args) {

        Function<String, Integer> fromStringToIntFun = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        };

        Function<Integer, String> fromIntegerToStringFun = (i) -> String.valueOf(i);

        Function<String, String> allFuns = fromStringToIntFun.andThen(fromIntegerToStringFun);

        System.out.printf("%s -> %b", "12", allFuns.apply("12").equals("12"));
    }


    static abstract class AbstractClass implements Function<String, Integer> {
        public abstract Integer apply(String s);

        public void anotherMethod() {
            System.out.println("here!");
        }
    }
}
