package com.jabaddon.learning.java.functionalinterfaces;

import java.text.DecimalFormat;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PipeOperatorExample {
    public static void main(String[] args) {

        Function<String, Double> strToDouble = Double::valueOf;
        Function<Double, Double> plus2Perc = (i) -> i * 1.02;
        Function<Double, Double> round2Decimals = (d) -> Math.round(d * 100.0) / 100.0;

        Double v1 = strToDouble.apply("8000.56");
        v1 = plus2Perc.apply(v1);
        v1 = round2Decimals.apply(v1);
        // v1 = 8160.57

        Double v2 = strToDouble.andThen(plus2Perc).andThen(round2Decimals).apply("8000.56");
        // v2 = 8160.57

        System.out.println(v1);
        System.out.println(v2);
    }
}
