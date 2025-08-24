package com.jabaddon.javalearning.generics.covariant_in_genercis;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Employee()); // valid, since Employee is a Person

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee());

//        List<Person> try1 = employeeList; // DOES NOT COMPILE!
        List<? extends Person> personList2 = employeeList; // DOES COMPILE!
    }
}

class Person {

}

class Employee extends Person {

}

