package com.jabaddon.java.learning;

import java.util.List;
import java.util.stream.Gatherer;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        firstExample();
        secondExampleStopPushingElementsToDownstream();
        thirdExampleMapOnlyTheOnesYouCanMap();
    }

    private static void thirdExampleMapOnlyTheOnesYouCanMap() {
        Gatherer.Integrator<Void, String, Integer> integrator =
                (_, element, downstream) -> {
                    try {
                        Integer element1 = mapStringToInteger(element);
                        downstream.push(element1);
                    } catch (IllegalArgumentException ex) {
                        // Do nothing
                    }
                    return true;
                };
        Gatherer<String, ?, Integer> identityGatherer = Gatherer.of(integrator);
        List<Integer> list = Stream.of("one", "two", "three", "seven", "cuatro", "six", "seven")
                .gather(identityGatherer).toList();
        System.out.println(list);

        List<Integer> list2 = Stream.of("one", "two", "three", "seven", "cuatro", "six", "seven")
                .map(element -> {
                    try {
                        return mapStringToInteger(element);
                    } catch (IllegalArgumentException ex) {
                        return null;
                    }
                })
                .filter(element -> element != null)
                .toList();
        System.out.println(list2);
    }

    private static void secondExampleStopPushingElementsToDownstream() {
        Gatherer.Integrator<Void, String, Integer> integrator =
                (_, element, downstream) -> {
                    try {
                        Integer element1 = mapStringToInteger(element);
                        downstream.push(element1);
                        return true;
                    } catch (IllegalArgumentException ex) {
                        return false;
                    }
                };
        Gatherer<String, ?, Integer> identityGatherer = Gatherer.of(integrator);
        List<Integer> list = Stream.of("one", "two", "three", "seven", "cuatro", "six", "seven")
                .gather(identityGatherer).toList();
        System.out.println(list);
    }

    private static void firstExample() {
        Gatherer.Integrator<Void, String, Integer> integrator =
                (_, element, downstream) -> downstream.push(mapStringToInteger(element));

        Gatherer<String, ?, Integer> identityGatherer = Gatherer.of(integrator);

        List<Integer> list = Stream.of("one", "two", "three").gather(identityGatherer).toList();

        System.out.println(list);
    }

    private static Integer mapStringToInteger(String element) {
        return switch (element) {
            case "one" -> 1;
            case "two" -> 2;
            case "three" -> 3;
            case "seven" -> 7;
            default -> throw new IllegalArgumentException("Unknown element: " + element);
        };
    }
}
