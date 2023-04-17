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
    public Employee addEmployee(String firstName, String lastName) {


         Employee employee = new  Employee(firstName,lastName);
         if (employees.containsKey(employee.getFullName())){
             throw new EmployeeAlreadyAddedException();
         }

         employees.put(employee.getFullName(),employee);
         return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName,lastName);
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

            if(employees.containsKey(employee.getFullName())){
                return employees.get(employee.getFullName());
            }else {
                throw new EmployeeNotFoundException();
            }
        }

    @Override
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
