package com.chukurnev.sprintbootdemon.service.impl;

import com.chukurnev.sprintbootdemon.exception.EmployeeAlreadyAddedException;
import com.chukurnev.sprintbootdemon.exception.EmployeeNotFoundException;
import com.chukurnev.sprintbootdemon.model.Employee;
import com.chukurnev.sprintbootdemon.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String,Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName,int salary, int department) {
        Employee employee = new  Employee(firstName,lastName,salary,department);

         if (employees.containsKey(employee.getFirstName() + employee.getLastName())){
             throw new EmployeeAlreadyAddedException();
         }

         employees.put(employee.getFirstName() + employee.getLastName(),employee);
         return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName,lastName);
        employees.remove(employee.getFirstName() + employee.getLastName());
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String key = firstName + lastName;
        if(employees.containsKey(key)){
            return employees.get(key);
        }else {
            throw new EmployeeNotFoundException();
            }
        }

    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
