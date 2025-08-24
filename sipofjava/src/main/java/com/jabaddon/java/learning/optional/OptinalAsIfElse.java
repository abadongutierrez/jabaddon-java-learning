package com.jabaddon.java.learning.optional;

import java.util.Objects;
import java.util.Optional;

public class OptinalAsIfElse {
    private static class Person {
        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    public static void main(String[] args) {
        Person from = new Person("John", "Newman");
        Person to = new Person(null, "Lara");

        if (!Objects.isNull(from.getFirstName())) {
            to.setFirstName(from.getFirstName());
        }

        Optional.ofNullable(from.getFirstName()).ifPresent(to::setFirstName);
        Optional.ofNullable(from.getLastName()).ifPresent(to::setLastName);
    }
}
