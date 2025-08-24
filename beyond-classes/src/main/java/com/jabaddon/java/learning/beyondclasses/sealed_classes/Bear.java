package com.jabaddon.java.learning.beyondclasses.sealed_classes;

public sealed abstract class Bear permits Kodiak, Panda {
    abstract String makeSound();
}
