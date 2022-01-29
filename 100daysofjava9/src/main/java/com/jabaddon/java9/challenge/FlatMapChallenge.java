package com.jabaddon.java9.challenge;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapChallenge {

    public static void main(String... args) {
        Animal a1 = new Animal("Dinosaur", Set.of("Chicken", "Ice Cream"));
        Animal a2 = new Animal("Dog", Set.of("Bones", "Cheese Burger", "Soda"));

        List<String> collect =
                List.of(a1, a2).stream()
                        .map(Animal::getFoods)
                        .flatMap(Collection::stream)
                        .limit(4).filter(x -> x.matches(".*"))
                        .distinct()
                        .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }

    static class Animal {
        private String name;
        private Set<String> foods;

        public Animal(String name, Set<String> foods) {
            this.name = name;
            this.foods= foods;
        }

        public String getName() {
            return name;
        }

        public Set<String> getFoods() {
            return foods;
        }
    }
}
