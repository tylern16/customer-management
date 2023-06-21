package com.example.Employee.Dao;

import com.example.Employee.Entities.Imagedata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Imagedata,Long> {

    Optional<Imagedata> findByName(String fileName);
}
