package com.chukurnev.sprintbootdemon.controller;

import com.chukurnev.sprintbootdemon.model.Employee;
import com.chukurnev.sprintbootdemon.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")

    public Employee getEmployeeWithMaxSalary(@RequestParam Integer departmentId){
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam Integer departmentId){
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }
    @GetMapping("/all")
    public List<Employee> getEmployeesByDepartment(@RequestParam Integer departmentId){
        return departmentService.getEmployeesByDepartment(departmentId);
    }
    @GetMapping("/all/collected-by-department")
    public Map<Integer,List<Employee>> getEmployeesCollectedByDepartment(){
        return departmentService.getEmployeesCollectedByDepartment();
    }
}


