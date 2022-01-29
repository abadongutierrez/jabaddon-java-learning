package com.jabaddon.javalearning.rxjavacompletablefutures;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HotelTask {
    public List<Hotel> getHotels() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ignore) {
        }
        int total = 501;//new Random().nextInt(500);
        return IntStream.range(1, total).mapToObj(this::createHotel).collect(Collectors.toList());
    }

    private Hotel createHotel(int value) {
        UUID uuid = UUID.randomUUID();
        return new Hotel(uuid.toString(), "Hotel " + uuid);
    }
}
