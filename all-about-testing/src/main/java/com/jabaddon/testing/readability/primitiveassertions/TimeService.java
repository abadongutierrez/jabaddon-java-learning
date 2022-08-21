package com.jabaddon.testing.readability.primitiveassertions;

import java.util.concurrent.TimeUnit;

public interface TimeService {
    Object fromNow(int i, TimeUnit days);

    void moveForward(int i, TimeUnit days);
}
