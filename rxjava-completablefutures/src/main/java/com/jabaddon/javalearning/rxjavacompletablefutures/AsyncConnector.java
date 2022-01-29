package com.jabaddon.javalearning.rxjavacompletablefutures;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

public class AsyncConnector implements Connector {
    @Override
    public List<Hotel> getHotels() {
        List<Hotel> returnValues = new CopyOnWriteArrayList<>();
        CompletableFuture<Void> listCompletableFuture1 = CompletableFuture.supplyAsync(() -> new HotelTask().getHotels()).
                thenAccept(returnValues::addAll);
        CompletableFuture<Void> listCompletableFuture2 = CompletableFuture.supplyAsync(() -> new HotelTask().getHotels()).
                thenAccept(returnValues::addAll);
        CompletableFuture<Void> listCompletableFuture3 = CompletableFuture.supplyAsync(() -> new HotelTask().getHotels()).
                thenAccept(returnValues::addAll);
        CompletableFuture.allOf(listCompletableFuture1, listCompletableFuture2, listCompletableFuture3).join();
        return returnValues;
    }
}
