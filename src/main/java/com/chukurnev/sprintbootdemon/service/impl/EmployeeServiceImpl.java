package com.chukurnev.sprintbootdemon.service.impl;

import com.chukurnev.sprintbootdemon.exception.EmployeeAlreadyAddedException;
import com.chukurnev.sprintbootdemon.exception.EmployeeNotFoundException;
import com.chukurnev.sprintbootdemon.exception.EmployeeStorageIsFullException;
import com.chukurnev.sprintbootdemon.model.Employee;
import com.chukurnev.sprintbootdemon.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {


         Employee employee = new  Employee(firstName,lastName);
         if (employees.contains(employee)){
             throw new EmployeeAlreadyAddedException();
         }

         employees.add(employee);
         return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new  Employee(firstName,lastName);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee findeEmployee = new Employee(firstName, lastName);

        for (Employee employee : employees){
            if(employee.equals(findeEmployee)){
                return employee;
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }
}
