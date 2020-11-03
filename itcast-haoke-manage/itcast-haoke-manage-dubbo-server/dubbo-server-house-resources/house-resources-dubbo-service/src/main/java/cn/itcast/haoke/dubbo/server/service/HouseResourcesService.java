package cn.itcast.haoke.dubbo.server.service;

import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.dubbo.server.pojo.PageInfo;
import cn.itcast.haoke.dubbo.server.vo.HouseResourcesInputVo;

public interface HouseResourcesService {

    int saveHouseResources(HouseResources houseResources);

    PageInfo<HouseResources> getHouseResourcesList(int pageNum, int pageSize, HouseResourcesInputVo params);

    HouseResources queryHouseResourcesById(Long id);

    boolean updateHouseResources(HouseResources houseResources);
}
