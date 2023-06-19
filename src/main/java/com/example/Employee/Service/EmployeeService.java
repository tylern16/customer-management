package com.example.Employee.Service;

import com.example.Employee.Entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> getAllEmployees();
    Employee getEmployeeByID(int ID);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    String deleteEmployeebyID(int ID);
}
