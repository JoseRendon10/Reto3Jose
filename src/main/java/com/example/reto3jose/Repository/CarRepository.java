package com.reto3.reto3g24.Repository;

import com.reto3.reto3g24.Entities.Car;
import com.reto3.reto3g24.Repository.crudRepository.CarCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {

    @Autowired
    private CarCrudRepository carCrudRepository;

    public List<Car> getAll() { return (List<Car>) carCrudRepository.findAll(); }
    public Optional<Car> getCar(int id) { return carCrudRepository.findById(id); }
    public Car save(Car p) { return carCrudRepository.save(p); }
    public void delete(Car p) { carCrudRepository.delete(p); }

}
