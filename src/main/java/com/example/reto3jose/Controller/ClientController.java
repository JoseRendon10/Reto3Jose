package com.reto3.reto3g24.Controller;

import com.reto3.reto3g24.Entities.Client;
import com.reto3.reto3g24.Entities.Gama;
import com.reto3.reto3g24.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")

public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll() { return clientService.getAll();}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client p) { return clientService.save(p); }
}
