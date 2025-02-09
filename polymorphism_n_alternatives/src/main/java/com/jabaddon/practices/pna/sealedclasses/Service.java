package com.jabaddon.practices.pna.sealedclasses;

import java.time.Instant;

public abstract sealed class Service permits Babysitting, Plumbing, RoomCleaning/* OtherService*/ {

    protected Instant startedAt;

    public void performService(Instant time) {
        startedAt = time;
    }

    public boolean wasServicePerformed() {
        return switch (this) {
            case Babysitting babysitting -> babysitting.isDurationCoversAgreedHours();
            case Plumbing plumbing -> plumbing.isCompletedAndConfirmed();
            case RoomCleaning roomCleaning -> roomCleaning.isAllAgreedRoomsCleaned();
        };
    }
}
