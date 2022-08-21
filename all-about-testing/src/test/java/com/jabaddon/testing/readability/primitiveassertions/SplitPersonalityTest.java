package com.jabaddon.testing.readability.primitiveassertions;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class SplitPersonalityTest {
    @Test
    void testParsingCommandLineArguments() {
        String[] args = { "-f", "hello.txt", "-v", "--version" };
        Configuration c = new Configuration();
        c.processArguments(args);
        assertEquals("hello.txt", c.getFileName());
        assertFalse(c.isDebuggingEnabled());
        assertFalse(c.isWarningsEnabled());
        assertTrue(c.isVerbose());
        assertTrue(c.shouldShowVersion());

        c = new Configuration();
        try {
            c.processArguments(new String[] {"-f"});
            fail("Should've failed");
        } catch (InvalidArgumentException expected) {
            // this is okay and expected
        }
    }

    @Test
    void testParsingValidCommandLineArguments() {
        String[] args = { "-f", "hello.txt", "-v", "--version" };
        Configuration c = new Configuration();
        c.processArguments(args);
        assertThat(c.getFileName(), is("hello.txt"));
        assertThat(c.isDebuggingEnabled(), is(true));
        assertThat(c.isWarningsEnabled(), is(false));
        assertThat(c.isVerbose(), is(true));
        assertThat(c.shouldShowVersion(), is(true));
    }

    @Test
    void testParsingInvalidCommandLineArguments() {
        String[] args = { "-f" };
        Configuration c = new Configuration();
        assertThrows(InvalidArgumentException.class, () -> c.processArguments(args));
    }

    private class Configuration {
        public void processArguments(String[] args) {
        }

        public String getFileName() {
            return null;
        }

        public boolean isDebuggingEnabled() {
            return false;
        }

        public boolean isWarningsEnabled() {
            return false;
        }

        public boolean isVerbose() {
            return false;
        }

        public boolean shouldShowVersion() {
            return false;
        }
    }

    private class InvalidArgumentException extends RuntimeException {
    }
}
