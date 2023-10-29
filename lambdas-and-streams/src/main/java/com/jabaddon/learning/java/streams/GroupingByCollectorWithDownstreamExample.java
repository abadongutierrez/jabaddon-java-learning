package com.jabaddon.learning.java.streams;

import com.jabaddon.learning.java.utils.Employee;
import com.jabaddon.learning.java.utils.ExperienceLevel;
import com.jabaddon.learning.java.utils.JsonPrinter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByCollectorWithDownstreamExample {
    public static void main(String[] args) throws IOException {
        List<Employee> employeeList = List.of(
                new Employee("Jhon", 4, 4, "DevOps Engineer", ExperienceLevel.MID),
                new Employee("Emma", 2, 2, "Fullstack Engineer", ExperienceLevel.JR),
                new Employee("Lucas", 7, 10, "Frontend Engineer", ExperienceLevel.SR),
                new Employee("Oliver", 17, 20, "Frontend Engineer", ExperienceLevel.STAFF),
                new Employee("Ethan", 5, 7, "Frontend Engineer", ExperienceLevel.MID)
        );

        // group by Experience level and count employees in that experience level
        Map<ExperienceLevel, Long> collect =
                employeeList.stream().collect(Collectors.groupingBy(
                        Employee::experienceLevel, // groups by experience level
                        Collectors.counting())); // downstream collector that counts
        System.out.println("collect = " + collect);
        System.out.println(JsonPrinter.asPrettyJson(collect));

        // group by experience level and get the average of YOE in that level
        Map<ExperienceLevel, Double> collect1 =
                employeeList.stream().collect(Collectors.groupingBy(
                    Employee::experienceLevel,
                    Collectors.averagingInt(Employee::yoe)));
        System.out.println("collect1 = " + collect1);
        System.out.println(JsonPrinter.asPrettyJson(collect1));

        Map<ExperienceLevel, Map<String, List<Employee>>> collect2 =
                employeeList.stream().collect(Collectors.groupingBy(
                    Employee::experienceLevel,
                    Collectors.groupingBy(Employee::role)));
        System.out.println("collect2 = " + collect2);
        System.out.println(JsonPrinter.asPrettyJson(collect2));
    }
}
