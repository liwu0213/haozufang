package cn.itcast.haoke.houseResources.utils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public enum FileTypeEnum {

    BPM(".bmp","img"),
    JPG(".jpg","img"),
    JPEG(".jpeg","img"),
    GIF(".gif","img"),
    PNG(".png","img")
    ;

    private String format;
    private String type;

    private FileTypeEnum(String format,String type) {
        this.format = format;
        this.type = type;
    }


    public static boolean isExitsByFormat(String format){
        Optional<String> formatOpt = Optional.of(format);
        List<FileTypeEnum> collect = Stream.of(FileTypeEnum.values()).filter(
                fileTypeEnum ->
                     formatOpt.get().equals(fileTypeEnum.getFormat())
        ).collect(Collectors.toList());
        return collect.size() > 0;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
