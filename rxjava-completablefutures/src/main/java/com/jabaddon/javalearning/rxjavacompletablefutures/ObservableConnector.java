package com.jabaddon.javalearning.rxjavacompletablefutures;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ObservableConnector {
    public Observable<List<Hotel>> getHotels() {
        var futures = new ArrayList<CompletableFuture<List<Hotel>>>();
        futures.add(CompletableFuture.supplyAsync(() -> new HotelTask().getHotels()));
        futures.add(CompletableFuture.supplyAsync(() -> new HotelTask().getHotels()));
        futures.add(CompletableFuture.supplyAsync(() -> new HotelTask().getHotels()));
        return Observable.defer(() -> {
            List<Observable<List<Hotel>>> observables = futures.stream()
                    .map(Observable::fromFuture)
                    .collect(Collectors.toList());
            return Observable.concat(observables);
        });
    }
}
