package com.example.Employee.Controller;

import com.example.Employee.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {


    @Autowired
    private ImageService imageService;


    @PostMapping("/uploadImage")
    public ResponseEntity<?>  uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        imageService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImage (@PathVariable String fileName){
        byte[] imageData = imageService.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/jpg"))
                .body(imageData);
    }

}
