
package com.jabaddon.javalearning.rxjavacompletablefutures;

import io.reactivex.rxjava3.core.Observable;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        method(new SequentialConnector());
        method(new AsyncConnector());
        executeWithObservable();
    }

    private static void executeWithObservable() {
        Instant start = Instant.now();
        ObservableConnector observableConnector = new ObservableConnector();
        Observable<List<Hotel>> hotels = observableConnector.getHotels();
        hotels.subscribe(v -> {
                    System.out.println("Got size " + v.size());
                    System.out.println("Got " + v);
                },
                e -> System.err.println("Exception " + e),
                () -> {
                    System.out.println("All done");
                    Instant end = Instant.now();
                    System.out.println("duration:" + Duration.between(start, end));
                });
    }

    private static void method(Connector connector) {
        Instant start = Instant.now();
        List<Hotel> hotels = connector.getHotels();
        System.out.println(hotels.size());
        System.out.println(hotels);
        Instant end = Instant.now();
        System.out.println("duration:" + Duration.between(start, end)); // prints PT1M3.553S
    }
}
