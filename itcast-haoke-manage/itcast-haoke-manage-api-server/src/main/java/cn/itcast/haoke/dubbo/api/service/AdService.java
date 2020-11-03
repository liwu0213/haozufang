package cn.itcast.haoke.dubbo.api.service;

import cn.itcast.haoke.dubbo.server.api.ApiAdService;
import cn.itcast.haoke.dubbo.server.pojo.Ad;
import cn.itcast.haoke.dubbo.server.pojo.PageInfo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class AdService {

    @Reference(version = "1.0")
    private ApiAdService apiAdService;

    public PageInfo<Ad> queryIndexAd(int type,int page,int pageSize){
        PageInfo<Ad> pageInfo = apiAdService.queryAdList(type, page, pageSize);
        return pageInfo;
    }
}
