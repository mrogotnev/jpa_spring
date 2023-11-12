package com.mrogotnev.jpa_spring.controller;

import com.mrogotnev.jpa_spring.dto.OldClientJSONFormat;
import com.mrogotnev.jpa_spring.entity.Client;
import com.mrogotnev.jpa_spring.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;
    @GetMapping("/getAllClients")
    public Iterable<OldClientJSONFormat> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/readClients/{id}")
    public OldClientJSONFormat readClient(@PathVariable Long id) {
        return clientService.readClient(id);
    }

    @PostMapping(value = "/createClient", consumes = {"application/json"})
    public Long createClient(@RequestBody OldClientJSONFormat OldFormatClient) {
        return clientService.createClient(OldFormatClient);
    }

    @PutMapping("/updateClient/{id}")
    public void updateClient(@PathVariable Long id, @RequestBody OldClientJSONFormat client) {
        clientService.updateClient(id, client);
    }

    @DeleteMapping ("/deleteClient/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
