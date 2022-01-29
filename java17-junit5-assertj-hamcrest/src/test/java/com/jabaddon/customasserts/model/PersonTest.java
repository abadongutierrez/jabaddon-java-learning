package com.jabaddon.customasserts.model;

import org.assertj.core.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

class PersonTest {

    @Test
    void testHamcrestAssert() {
        var p = new Person("Rafael Gutierrez", 42, List.of("abaddon"));
        MatcherAssert.assertThat(p.getAge(), CoreMatchers.is(42));
    }

    @Test
    void testAssertJAssert() {
        var p = new Person("Rafael Gutierrez", 42, List.of("abaddon"));
        Assertions.assertThat(p.getAge()).isEqualTo(42);
    }

    @Test
    void testCustomPersonMatcher() {
        var p = new Person("Rafael Gutierrez", 42, List.of("abaddon"));
        // Expecting to fail and to show every failure, not just the first error
        MatcherAssert.assertThat(p, Matchers.allOf(
                PersonHamcrestMatchers.hasNickName("abaddo"),
                PersonHamcrestMatchers.isAge(21)));
    }

    @Test
    void testRecord() {
        var p = new PersonRecord("Rafael Gutierrez", 42, List.of("abaddon"));
        MatcherAssert.assertThat(p.age(), CoreMatchers.is(42));
    }
}