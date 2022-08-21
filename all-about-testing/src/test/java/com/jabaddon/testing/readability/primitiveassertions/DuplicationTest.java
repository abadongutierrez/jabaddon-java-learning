package com.jabaddon.testing.readability.primitiveassertions;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DuplicationTest {
    @Test
    void testEmptyTemplate() {
        assertThat(getTemplateEvaluation(""), is(""));
    }

    @Test
    void testBasicTemplate() {
        assertThat(getTemplateEvaluation("some text"), is("some text"));
    }

    private String getTemplateEvaluation(String text) {
        return new Template(text).evaluate();
    }

    private record Template(String text) {
        public String evaluate() {
            return text();
        }
    }
}
