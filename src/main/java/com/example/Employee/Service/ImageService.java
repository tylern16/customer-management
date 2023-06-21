package com.example.Employee.Service;

import com.example.Employee.Dao.ImageRepository;
import com.example.Employee.Entities.Imagedata;
import com.example.Employee.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public void uploadImage(MultipartFile file) throws IOException {
        Imagedata imageData = imageRepository.save(Imagedata.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null ){
            System.out.println("Image uploaded Successfully");
        }

    }

    public byte[] downloadImage( String fileName){
        Optional<Imagedata> dbImageData = imageRepository.findByName(fileName);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;

    }
}
