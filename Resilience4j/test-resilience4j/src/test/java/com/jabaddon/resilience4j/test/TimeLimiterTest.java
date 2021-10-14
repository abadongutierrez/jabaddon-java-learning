package com.jabaddon.resilience4j.test;

import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeLimiterTest {

    @Test()
    void blockingExecutionWithTimeout() {
        // Given I have a helloWorldService.sayHelloWorld() method which takes too long
        HelloWorldService service = new HelloWorldSlowService();

        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .cancelRunningFuture(true)
                .timeoutDuration(Duration.ofMillis(500))
                .build();

        // Create a TimeLimiter
        TimeLimiter timeLimiter = TimeLimiter.of("HelloWorldService", config);

        // The blocking variant which is basically future.get(timeoutDuration, MILLISECONDS)
        String message = null;
        try {
            message = timeLimiter.executeFutureSupplier(
                    () -> CompletableFuture.supplyAsync(service::sayHelloWorld));
            assertThat(message).isEqualTo("Hello World"); // never happens
        } catch (Exception e) {
            assertThat(e).isInstanceOf(TimeoutException.class);
            assertThat(e.getMessage()).isEqualTo("TimeLimiter 'HelloWorldService' recorded a timeout exception.");
        }
    }

    @Test
    void blockingExecutionWithTimeoutLimiterRegistry() {
        // Given I have a helloWorldService.sayHelloWorld() method which takes too long
        HelloWorldService service = new HelloWorldSlowService();

        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .cancelRunningFuture(true)
                .timeoutDuration(Duration.ofMillis(500))
                .build();

        // Create a TimeLimiterRegistry with a custom global configuration
        TimeLimiterRegistry timeLimiterRegistry = TimeLimiterRegistry.of(config);

        // Get or create a TimeLimiter from the registry -
        // TimeLimiter will be backed by the default config
        TimeLimiter timeLimiter = timeLimiterRegistry.timeLimiter("HelloWorldService");

        // The blocking variant which is basically future.get(timeoutDuration, MILLISECONDS)
        String message = null;
        try {
            message = timeLimiter.executeFutureSupplier(
                    () -> CompletableFuture.supplyAsync(service::sayHelloWorld));
            assertThat(message).isEqualTo("Hello World"); // never happens
        } catch (Exception e) {
            assertThat(e).isInstanceOf(TimeoutException.class);
            assertThat(e.getMessage()).isEqualTo("TimeLimiter 'HelloWorldService' recorded a timeout exception.");
        }
    }
}
