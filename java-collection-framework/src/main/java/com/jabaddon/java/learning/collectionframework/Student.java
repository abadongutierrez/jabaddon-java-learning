package com.jabaddon.java.learning.collectionframework;

public record Student(String name, double grade) implements Comparable<Student> {
    @Override
    public int compareTo(Student o) {
        return Double.compare(grade, o.grade);
    }
}
