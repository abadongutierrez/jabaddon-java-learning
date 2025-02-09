package com.jabaddon.practices.pna.polymorhic_solution;

import java.time.Instant;

public interface Service {
    void performService(Instant time);
    boolean wasServicePerformed();
}
