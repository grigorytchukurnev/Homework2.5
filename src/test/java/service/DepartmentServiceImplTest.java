package service;

import com.chukurnev.sprintbootdemon.model.Employee;
import com.chukurnev.sprintbootdemon.service.DepartmentService;
import com.chukurnev.sprintbootdemon.service.EmployeeService;
import com.chukurnev.sprintbootdemon.service.impl.DepartmentServiceImpl;
import com.chukurnev.sprintbootdemon.service.impl.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    @Test
    public void shouldReturnWithMaxSalary() {
        // given
        final int departmentId = 1;

        Employee employeeY = new Employee("IvanY", "PetrovY", 100_000, departmentId);
        Employee employeeR = new Employee("IvanR", "PetrovR", 300_000, departmentId);
        Employee employeeT = new Employee("IvanT", "PetrovT", 200_000, departmentId);
        Map<String, Employee> employees = new HashMap<>();
        employees.put(employeeY.getFirstName() + employeeY.getLastName(), employeeY);
        employees.put(employeeR.getFirstName() + employeeR.getLastName(), employeeR);
        employees.put(employeeT.getFirstName() + employeeT.getLastName(), employeeT);

        when(employeeService.getAllEmployees()).thenReturn(employees.values());
        // when
        Employee employeeWithMaxSalary = departmentService.getEmployeeWithMaxSalary(departmentId);
        // then
        Assertions.assertEquals(employeeR, employeeWithMaxSalary);
    }

    @Test
    public void shouldReturnNollWhenDepartmentIsEmpty() {
        // given
        when(employeeService.getAllEmployees()).thenReturn(Collections.emptyList());
        // when
        Employee employeeWithMaxSalary = departmentService.getEmployeeWithMaxSalary(1);
        // then
        Assertions.assertNull(employeeWithMaxSalary);

    }


}
