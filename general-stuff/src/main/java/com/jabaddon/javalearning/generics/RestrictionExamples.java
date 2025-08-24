package com.jabaddon.javalearning.generics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestrictionExamples {
    public static void main(String[] args) {
        List<Number> myNumbers = new ArrayList<>();
        myNumbers.add(1);
        myNumbers.add(2.0);
        myNumbers.add(new BigDecimal("3"));
        System.out.println(sumList(myNumbers));

        List<Integer> myIntegers = new ArrayList<>();
        myIntegers.add(1);
        myIntegers.add(2);
        myIntegers.add(3);
        System.out.println(sumList(myIntegers)); // why???

        List<Double> myDoubles = new ArrayList<>();
        myDoubles.add(1.0);
        myDoubles.add(2.0);
        myDoubles.add(3.0);
        System.out.println(sumList(myDoubles)); // why???
    }

    private static double sumList(List<? extends Number> numbers) {
        return numbers.stream().mapToDouble(Number::doubleValue).sum();
    }
}
