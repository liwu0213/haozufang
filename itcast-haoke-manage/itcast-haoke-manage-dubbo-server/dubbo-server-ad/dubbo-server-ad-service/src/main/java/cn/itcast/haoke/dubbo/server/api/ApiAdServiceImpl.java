package cn.itcast.haoke.dubbo.server.api;

import cn.itcast.haoke.dubbo.server.pojo.Ad;
import cn.itcast.haoke.dubbo.server.pojo.PageInfo;
import cn.itcast.haoke.dubbo.server.service.AdService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0")
public class ApiAdServiceImpl implements ApiAdService{

    @Autowired
    private AdService adService;

    @Override
    public PageInfo<Ad> queryAdList(int adType, int page, int pageSize) {
        return adService.queryAdList(adType,page,pageSize);
    }
}
