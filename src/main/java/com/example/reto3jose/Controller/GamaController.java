package com.example.reto3jose.Controller;

import com.example.reto3jose.Entities.Gama;
import com.example.reto3jose.Service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Gama")

public class GamaController {
    @Autowired
    private GamaService gamaService;

    @GetMapping("/all")
    public List<Gama> getAll() { return gamaService.getAll();}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama save(@RequestBody Gama p) { return gamaService.save(p); }
}
