package com.jabaddon.testing.readability.primitiveassertions;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class OverprotectiveTestsTest {
    @Test
    void countObjectData() {
        MyObject object = new MyObject();
        Data data = object.getData();
        assertThat(data.count(), is(4));
    }

    private class Data {
        public int count() {
            return 0;
        }
    }

    private class MyObject {
        public Data getData() {
            return null;
        }
    }
}
