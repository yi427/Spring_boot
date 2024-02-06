package org.example.bigevent.controller;

import org.example.bigevent.pojo.Result;
import org.example.bigevent.utlities.AlyUploadFileUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@CrossOrigin
public class UploadFileController {
    @PostMapping("upload")
    public Result<String> upload(MultipartFile file) throws Exception {
        String filename = file.getOriginalFilename();
        filename = UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
        // file.transferTo(new File("D:\\web\\BigEvent\\src\\main\\resources\\Files\\" + filename));
        System.out.println(filename);
        final String url = AlyUploadFileUtil.upload(filename, file.getInputStream());
        return Result.success(url);
    }
}