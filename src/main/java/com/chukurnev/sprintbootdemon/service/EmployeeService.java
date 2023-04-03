package com.chukurnev.sprintbootdemon.service;

import com.chukurnev.sprintbootdemon.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee (String firstName, String lastName);
    Employee removeEmployee (String firstName, String lastName);
    Employee findEmployee (String firstName, String lastName);

    List<Employee> getAllEmployees();
}
