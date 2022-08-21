package com.jabaddon.testing.readability.primitiveassertions;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimitiveAssertionsTest {

    @Test
    void assertingContainsStringWithPrimitiveAssert() {
        String out = "Real Text";
        assertTrue(out.indexOf("Text I am looking for") != -1);
    }

    @Test
    void assertingContainsStringWithBettgerAssert() {
        String out = "Real Text";
        assertThat(out, containsString("Text I am looking for"));
    }
}
