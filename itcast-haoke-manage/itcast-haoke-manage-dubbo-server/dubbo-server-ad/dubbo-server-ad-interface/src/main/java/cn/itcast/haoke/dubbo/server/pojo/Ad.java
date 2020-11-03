package cn.itcast.haoke.dubbo.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_ad")
public class Ad extends BasePojo {

    @TableId(type = IdType.AUTO)
    private Long id;
    //广告类型
    private Integer type;
    //描述
    private String title;
    //'图片URL地址
    private String url;

}
