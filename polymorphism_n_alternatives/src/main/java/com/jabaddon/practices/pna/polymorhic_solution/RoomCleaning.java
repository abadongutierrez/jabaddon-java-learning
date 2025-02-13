package com.jabaddon.practices.pna.polymorhic_solution;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class RoomCleaning implements Service {

    private Instant startedAt;
    private final Set<String> agreedRooms;
    private final Set<String> roomCleaned = new HashSet<>();
    private Instant endedAt;

    public RoomCleaning(Set<String> agreedRooms) {
        this.agreedRooms = agreedRooms;
    }

    @Override
    public void performService(Instant time) {
        startedAt = time;
    }

    void cleaned(Instant time, String roomName) {
        roomCleaned.add(roomName);
        if (isAllAgreedRoomsCleaned()) endedAt = time;
    }

    @Override
    public boolean wasServicePerformed() {
        return Stream.of(startedAt, endedAt).allMatch(Objects::nonNull) && isAllAgreedRoomsCleaned();
    }

    private boolean isAllAgreedRoomsCleaned() {
        return roomCleaned.containsAll(agreedRooms);
    }
}
