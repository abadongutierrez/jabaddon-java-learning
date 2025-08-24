package com.jabaddon.java.learning.collectionframework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentListSortingExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
                new Student("Student1", 9.5),
                new Student("Student2", 7.3),
                new Student("Student3", 10.0)
        ));
        students.sort((o1, o2) -> Double.compare(o1.grade(), o2.grade()));

        students.sort(Comparator.comparing(Student::grade).
                thenComparing(Student::name).reversed());
    }
}
