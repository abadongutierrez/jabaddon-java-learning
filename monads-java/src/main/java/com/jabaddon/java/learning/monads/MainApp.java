package com.jabaddon.java.learning.monads;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        EmployeeController controller = new EmployeeController(service);

//        Repository repository = new Repository();

        List<Employee> employees = controller.method();
    }
}
