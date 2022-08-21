package com.jabaddon.testing.readability.primitiveassertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CohesionTest {
    private TextFixture tf1, tf2, tf3, tf4;

    @BeforeEach
    void setup() {
        // ...
    }

    @Test
    void test1() {
        // uses tf1 adn tf2
    }

    @Test
    void test2() {
        // uses tf3 and tf4
    }
}
