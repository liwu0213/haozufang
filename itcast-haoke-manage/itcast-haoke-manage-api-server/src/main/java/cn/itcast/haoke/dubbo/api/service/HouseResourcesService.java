package cn.itcast.haoke.dubbo.api.service;

import cn.itcast.haoke.dubbo.server.api.ApiHouseResourcesService;
import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.dubbo.server.pojo.PageInfo;
import cn.itcast.haoke.dubbo.server.vo.HouseResourcesInputVo;
import cn.itcast.haoke.houseResources.response.Pagination;
import cn.itcast.haoke.houseResources.response.TableResult;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class HouseResourcesService {

    @Reference(version = "1.0.0")
    private ApiHouseResourcesService apiHouseResourcesService;

    public boolean save(HouseResources houseResources){
        int i = apiHouseResourcesService.saveHouseResources(houseResources);
        return i==1;
    }

    public TableResult<HouseResources> list(HouseResourcesInputVo params, Integer pageNum, Integer pageSize) {
        PageInfo<HouseResources> pageInfo = apiHouseResourcesService.queryHouseResourcesList(pageNum, pageSize, params);
        TableResult result = new TableResult();
        result.setList(pageInfo.getRecords());
        Pagination pagination = new Pagination();
        pagination.setTotal(pageInfo.getTotal());
        pagination.setCurrent(pageInfo.getPageNum());
        pagination.setPageSize(pageInfo.getPageSize());
        result.setPagination(pagination);
        return result;
    }

    public HouseResources queryHouseResourcesById(Long id){
        return apiHouseResourcesService.queryHouseResourcesById(id);
    }

    public boolean update(HouseResources houseResources) {
        return this.apiHouseResourcesService.update(houseResources);
    }
}
