package com.jabaddon.practices.pna.polymorhic_solution;

import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

public class Babysitting implements Service {
    private Instant startedAt;
    private Instant endedAt;
    private final int agreedHours;

    public Babysitting(int agreedHours) {
        this.agreedHours = agreedHours;
    }

    @Override
    public void performService(Instant time) {
        startedAt = time;
    }

    void endService(Instant time) {
        endedAt = time;
    }

    @Override
    public boolean wasServicePerformed() {
        if (Objects.isNull(startedAt) || Objects.isNull(endedAt)) return false;
        return Duration.between(startedAt, endedAt).toHours() >= agreedHours;
    }
}
