package com.example.reto3jose.Controller;

import com.example.reto3jose.Entities.Gama;
import com.example.reto3jose.Service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Gama")
@CrossOrigin(origins = "*")

public class GamaController {
    @Autowired
    private GamaService gamaService;

    @GetMapping("/all")
    public List<Gama> getAll() { return gamaService.getAll(); }

    @GetMapping("/{id}")
    public Optional<Gama> getGama(@PathVariable("id") int id) { return gamaService.getGama(id); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama save (@RequestBody Gama gama) { return gamaService.save(gama); }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama update(@RequestBody Gama gama) { return gamaService.update(gama); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int gamaId) { return gamaService.delete(gamaId); }
}
