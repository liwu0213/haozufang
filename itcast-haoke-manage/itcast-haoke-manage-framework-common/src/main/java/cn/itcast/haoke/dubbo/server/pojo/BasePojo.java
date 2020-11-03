package cn.itcast.haoke.dubbo.server.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BasePojo implements Serializable {
    private static final long serialVersionUID = 3337357664905516030L;
    private Date created;
    private Date updated;
}
