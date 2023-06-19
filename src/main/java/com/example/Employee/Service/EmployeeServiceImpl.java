package com.example.Employee.Service;

import com.example.Employee.Dao.EmployeeDao;
import com.example.Employee.Entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeDao.findAll();
    }

    @Override
    public Employee getEmployeeByID(int ID) {
        Optional<Employee> e = this.employeeDao.findById(ID);
        Employee emp = null;
        if (e.isPresent()){
            emp = e.get();
        } else {
            throw new RuntimeException("ID not found");
        }
        return emp;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return this.employeeDao.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return this.employeeDao.save(employee);
    }

    @Override
    public String deleteEmployeebyID(int ID) {
        this.employeeDao.deleteById(ID);
        return "Successfully Deleted";
    }
}
