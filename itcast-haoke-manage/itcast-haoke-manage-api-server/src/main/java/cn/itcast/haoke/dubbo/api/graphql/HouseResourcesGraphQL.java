package cn.itcast.haoke.dubbo.api.graphql;

import cn.itcast.haoke.dubbo.api.service.HouseResourcesService;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.util.List;

@Component
public class HouseResourcesGraphQL {

    private GraphQL graphQL;

    @Autowired
    private HouseResourcesService houseResourcesService;

    @Autowired
    private List<DataFetcherInf> dataFetcherInfList;

    @PostConstruct
    public void init() throws FileNotFoundException {
        TypeDefinitionRegistry registry = new SchemaParser().parse(
                ResourceUtils.getFile("classpath:haoke.graphqls"));

        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registry,runtimeWiring());
        GraphQL graphQL = GraphQL.newGraphQL(schema).build();
        this.graphQL = graphQL;
    }

    private RuntimeWiring runtimeWiring(){
        RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
                .type("HaokeQuery",builder -> {
                        dataFetcherInfList.forEach(data -> {
                            builder.dataFetcher(data.FieldName(),dataFetchingEnvironment -> {
                                return data.data(dataFetchingEnvironment);
                            });
                        });
                        return builder;
                     }
                ).build();
        return runtimeWiring;
    }

    @Bean
    public GraphQL createGraphQL(){
        return this.graphQL;
    }

}
