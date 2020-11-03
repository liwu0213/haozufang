package cn.itcast.haoke.dubbo.server.service.impl;

import cn.itcast.haoke.dubbo.server.pojo.Ad;
import cn.itcast.haoke.dubbo.server.pojo.PageInfo;
import cn.itcast.haoke.dubbo.server.service.AdService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;

@Service
public class AdServiceImpl extends BaseServiceImpl<Ad> implements AdService {


    @Override
    public PageInfo<Ad> queryAdList(int adType, int page, int pageSize) {
        QueryWrapper<Ad> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",adType);
        IPage<Ad> adIPage = super.queryPageList(queryWrapper, page, pageSize);
        PageInfo<Ad> pageInfo = new PageInfo<>();
        pageInfo.setTotal(Long.valueOf(adIPage.getTotal()).intValue());
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNum(page);
        pageInfo.setRecords(adIPage.getRecords());
        return  pageInfo;
    }
}
