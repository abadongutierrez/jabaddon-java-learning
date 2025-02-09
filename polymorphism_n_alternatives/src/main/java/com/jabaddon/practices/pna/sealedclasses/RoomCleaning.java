package com.jabaddon.practices.pna.sealedclasses;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public final class RoomCleaning extends Service {

    private Set<String> roomCleaned = new HashSet<>();
    private final Set<String> agreedRooms;
    private Instant endedAt;

    public RoomCleaning(Set<String> agreedRooms) {
        this.agreedRooms = agreedRooms;
    }

    void cleaned(Instant time, String roomName) {
        roomCleaned.add(roomName);
        if (isAllAgreedRoomsCleaned()) endedAt = time;
    }

    public boolean isAllAgreedRoomsCleaned() {
        return roomCleaned.containsAll(agreedRooms);
    }
}
