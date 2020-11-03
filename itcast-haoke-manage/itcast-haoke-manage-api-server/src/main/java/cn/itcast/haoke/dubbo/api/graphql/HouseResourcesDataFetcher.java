package cn.itcast.haoke.dubbo.api.graphql;

import cn.itcast.haoke.dubbo.api.service.HouseResourcesService;
import cn.itcast.haoke.dubbo.server.pojo.HouseResources;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HouseResourcesDataFetcher implements DataFetcherInf<HouseResources> {

    @Autowired
    private HouseResourcesService houseResourcesService;

    @Override
    public String FieldName() {
        return "HouseResources";
    }

    @Override
    public HouseResources data(DataFetchingEnvironment evi) {
        Long id = evi.getArgument("id");
        return houseResourcesService.queryHouseResourcesById(id);
    }
}
