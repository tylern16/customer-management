package com.example.Employee.Dao;

import com.example.Employee.Entities.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependentDao extends JpaRepository<Dependent, Integer> {
}
