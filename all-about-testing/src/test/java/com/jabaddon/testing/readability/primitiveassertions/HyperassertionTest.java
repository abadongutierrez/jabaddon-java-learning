package com.jabaddon.testing.readability.primitiveassertions;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HyperassertionTest {

    @Test
    void emailTemplateWithPrimitiveAssertion() {
        String templateOutput = "my template output";
        String expectedOutput = "my real template output";
        assertEquals(templateOutput, expectedOutput);
    }

    @Test
    void emailTemplate() {
        String templateOutput = "my template output";
        String expectedOutput = "my real template output";
        assertThat(templateOutput, is(equalToIgnoringCase(expectedOutput)));
    }
}
