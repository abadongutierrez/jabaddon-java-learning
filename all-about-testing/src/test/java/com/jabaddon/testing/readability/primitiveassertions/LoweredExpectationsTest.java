package com.jabaddon.testing.readability.primitiveassertions;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class LoweredExpectationsTest {
    private FraudDetector fraudDetector;

    @Test
    void testCreditCardFraudDetection() {
        Customer customer = createCustomerWithExpenses();
        fraudDetector.loadHistory(customer.expensesHistoryFromLast(30, TimeUnit.DAYS)); 
        double result = fraudDetector.analyze(new Expense("MXN", 350000.00, Location.of("BR")));
        assertThat(result, is(greaterThan(0.0)));
    }

    private Customer createCustomerWithExpenses() {
        return null;
    }

    private Customer createCustomerWithGoodExpensesHistory() {
        return null;
    }

    private Customer createCustomer() {
        return null;
    }

    private class FraudDetector {
        public void loadHistory(Object expensesHistoryFromLast) {
        }

        public double analyze(Expense expense) {
            return 0;
        }
    }

    private record Expense(String mxn, double v, Object of) {
    }

    private static class Location {
        public static Object of(String br) {
            return null;
        }
    }
}
