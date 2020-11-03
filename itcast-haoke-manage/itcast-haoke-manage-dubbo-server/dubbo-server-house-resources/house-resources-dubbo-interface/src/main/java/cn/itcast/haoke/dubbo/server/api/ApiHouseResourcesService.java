package cn.itcast.haoke.dubbo.server.api;

import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.dubbo.server.pojo.PageInfo;
import cn.itcast.haoke.dubbo.server.vo.HouseResourcesInputVo;

public interface ApiHouseResourcesService {
    /**
     @return -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
     */
    int saveHouseResources(HouseResources houseResources);

    PageInfo<HouseResources> queryHouseResourcesList(int pageNum, int pageSize, HouseResourcesInputVo params);

    HouseResources queryHouseResourcesById(Long id);

    boolean update(HouseResources houseResources);
}
