package cn.itcast.graphql.demo;


import cn.itcast.graphql.vo.Card;
import cn.itcast.graphql.vo.User;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class GraphQLSDLDemo {

    public static void main(String[] args) {

        String userGraphQLDefine = null;
        try {
            userGraphQLDefine = IOUtils.toString(GraphQLSDLDemo.class.getClassLoader().getResource("user.graphqls").openStream(), "utf-8");
            TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(userGraphQLDefine);

            RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
                    .type("UserQuery",builder ->
                        builder.dataFetcher("user",dataFetchingEnvironment -> {
                            Long id = dataFetchingEnvironment.getArgument("id");
                            return new User(2L,"abc",23,new Card("xxx",2L));
                        })
                    ).build();


            GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry,runtimeWiring);
            GraphQL graphQL = GraphQL.newGraphQL(schema).build();

            ExecutionResult execute = graphQL.execute("{user(id:1){id,name,card{userId}} }");
            System.out.println(execute.toSpecification());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
