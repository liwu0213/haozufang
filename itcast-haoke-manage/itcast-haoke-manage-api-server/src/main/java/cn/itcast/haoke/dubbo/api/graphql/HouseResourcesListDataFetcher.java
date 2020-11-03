package cn.itcast.haoke.dubbo.api.graphql;

import cn.itcast.haoke.dubbo.api.service.HouseResourcesService;
import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import cn.itcast.haoke.houseResources.response.TableResult;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HouseResourcesListDataFetcher implements DataFetcherInf<TableResult<HouseResources>> {

    @Autowired
    private HouseResourcesService houseResourcesService;

    @Override
    public String FieldName() {
        return "HouseResourcesList";
    }

    @Override
    public TableResult<HouseResources> data(DataFetchingEnvironment evi) {
        Integer page = evi.getArgumentOrDefault("page",1);
        Integer pageSize = evi.getArgumentOrDefault("pageSize",5);
        return houseResourcesService.list(null,page,pageSize);
    }
}
