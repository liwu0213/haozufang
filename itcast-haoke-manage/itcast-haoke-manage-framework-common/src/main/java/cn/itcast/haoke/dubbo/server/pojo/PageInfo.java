package cn.itcast.haoke.dubbo.server.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@Data
public class PageInfo<T> implements Serializable {

    private Integer pageSize;
    private Integer total;
    private Integer pageNum;

    private List<T> records = Collections.emptyList();

}
