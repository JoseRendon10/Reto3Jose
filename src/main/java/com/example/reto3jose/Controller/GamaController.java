package com.reto3.reto3g24.Controller;

import com.reto3.reto3g24.Entities.Gama;
import com.reto3.reto3g24.Service.GamaService;
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