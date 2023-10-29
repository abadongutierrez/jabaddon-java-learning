package com.jabaddon.learning.java.streams;

import com.jabaddon.learning.java.utils.Employee;
import com.jabaddon.learning.java.utils.ExperienceLevel;
import com.jabaddon.learning.java.utils.JsonPrinter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionByCollectorExample {
    public static void main(String[] args) throws IOException {
        List<Employee> employeeList = List.of(
                new Employee("Jhon", 4, 4, "DevOps Engineer", ExperienceLevel.MID),
                new Employee("Emma", 2, 2, "Fullstack Engineer", ExperienceLevel.JR),
                new Employee("Lucas", 7, 10, "Frontend Engineer", ExperienceLevel.SR),
                new Employee("Oliver", 17, 20, "Frontend Engineer", ExperienceLevel.STAFF),
                new Employee("Ethan", 5, 7, "Frontend Engineer", ExperienceLevel.MID)
        );

        Map<Boolean, List<Employee>> collect =
                employeeList.stream().collect(Collectors.partitioningBy(e -> e.tenure() > 2));
        System.out.println(JsonPrinter.asPrettyJson(collect));

        Map<Boolean, Map<ExperienceLevel, List<Employee>>> collect1 =
                employeeList.stream().collect(Collectors.partitioningBy(
                    e -> e.tenure() > 2,
                    Collectors.groupingBy(Employee::experienceLevel)));
        System.out.println(JsonPrinter.asPrettyJson(collect1));
    }
}
