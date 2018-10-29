package ru.techport.projectmanager.task.file.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {
    @PostMapping("/file")
    public void upload(MultipartFile file) throws IOException {
        File path = new File("C:\\data\\" + file.getOriginalFilename());
        file.transferTo(path);
        System.out.println(file);
    }
}
