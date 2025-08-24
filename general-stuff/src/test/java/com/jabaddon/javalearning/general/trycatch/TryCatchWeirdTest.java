package com.jabaddon.javalearning.general.trycatch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TryCatchWeirdTest {

    @Test
    void testMethod() {
        TryCatchWeird main = new TryCatchWeird();
        int result = main.method();
        assertEquals(1, result);
    }
}