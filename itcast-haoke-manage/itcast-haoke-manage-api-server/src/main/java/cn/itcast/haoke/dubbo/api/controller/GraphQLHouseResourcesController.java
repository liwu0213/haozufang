package cn.itcast.haoke.dubbo.api.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController("graphql")
@CrossOrigin
public class GraphQLHouseResourcesController {

    @Autowired
    private GraphQL graphQL;

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @PostMapping
    public Map<String,Object> findHouseResourcesById(@RequestBody Map<String,Object> map) throws IOException {
        String query = (String)map.get("query");
        String operationName = (String)map.get("operationName");
        Map variables = (Map)map.get("variables");
        if (!StringUtils.isEmpty(query)) {
            ExecutionResult execute = graphQL.execute(ExecutionInput.newExecutionInput()
                    .query(query)
                    .operationName(operationName)
                    .variables(variables)
                    .build()
            );
            return execute.toSpecification();
        }
        return null;
    }
}
