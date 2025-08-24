package com.jabaddon.java.learning.beyondclasses.sealed_classes;

// Every class that directly extends a sealed class must specify exactly one of the following three modifiers: final, sealed, or non-sealed.
public final class Kodiak extends Bear {
    @Override
    String makeSound() {
        return "kodiak sound!";
    }
}
