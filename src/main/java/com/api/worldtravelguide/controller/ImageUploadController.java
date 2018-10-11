package com.api.worldtravelguide.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/upload")
public class ImageUploadController {
    private final String ACCESS_TOKEN = "";

    @PostMapping("/image")
    public String uploadImage(@RequestParam("files") MultipartFile uploadfiles) {
        //GoogleCredential credential=new GoogleCredential().setAccessToken(ACCESS_TOKEN);
        return "OK";
    }
}
