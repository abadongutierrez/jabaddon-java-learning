package com.jabaddon.practices.pna.polymorhic_solution;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Instant now = Instant.now();
        Plumbing plumbing = new Plumbing();
        plumbing.performService(now);
        plumbing.completeService(now.plus(2, ChronoUnit.HOURS));
        plumbing.confirmService(now.plus(2, ChronoUnit.HOURS).plus(3, ChronoUnit.MINUTES));
        System.out.println("Was service completed? " + plumbing.wasServicePerformed());

        Babysitting babysitting = new Babysitting(3);
        babysitting.performService(now);
        babysitting.endService(now.plus(3, ChronoUnit.HOURS));
        System.out.println("Was service completed? " + babysitting.wasServicePerformed());

        RoomCleaning roomCleaning = new RoomCleaning(Set.of("Kitchet", "Bathroom", "Livingroom"));
        roomCleaning.performService(now);
        roomCleaning.cleaned(now.plus(1, ChronoUnit.HOURS), "Livingroom");
        System.out.println("Was service completed? " + roomCleaning.wasServicePerformed());
    }
}
