package cn.itcast.haoke.dubbo.server.service.impl;

import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.dubbo.server.pojo.PageInfo;
import cn.itcast.haoke.dubbo.server.service.HouseResourcesService;
import cn.itcast.haoke.dubbo.server.vo.HouseResourcesInputVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class HouseResourcesServiceImpl extends BaseServiceImpl<HouseResources>
                implements HouseResourcesService {

    public int saveHouseResources(HouseResources houseResources){
        if (StringUtils.isBlank(houseResources.getTitle())){
            return -1;
        }
        return super.save(houseResources);
    }

    @Override
    public PageInfo<HouseResources> getHouseResourcesList(int pageNum, int pageSize, HouseResourcesInputVo params) {
        QueryWrapper<HouseResources> queryWrapper = null;
        if (params != null) {
            HouseResources queryCondition = params.convertToEntity(HouseResources::new);
            queryWrapper = new QueryWrapper<>(queryCondition);
            queryWrapper.orderByDesc("updated");
        }

        IPage<HouseResources> houseResourcesIPage = super.queryPageList(
                queryWrapper, pageNum, pageSize );

        PageInfo<HouseResources> page = new PageInfo<>();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        page.setRecords(houseResourcesIPage.getRecords());
        page.setTotal( Long.valueOf(houseResourcesIPage.getTotal()).intValue() );
        return page;
    }

    @Override
    public HouseResources queryHouseResourcesById(Long id) {
        return super.queryById(id);
    }

    @Override
    public boolean updateHouseResources(HouseResources houseResources) {
        return super.update(houseResources) > 0;
    }


}
