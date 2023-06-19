package com.example.Employee.Controller;

import com.example.Employee.Dao.DependentDao;
import com.example.Employee.Dao.EmployeeDao;
import com.example.Employee.Entities.Dependent;
import com.example.Employee.Entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DependentController {

    @Autowired
    EmployeeDao customerRepository;

    @Autowired
    DependentDao dependentRepository;

    //get a customer's dependents BY ID
    @GetMapping("/customer/{customerId}/dependents")
    public ResponseEntity<List<Dependent>> getAllCommentsByDependentId(@PathVariable(value = "customerId") int customerId) throws Exception {
        Employee employee = customerRepository.findById(customerId)
                .orElseThrow(() -> new Exception("Not found Tutorial with id = " + customerId));

        List<Dependent> dependents = new ArrayList<Dependent>();
        dependents.addAll(employee.getDependents());

        return new ResponseEntity<>(dependents, HttpStatus.OK);
    }

    //get a dependent by id
    @GetMapping("/dependents/{id}")
    public ResponseEntity<Dependent> getCommentsByTutorialId(@PathVariable(value = "id") int id) throws Exception {
        Dependent dependent = dependentRepository.findById(id)
                .orElseThrow(() -> new Exception("Not found Comment with id = " + id));

        return new ResponseEntity<>(dependent, HttpStatus.OK);
    }

    //add a dependent by customerid and dependent
    @PostMapping("/customer/{customerId}/dependents")
    public ResponseEntity<Dependent> createComment(@PathVariable(value = "customerId") int customerId,
                                                 @RequestBody Dependent newDependent) throws Exception {
        Dependent dependent = customerRepository.findById(customerId).map(customer -> {
            customer.getDependents().add(newDependent);
            return dependentRepository.save(newDependent);
        }).orElseThrow(() -> new Exception("Not found Tutorial with id = " + customerId));

        return new ResponseEntity<>(dependent, HttpStatus.CREATED);
    }

    //update dependent by id
    @PutMapping("/dependents/{id}")
    public ResponseEntity<Dependent> updateComment(@PathVariable("id") int id, @RequestBody Dependent updatedDependent) throws Exception {
        Dependent dependent = dependentRepository.findById(id)
                .orElseThrow(() -> new Exception("CommentId " + id + "not found"));

        dependent.setName(updatedDependent.getName());
        dependent.setEmail(updatedDependent.getName());

        return new ResponseEntity<>(dependentRepository.save(dependent), HttpStatus.OK);
    }

    //delete dependent by id
    @DeleteMapping("/dependents/{id}")
    public ResponseEntity<HttpStatus> deleteDependent(@PathVariable("id") int id) {
        dependentRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
