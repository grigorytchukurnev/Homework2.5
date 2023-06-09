package com.chukurnev.sprintbootdemon.controller;

import com.chukurnev.sprintbootdemon.model.Employee;
import com.chukurnev.sprintbootdemon.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam Integer salary,
            @RequestParam Integer department){
        return employeeService.addEmployee(firstName, lastName, salary, department );
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName){
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName){
         return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> grtAllEmployees(){
        return employeeService.getAllEmployees();
    }
}
