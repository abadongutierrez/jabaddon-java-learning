package com.jabaddon.learning.java.functionalinterfaces;

import java.math.BigDecimal;
import java.util.function.Function;

public class JavaClosureIshExample {
    public static void main(String[] args) {

        double percentage = 0.02;
        BigDecimal value = new BigDecimal(1000);

        Function<BigDecimal, BigDecimal> twoPercentLambda =
                (v) -> v.multiply(BigDecimal.ONE.add(BigDecimal.valueOf(percentage)));

        computeAndPrintValue(value, twoPercentLambda);
        // percentage = 0.05;
        // error: local variables referenced from a lambda expression must be final or effectively final
        computeAndPrintValue(value, twoPercentLambda);

        XPercentageClass clazz = new XPercentageClass(0.02);
        computeAndPrintValue(value, clazz);
        clazz.changePercentage(0.05);
        computeAndPrintValue(value, clazz);
    }

    private static void computeAndPrintValue(BigDecimal value, Function<BigDecimal, BigDecimal> func) {
        System.out.println(func.apply(value));
    }

    private static class XPercentageClass implements Function<BigDecimal, BigDecimal> {
        private double percentage;

        XPercentageClass(double p) {
            percentage = p;
        }

        void changePercentage(double p) {
            percentage = p;
        }

        @Override
        public BigDecimal apply(BigDecimal value) {
            return value.multiply(BigDecimal.ONE.add(BigDecimal.valueOf(percentage)));
        }
    }
}
