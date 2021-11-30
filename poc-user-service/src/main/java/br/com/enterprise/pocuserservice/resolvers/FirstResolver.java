package br.com.enterprise.pocuserservice.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class FirstResolver implements GraphQLQueryResolver {

    public String hello(){
        return "Hello World";
    }

}
