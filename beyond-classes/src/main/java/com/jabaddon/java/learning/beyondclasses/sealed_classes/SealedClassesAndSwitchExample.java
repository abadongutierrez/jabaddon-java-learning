package com.jabaddon.java.learning.beyondclasses.sealed_classes;

public class SealedClassesAndSwitchExample {
    public static void main(String[] args) {
        Bear bear = new Kodiak();
        var sound = switch (bear) {
            case Kodiak k -> k.makeSound();
            case Panda p -> p.makeSound();
        };
        System.out.println(sound);
    }
}
