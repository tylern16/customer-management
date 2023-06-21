package com.example.Employee.Service;

import java.io.IOException;
import java.util.stream.Stream;

import com.example.Employee.Dao.FileDBRepository;
import com.example.Employee.Entities.FileDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileStorageService {

    @Autowired
    private FileDBRepository fileDBRepository;

    public FileDB store(MultipartFile file ) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //String description = "File Storage Service Descriotion";
        FileDB FileDB = new FileDB( fileName, file.getContentType(), file.getBytes());

        return fileDBRepository.save(FileDB);
    }

    public FileDB getFile(String id) {
        return fileDBRepository.findById(id).get();
    }

    public Stream<FileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }
}
