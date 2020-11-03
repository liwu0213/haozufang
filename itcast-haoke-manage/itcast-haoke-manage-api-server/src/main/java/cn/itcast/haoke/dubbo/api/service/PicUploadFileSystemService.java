package cn.itcast.haoke.dubbo.api.service;

import cn.itcast.haoke.houseResources.response.PicUploadResult;
import cn.itcast.haoke.houseResources.utils.FileTypeEnum;
import cn.itcast.haoke.houseResources.utils.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.Instant;

@Service

public class PicUploadFileSystemService {

    public static final Logger logger = LoggerFactory.getLogger(PicUploadFileSystemService.class);

    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg",
            ".jpeg", ".gif", ".png"};

    @Value("${custom.file.basePath}")
    private String fileBasePath;
    @Value("${custom.file.webSite}")
    private String webSite;

    public PicUploadResult upload(MultipartFile uploadFile) {
        String name = uploadFile.getOriginalFilename();
        String type = name.substring(name.lastIndexOf("."));
        if (FileTypeEnum.isExitsByFormat(type)){
            //获取文件存储路径
            String fileFullPath = FileUtils.generateFilePath(fileBasePath ,type);
            File file = new File(fileFullPath);
            PicUploadResult picUploadResult = new PicUploadResult();
            try(FileOutputStream fos = new FileOutputStream(file)){
                IOUtils.copy(uploadFile.getInputStream(),fos);
                picUploadResult.setName(webSite+fileFullPath.substring(fileBasePath.length()+1).replace("\\","/"));
                picUploadResult.setStatus("done");
                picUploadResult.setUid(Instant.now().getEpochSecond()+"");
                return picUploadResult;
            } catch (Exception e) {
                logger.error("文件保存失败");
                picUploadResult.setStatus("error");
                return picUploadResult;
            }
        }
        return null;
    }


}
