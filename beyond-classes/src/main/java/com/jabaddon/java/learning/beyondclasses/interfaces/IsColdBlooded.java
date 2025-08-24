package com.jabaddon.java.learning.beyondclasses.interfaces;

public interface IsColdBlooded {
    default double getTemperature() {
        return 10.0;
    }
}
