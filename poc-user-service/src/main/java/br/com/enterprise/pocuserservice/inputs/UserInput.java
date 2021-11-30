package br.com.enterprise.pocuserservice.inputs;

import graphql.schema.GraphQLInputType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInput implements GraphQLInputType {

    private String name;
    private int cpf;

    @Override
    public String getName() {
        return name;
    }


}
