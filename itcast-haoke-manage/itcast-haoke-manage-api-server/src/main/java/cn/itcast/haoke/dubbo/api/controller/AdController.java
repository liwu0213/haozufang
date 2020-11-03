package cn.itcast.haoke.dubbo.api.controller;

import cn.itcast.haoke.dubbo.api.service.AdService;
import cn.itcast.haoke.dubbo.api.vo.WebResult;
import cn.itcast.haoke.dubbo.server.pojo.Ad;
import cn.itcast.haoke.dubbo.server.pojo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("ad/")
@CrossOrigin
public class AdController {

    @Autowired
    private AdService adService;

    @GetMapping
    public WebResult queryIndexAd(){
        PageInfo pageInfo = adService.queryIndexAd(1, 1, 3);
        List<Ad> records = pageInfo.getRecords();
        List<Map<String,String>> data = new ArrayList<>();
        records.forEach(ad -> {
            Map<String,String> map = new HashMap<>();
            map.put("origin",ad.getUrl());
            data.add(map);
        });
       return WebResult.ok(data);
    }
}
