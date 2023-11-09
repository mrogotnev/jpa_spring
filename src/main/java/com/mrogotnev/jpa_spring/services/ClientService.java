package com.mrogotnev.jpa_spring.services;

import com.mrogotnev.jpa_spring.dao.ClientDao;
import com.mrogotnev.jpa_spring.entity.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientService {
    private ClientDao clientDao;

    public Iterable<Client> getAllClients() {
        return clientDao.findAll();
    }

    public void createClient(Client client) {
        clientDao.save(client);
    }

    public Client readClient(int id) {
        return clientDao.findById((long) id).stream().findAny().orElse(null);
    }

    public void updateClient(int id, Client client) {
        client.setId(id);
        clientDao.save(client);
    }

    public void deleteClient(int id) {
        clientDao.deleteById((long) id);
    }
}
