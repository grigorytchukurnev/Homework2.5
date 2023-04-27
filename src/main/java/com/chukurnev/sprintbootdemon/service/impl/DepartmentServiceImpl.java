package com.chukurnev.sprintbootdemon.service.impl;

import com.chukurnev.sprintbootdemon.model.Employee;
import com.chukurnev.sprintbootdemon.service.DepartmentService;
import com.chukurnev.sprintbootdemon.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        Collection<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(it -> it.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .get();
    }

    @Override
    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        Collection<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(it -> it.getDepartment() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .get();
    }

    @Override
    public List<Employee> getEmployeesByDepartment(Integer departmentId) {
        Collection<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .filter(it -> it.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesCollectedByDepartment() {
        Collection<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
