package com.chukurnev.sprintbootdemon.service;

import com.chukurnev.sprintbootdemon.model.Employee;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

     Employee getEmployeeWithMaxSalary(Integer departmentId);
     Employee getEmployeeWithMinSalary(Integer departmentId);
     List<Employee> getEmployeesByDepartment(Integer departmentId);
     Map<Integer,List<Employee>> getEmployeesCollectedByDepartment();
}
