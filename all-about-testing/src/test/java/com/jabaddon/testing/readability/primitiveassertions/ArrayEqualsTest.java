package com.jabaddon.testing.readability.primitiveassertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayEqualsTest {
    @Test
    void arrayEquals() {
        String myString = "hello there";
        int intValue = 10;
        assertTrue(new Object[]{myString, intValue}.equals(new Object[]{myString, intValue}));
    }
}
