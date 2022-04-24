package com.example.softwaredemo.controller;

import com.example.softwaredemo.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@RestController
public class UploadController {

    @RequestMapping("/upload")
    public void uploadTest(MultipartFile[] files) throws IOException {
//        System.out.println(Arrays.toString(file.getBytes()));
//        String path = Constants.UPLOAD_PATH + file.getOriginalFilename();
//        file.transferTo(new File(path));
//        System.out.println(file.getOriginalFilename());
    }
}
