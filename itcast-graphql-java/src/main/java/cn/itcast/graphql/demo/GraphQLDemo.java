package cn.itcast.graphql.demo;


import cn.itcast.graphql.vo.Card;
import cn.itcast.graphql.vo.User;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.Scalars;
import graphql.schema.*;


public class GraphQLDemo {

    public static void main(String[] args) {

        GraphQLObjectType cardType = GraphQLObjectType.newObject()
                .name("Card")
                .field(
                        GraphQLFieldDefinition.newFieldDefinition().name("cardNumber")
                                .type(Scalars.GraphQLString).build()
                ).field(
                        GraphQLFieldDefinition.newFieldDefinition().name("userId")
                                .type(Scalars.GraphQLLong).build()
                ).build();


        GraphQLObjectType userType = GraphQLObjectType.newObject()
                .name("User")
                .field(
                        GraphQLFieldDefinition.newFieldDefinition().name("id")
                                .type(Scalars.GraphQLLong).build()
                ).field(
                        GraphQLFieldDefinition.newFieldDefinition().name("name")
                                .type(Scalars.GraphQLString).build()
                ).field(
                        GraphQLFieldDefinition.newFieldDefinition().name("age")
                                .type(Scalars.GraphQLInt).build()
                ).field(
                        GraphQLFieldDefinition.newFieldDefinition().name("card")
                                .type(cardType).build()
                ).build();

        GraphQLFieldDefinition fieldDefinition = GraphQLFieldDefinition.newFieldDefinition()
                .name("user")
                .type(userType)
                .argument(GraphQLArgument.newArgument().name("id").type(Scalars.GraphQLLong).build())
                .dataFetcher( environment -> {
                            Long id = environment.getArgument("id");
                            return new User(1L,"liwu",23,new Card("123123",1L));
                        }
                )
                .build();
        GraphQLObjectType UserQueryType = GraphQLObjectType.newObject()
                .name("UserQuery")
                .field(fieldDefinition)
                .build();
        GraphQLSchema graphQLSchema = GraphQLSchema.newSchema()
                .query(UserQueryType)
                .build();
        GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema).build();
        String query = "{user(id:1){id,name,card{userId,cardNumber}}}";
        ExecutionResult execute = graphQL.execute(query);
        System.out.println(execute.toSpecification());
    }
}
