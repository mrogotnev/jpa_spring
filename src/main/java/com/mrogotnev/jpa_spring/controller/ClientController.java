package com.mrogotnev.jpa_spring.controller;

import com.mrogotnev.jpa_spring.entity.Client;
import com.mrogotnev.jpa_spring.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;
    @GetMapping("/getAllClients")
    public Iterable<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/readClients/{id}")
    public Client readClient(@PathVariable int id) {
        return clientService.readClient(id);
    }

    @PostMapping(value = "/createClient", consumes = {"application/json"})
    public void createClient(@RequestBody Client client) {
        clientService.createClient(client);
    }

    @PutMapping("/updateClient/{id}")
    public void updateClient(@PathVariable int id, @RequestBody Client client) {
        clientService.updateClient(id, client);
    }

    @DeleteMapping ("/deleteClient/{id}")
    public void deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);
    }
}
