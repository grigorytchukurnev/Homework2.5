package com.chukurnev.sprintbootdemon.controller;

import com.chukurnev.sprintbootdemon.model.Employee;
import com.chukurnev.sprintbootdemon.service.EmployeeService;
import com.chukurnev.sprintbootdemon.validaton.EmployeeValidator;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Employee> addEmployee(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam Integer salary,
            @RequestParam Integer department
    ) {
        if (EmployeeValidator.validate(firstName, lastName)){
            return ResponseEntity.ok(employeeService.addEmployee(firstName, lastName, salary, department));
        }
        return ResponseEntity.badRequest().build();
    }


    @GetMapping("/remove")
    public ResponseEntity<Employee> removeEmployee(@RequestParam String firstName, @RequestParam String lastName){
        if (EmployeeValidator.validate(firstName, lastName)){
            employeeService.removeEmployee(firstName, lastName);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/find")
    public ResponseEntity<Employee> findEmployee(@RequestParam String firstName, @RequestParam String lastName
    ){
        if (EmployeeValidator.validate(firstName, lastName)){
            return ResponseEntity.ok(employeeService.findEmployee(firstName, lastName));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public Collection<Employee> grtAllEmployees(){
        return employeeService.getAllEmployees();
    }
}
