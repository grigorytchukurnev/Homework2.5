package com.chukurnev.sprintbootdemon.service;

import com.chukurnev.sprintbootdemon.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee (String firstName, String lastName, int salary, int department);
    Employee removeEmployee (String firstName, String lastName);
    Employee findEmployee (String firstName, String lastName);

    Collection<Employee> getAllEmployees();
}
