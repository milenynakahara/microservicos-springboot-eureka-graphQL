package br.com.enterprise.poccarservice.inputs;

import br.com.enterprise.poccarservice.enums.Brand;
import graphql.schema.GraphQLInputType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarInput implements GraphQLInputType {

    private String model;
    private Brand brand;

    @Override
    public String getName() {
        return null;
    }
}
