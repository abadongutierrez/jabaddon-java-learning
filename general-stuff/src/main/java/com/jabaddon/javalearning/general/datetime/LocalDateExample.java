package com.jabaddon.javalearning.general.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.firstDayOfNextMonth;

public class LocalDateExample {

    public static void main(String[] args) {
        System.out.println("Hello World");

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDate d2 = localDate.with(firstDayOfMonth());
        System.out.println(d2);

        LocalDate d3 = localDate.with(firstDayOfNextMonth());
        System.out.println(d3);

        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now().atOffset(ZoneOffset.ofHours(-5)).toZonedDateTime());
        System.out.println(LocalDateTime.now(ZoneId.of("America/Chicago")));
        System.out.println(LocalDateTime.now().atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("America/Chicago")));
    }
}
