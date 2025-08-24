package com.jabaddon.learning.java.functionalinterfaces;

import java.math.BigDecimal;
import java.util.function.Function;

public class MethodReferencesExample {
    public static void main(String[] args) {
        Function<BigDecimal, BigDecimal> twoPercLambda = (i) -> i.multiply(BigDecimal.ONE.add(BigDecimal.valueOf(0.02)));
        XPerc twoPercRecord = new XPerc(2);

        BigDecimal salary = BigDecimal.valueOf(2000.0);
        System.out.println(someVeryComplexProcessOverSalary(salary, twoPercLambda));
        System.out.println(someVeryComplexProcessOverSalary(salary, twoPercRecord::compute));
    }

    private static BigDecimal someVeryComplexProcessOverSalary(BigDecimal salary, Function<BigDecimal, BigDecimal> percFunction) {
        return percFunction.apply(salary);
    }

    record XPerc(int perc) {
        public BigDecimal compute(BigDecimal amount) {
            var percBd = BigDecimal.valueOf(perc / 100.0);
            return amount.multiply(BigDecimal.ONE.add(percBd));
        }
    }
}
