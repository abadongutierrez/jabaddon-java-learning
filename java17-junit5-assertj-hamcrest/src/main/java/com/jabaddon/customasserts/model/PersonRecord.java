package com.jabaddon.customasserts.model;

import java.util.List;

public record PersonRecord(
        String fullName,
        int age,
        List<String> nickNames) {
}
