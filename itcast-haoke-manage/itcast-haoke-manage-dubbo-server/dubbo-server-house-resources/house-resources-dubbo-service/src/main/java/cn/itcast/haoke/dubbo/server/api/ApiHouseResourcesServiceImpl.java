package cn.itcast.haoke.dubbo.server.api;

import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.dubbo.server.pojo.PageInfo;
import cn.itcast.haoke.dubbo.server.service.HouseResourcesService;
import cn.itcast.haoke.dubbo.server.vo.HouseResourcesInputVo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class ApiHouseResourcesServiceImpl implements ApiHouseResourcesService {

    @Autowired
    private HouseResourcesService houseResourcesService;

    @Override
    public int saveHouseResources(HouseResources houseResources) {

        return houseResourcesService.saveHouseResources(houseResources);
    }

    @Override
    public PageInfo<HouseResources> queryHouseResourcesList(int pageNum, int pageSize,
                           HouseResourcesInputVo params) {
        return houseResourcesService.getHouseResourcesList( pageNum, pageSize, params);
    }

    @Override
    public HouseResources queryHouseResourcesById(Long id) {
        return houseResourcesService.queryHouseResourcesById(id);
    }

    @Override
    public boolean update(HouseResources houseResources) {
        return houseResourcesService.updateHouseResources(houseResources);
    }


}
