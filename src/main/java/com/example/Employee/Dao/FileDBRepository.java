package com.example.Employee.Dao;

import com.example.Employee.Entities.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDBRepository extends JpaRepository<FileDB, String> {
}
