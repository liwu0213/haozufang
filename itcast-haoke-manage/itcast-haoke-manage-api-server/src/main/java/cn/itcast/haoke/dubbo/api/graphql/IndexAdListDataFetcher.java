package cn.itcast.haoke.dubbo.api.graphql;

import cn.itcast.haoke.dubbo.api.service.AdService;
import cn.itcast.haoke.dubbo.api.vo.IndexAdResult;
import cn.itcast.haoke.dubbo.api.vo.IndexAdResultData;
import cn.itcast.haoke.dubbo.server.pojo.Ad;
import cn.itcast.haoke.dubbo.server.pojo.PageInfo;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IndexAdListDataFetcher implements DataFetcherInf<IndexAdResult>{
    @Autowired
    private AdService adService;

    @Override
    public String FieldName() {
        return "IndexAdList";
    }

    @Override
    public IndexAdResult data(DataFetchingEnvironment evi) {
        PageInfo<Ad> pageInfo = adService.queryIndexAd(1, 1, 5);
        List<IndexAdResultData> list = new ArrayList<>();
        pageInfo.getRecords().forEach(ad -> {
            IndexAdResultData data = new IndexAdResultData(ad.getUrl());
            list.add(data);
        });
        return new IndexAdResult(list);
    }
}
