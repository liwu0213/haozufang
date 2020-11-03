package cn.itcast.haoke.dubbo.api.graphql;

import graphql.schema.DataFetchingEnvironment;

public interface DataFetcherInf<T>{

    String FieldName();
    T data(DataFetchingEnvironment evi);
}
