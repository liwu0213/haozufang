package cn.itcast.haoke.dubbo.server.service;

import cn.itcast.haoke.dubbo.server.pojo.Ad;
import cn.itcast.haoke.dubbo.server.pojo.PageInfo;

public interface AdService {

    public PageInfo<Ad> queryAdList(int adType, int page, int pageSize);
}
