package com.example.reto3jose.Controller;

import com.example.reto3jose.Entities.Car;
import com.example.reto3jose.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Car")

public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public List<Car> getAll() { return carService.getAll();}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Car save(@RequestBody Car p) { return carService.save(p); }
}
