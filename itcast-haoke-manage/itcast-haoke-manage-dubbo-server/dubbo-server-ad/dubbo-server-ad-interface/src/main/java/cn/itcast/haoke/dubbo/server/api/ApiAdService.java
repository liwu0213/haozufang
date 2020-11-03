package cn.itcast.haoke.dubbo.server.api;

import cn.itcast.haoke.dubbo.server.pojo.Ad;
import cn.itcast.haoke.dubbo.server.pojo.PageInfo;

public interface ApiAdService {

    public PageInfo<Ad> queryAdList(int adType,int page,int pageSize);
}
