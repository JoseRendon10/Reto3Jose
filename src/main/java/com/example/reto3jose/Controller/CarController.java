package com.example.reto3jose.Controller;

import com.example.reto3jose.Entities.Car;
import com.example.reto3jose.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Car")
@CrossOrigin(origins = "*")

public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public List<Car> getAll() { return carService.getAll(); }

    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable("id") int id) { return carService.getCar(id); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Car save(@RequestBody Car car) { return carService.save(car); }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Car update(@RequestBody Car car) { return carService.update(car); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int carId) { return carService.delete(carId); }
}
