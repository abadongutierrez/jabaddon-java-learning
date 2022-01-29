package com.jabaddon.javalearning.rxjavacompletablefutures;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

public class SequentialConnector implements Connector {
    @Override
    public List<Hotel> getHotels() {
        List<Hotel> hotels = new ArrayList<>();
        hotels.addAll(new HotelTask().getHotels());
        hotels.addAll(new HotelTask().getHotels());
        hotels.addAll(new HotelTask().getHotels());
        return hotels;
    }
}
