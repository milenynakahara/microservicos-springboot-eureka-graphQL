package br.com.enterprise.poccarservice.resolvers;

import br.com.enterprise.poccarservice.inputs.CarInput;
import br.com.enterprise.poccarservice.models.Car;
import br.com.enterprise.poccarservice.repositories.CarRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    CarRepository carRepository;

    public List<Car> findAllCars(){
        return carRepository.findAll();
    }

    public Car findCarById(Long id){
        return carRepository.findById(id).orElse(null);
    }

    public Car createCar(CarInput carInput){
        Car car = new Car(carInput.getModel(), carInput.getBrand());
        return carRepository.save(car);
    }

    public Car updateCar(Long id, CarInput carInput){

        Car carFound = carRepository.findById(id).orElse(null);

        if(carFound == null) return null;

        Car car = new Car(id, carInput.getModel(), carInput.getBrand());

        return carRepository.save(car);
    }

    public String deleteCar(Long id) {
        Car carFound = carRepository.findById(id).orElse(null);

        if(carFound == null) return "Carro não encontrado na base de dados";

        carRepository.delete(carFound);

        return "Carro removido com sucesso";
    }

}
