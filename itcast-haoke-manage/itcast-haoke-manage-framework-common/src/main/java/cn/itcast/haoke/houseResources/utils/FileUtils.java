package cn.itcast.haoke.houseResources.utils;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Random;


public class FileUtils {

    public static final String generateFilePath(String fileBasePath,String fileType){
        LocalDateTime now = LocalDateTime.now();
        StringBuilder filePathStr = new StringBuilder(fileBasePath);
        filePathStr.append("images").append(File.separator)
                .append(now.getYear()).append(File.separator)
                .append(now.getMonthValue()).append(File.separator)
                .append(now.getDayOfMonth());
        File filePath = new File(filePathStr.toString());
        if (!filePath.exists()){
            filePath.mkdirs();
        }
        String newFileName =
                Instant.now().getEpochSecond() + new Random().nextInt(100) + fileType;
        return filePath +File.separator + newFileName;
    }
}
