package com.jabaddon.java.learning.monads;

import java.util.List;

public class EmployeeController {
    private EmployeeService service;

    public EmployeeController(EmployeeService _employeeService) {
        service = _employeeService;
    }

    public List<Employee> method() {
        // logica
        return service.method();
    }
}
