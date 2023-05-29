package service;

import com.chukurnev.sprintbootdemon.exception.EmployeeAlreadyAddedException;
import com.chukurnev.sprintbootdemon.model.Employee;
import com.chukurnev.sprintbootdemon.service.EmployeeService;
import com.chukurnev.sprintbootdemon.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeServiceImplTest {

    private final EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    public void shouldThrowExceptionWhenEmployeeAlreadyPresentedInRepository(){
        // given
        Employee employee = new Employee("Ivan", "Petrov", 100_000, 1);
        employeeService.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(),employee.getDepartment());
        // when
        // then
        Assertions.assertThrows(
                EmployeeAlreadyAddedException.class,
                () -> employeeService.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getSalary(),employee.getDepartment())
                );
    }
    @Test
    public void shouldReturnCorrectEmployee(){
        // given
        Employee employee = new Employee("Ivan", "Petrov", 100_000, 1);
        // when
        Employee addedEmployee = employeeService.addEmployee (employee.getFirstName(), employee.getLastName(), employee.getSalary(),employee.getDepartment());
        // then
        Assertions.assertEquals(employee, addedEmployee);

    }

}
