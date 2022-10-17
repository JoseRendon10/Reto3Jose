package com.example.reto3jose.Service;

import com.example.reto3jose.Entities.Car;
import com.example.reto3jose.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll() { return carRepository.getAll(); }
    public Optional<Car> getCar(int id) { return carRepository.getCar(id); }
    public Car save(Car car){
        if(car.getId() == null){
            return carRepository.save(car);
        }else{
            Optional<Car> car1 = carRepository.getCar(car.getId());
            if(car1.isPresent()){
                return car;
            }else{
                return carRepository.save(car);
            }
        }
    }
    public Car update(Car car){
        if(car.getId()!=null){
            Optional<Car> q = carRepository.getCar(car.getId());
            if(q.isPresent()){
                if(car.getName()!=null){
                    q.get().setName(car.getName());
                }
                if(car.getBrand()!=null){
                    q.get().setBrand(car.getBrand());
                }
                if(car.getYear()!=null){
                    q.get().setYear(car.getYear());
                }
                if(car.getDescription()!=null){
                    q.get().setDescription(car.getDescription());
                }
                if(car.getGama()!=null){
                    q.get().setGama(car.getGama());
                }
                carRepository.save(q.get());
                return q.get();
            }else{
                return car;
            }
        }else{
            return car;
        }
    }
    public boolean delete(int id){
        boolean d = getCar(id).map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
        return d;
    }
}
