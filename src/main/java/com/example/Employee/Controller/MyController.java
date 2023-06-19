package com.example.Employee.Controller;

import com.example.Employee.Dao.EmployeeDao;
import com.example.Employee.Entities.Employee;
import com.example.Employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    EmployeeDao employeeRepository;

    @GetMapping("/")
    public String home() {
        return "<HTML><H1>Welcome to Customer App</H1></HTML>";
    }

    @GetMapping("/customers")
    public List<Employee> showAll() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/customer/{id}")
    public Employee getEmployeeByID(@PathVariable int id) {
        return this.employeeService.getEmployeeByID(id);
    }

    @PostMapping("/addcustomer")
    public Employee addEmployee(@RequestBody Employee employee) {
        return this.employeeService.addEmployee(employee);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return this.employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployeeByID(@PathVariable int id) {
        this.employeeService.deleteEmployeebyID(id);
    }
}
