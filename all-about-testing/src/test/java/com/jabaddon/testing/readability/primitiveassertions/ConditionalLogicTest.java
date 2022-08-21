package com.jabaddon.testing.readability.primitiveassertions;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class ConditionalLogicTest {
    @Test
    void testDictionaryIteratorBad() {
        ErrorDictionary dictionary = new ErrorDictionary();
        dictionary.add("A01", "A01 Description");
        dictionary.add("X02", "X02 Description");
        Iterator<Error> iterator = dictionary.iterator();
        while (iterator.hasNext()) {
            Error currErr = iterator.next();
            if ("A01".equalsIgnoreCase(currErr.getCode())) {
                assertThat(currErr.getDescription(), is("A01 Description"));
            }
            if ("X02".equalsIgnoreCase(currErr.getCode())) {
                assertThat(currErr.getDescription(), is("X02 Description"));
            }
        }
    }

    @Test
    void testDictionaryIterator() {
        ErrorDictionary dictionary = new ErrorDictionary();
        dictionary.add("A01", "A01 Description");
        dictionary.add("X02", "X02 Description");
        assertContainsError(dictionary.iterator(), "A01", "A01 Description");
        assertContainsError(dictionary.iterator(), "X02", "X02 Description");
    }

    private void assertContainsError(Iterator<Error> iterator, String code, String desc) {
        while (iterator.hasNext()) {
            Error currErr = iterator.next();
            if (code.equalsIgnoreCase(currErr.getCode())) {
                assertThat(currErr.getDescription(), is(desc));
                return;
            }
        }
        fail("No Error with Code " + code + " found in iterator");
    }

    private class Error {

        public String getCode() {
            return null;
        }

        public String getDescription() {
            return null;
        }
    }

    private class ErrorDictionary {
        public void add(String str, String desc) {
        }

        public Iterator<Error> iterator() {
            return null;
        }
    }
}
