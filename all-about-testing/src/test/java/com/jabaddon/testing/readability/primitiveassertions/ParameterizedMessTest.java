package com.jabaddon.testing.readability.primitiveassertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParameterizedMessTest {
    @Test
    void testRomanNumeralOne() {
        assertThat(format(1), is("I"));
    }

    @Test
    void testRomanNumeralTwo() {
        assertThat(format(2), is("II"));
    }

    @ParameterizedTest(name = "{index} Number {0} in Roman Numeral should be {1}")
    @MethodSource("provideRomanNumerals")
    void testRomanNumerals(int number, String expected) {
        assertThat(format(number), is(expected));
    }

    private static Stream<Arguments> provideRomanNumerals() {
        return Stream.of(Arguments.of(1, "I"), Arguments.of(2, "II"));
    }

    private String format(int i) {
        return i == 1 ? "I" : "II";
    }
}
