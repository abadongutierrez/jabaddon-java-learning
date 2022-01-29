package com.jabaddon.customasserts.model;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    private final String fullName;
    private final int age;
    private final List<String> nicknames;
}
