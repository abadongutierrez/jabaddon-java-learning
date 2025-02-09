package com.jabaddon.practices.pna.sealedclasses;

import java.time.Instant;
import java.util.Objects;

public final class Plumbing extends Service {
    private Instant completedAt;
    private Instant confirmedAt;

    void completeService(Instant time) {
        completedAt = time;
    }

    void confirmService(Instant time) {
        confirmedAt = time;
    }

    public boolean isCompletedAndConfirmed() {
        return Objects.nonNull(startedAt) && Objects.nonNull(completedAt) && Objects.nonNull(confirmedAt);
    }
}
