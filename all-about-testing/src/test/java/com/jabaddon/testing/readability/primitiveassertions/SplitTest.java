package com.jabaddon.testing.readability.primitiveassertions;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class SplitTest {
    private Account account;
    private Split split;
    private BudgetCategory bc1, bc2, bc3, bc4;

    @BeforeEach
    void setup() {
        // ...
    }

    @Test
    void testFromSplits() {
        List<TransactionSplit> fromSplits = List.of(createSplit(bc3, 1200), createSplit(bc4, 34));
        Transaction t = createTransaction(split, account);
        t.setFromSplits(fromSplits);
        assertThat(transactions(t), hasSize(1));
    }

    @Test
    void testToSplits() {
        List<TransactionSplit> toSplits = List.of(createSplit(bc1, 1200), createSplit(bc2, 34));
        Transaction t = createTransaction(account, split);
        t.setToSplits(toSplits);
        assertThat(transactions(t), hasSize(1));
    }

    private List<Transaction> transactions(Transaction t) {
        return null;
    }

    private TransactionSplit createSplit(BudgetCategory bc3, int i) {
        return null;
    }

    private Transaction createTransaction(Source from, Source destination) {
        return null;
    }
}
