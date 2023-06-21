package com.example.Employee.Controller;

import com.example.Employee.Dao.OrderRepository;
import com.example.Employee.Entities.Dependent;
import com.example.Employee.Entities.Employee;
import com.example.Employee.Entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders")
    public List<Order> showAll() {
        return this.orderRepository.findAll();
    }

    @GetMapping("/order/{id}")
    public Optional<Order> getOrderByID(@PathVariable int id) {
        return this.orderRepository.findById(id);
    }

    @PostMapping("/add/order")
    public Order addOrder(@RequestBody Order order) {
        return this.orderRepository.save(order);
    }

    @PutMapping("/update/order")
    public Order updateOrder(@RequestBody Order order) {
        return this.orderRepository.save(order);
    }

    @DeleteMapping("/delete/order/{id}")
    public void deleteOrderByID(@PathVariable int id) {
        this.orderRepository.deleteById(id);
    }
}
