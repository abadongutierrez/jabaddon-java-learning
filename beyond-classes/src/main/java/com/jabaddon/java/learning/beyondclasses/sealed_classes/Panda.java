package com.jabaddon.java.learning.beyondclasses.sealed_classes;

// Every class that directly extends a sealed class must specify exactly one of the following three modifiers: final, sealed, or non-sealed.
// non-sealed: Applied to a class or interface that extends a sealed class, indicating that it can be extended by unspecified classes
public non-sealed class Panda extends Bear {
    @Override
    String makeSound() {
        return "panda sound!";
    }
}
