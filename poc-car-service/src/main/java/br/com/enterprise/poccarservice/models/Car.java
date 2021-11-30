package br.com.enterprise.poccarservice.models;


import br.com.enterprise.poccarservice.enums.Brand;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String model;

    @Column
    private Brand brand;

    public Car(){}

    public Car(Long id, String model, Brand brand){
        this.id = id;
        this.model = model;
        this.brand = brand;
    }

    public Car(String model, Brand brand){
        this.model = model;
        this.brand = brand;
    }

}
