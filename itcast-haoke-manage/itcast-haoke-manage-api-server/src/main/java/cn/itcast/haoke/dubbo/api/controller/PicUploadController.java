package cn.itcast.haoke.dubbo.api.controller;

import cn.itcast.haoke.dubbo.api.service.PicUploadFileSystemService;
import cn.itcast.haoke.houseResources.response.PicUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/pic/upload")
public class PicUploadController {

    @Autowired
    PicUploadFileSystemService fileSystemService;

    @PostMapping
    public PicUploadResult upload(@RequestParam("file") MultipartFile file){
        return fileSystemService.upload(file);
    }
}
