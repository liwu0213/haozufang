package cn.itcast.haoke.dubbo.server.vo;

import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.houseResources.request.EntityConvert;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class HouseResourcesInputVo
        implements EntityConvert<HouseResourcesInputVo, HouseResources>, Serializable {

    private Long estateId;
    private Date updated;

}
