package com.jabaddon.practices.pna.sealedclasses;

import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

public final class Babysitting extends Service {
    private Instant endedAt;
    private final int agreedHours;

    public Babysitting(int agreedHours) {
        this.agreedHours = agreedHours;
    }

    void endService(Instant time) {
        endedAt = time;
    }

    public boolean isDurationCoversAgreedHours() {
        return Duration.between(startedAt, endedAt).toHours() >= agreedHours;
    }
}
