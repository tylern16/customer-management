package com.example.Employee.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name= "ImageData")
@Data
@AllArgsConstructor
@Builder
public class Imagedata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;

    @Lob
    @Column(name = "imagedata",length = 1000)
    private byte[] imageData;

    public Imagedata() {
    }
}
