package com.jabaddon.testing.readability.primitiveassertions;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SleepingSnailTest {
    @Test
    void testThreadSafeCounterBad() throws InterruptedException {
        ThreadSafeCounter counter = new ThreadSafeCounter(0);
        int callsInThread = 10;
        final Set<Long> values = new HashSet<>();
        int threads = 10;
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                for (int j = 0; j < callsInThread; j++) {
                    values.add(counter.getAndIncrement());
                }
            }).start();
        }
        Thread.sleep(100);
        assertThat(values.size(), is(callsInThread * threads));
    }

    @Test
    void testThreadSafeCounter() throws InterruptedException {
        ThreadSafeCounter counter = new ThreadSafeCounter(0);
        int callsInThread = 10;
        final Set<Long> values = new HashSet<>();
        int threads = 10;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                for (int j = 0; j < callsInThread; j++) {
                    values.add(counter.getAndIncrement());
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await(10, TimeUnit.SECONDS);
        assertThat(values.size(), is(callsInThread * threads));
    }

    private class ThreadSafeCounter {
        private long value;

        public ThreadSafeCounter(long i) {
            value = i;
        }

        public synchronized Long getAndIncrement() {
            return ++value;
        }
    }
}
