package com.jabaddon.practices.pna.polymorhic_solution;

import java.time.Instant;
import java.util.Objects;

public class Plumbing implements Service {
    private Instant startedAt;
    private Instant completedAt;
    private Instant confirmedAt;

    @Override
    public void performService(Instant time) {
        startedAt = time;
    }

    void completeService(Instant time) {
        completedAt = time;
    }

    void confirmService(Instant time) {
        confirmedAt = time;
    }

    @Override
    public boolean wasServicePerformed() {
        return Objects.nonNull(startedAt) && Objects.nonNull(completedAt) && Objects.nonNull(confirmedAt);
    }
}
