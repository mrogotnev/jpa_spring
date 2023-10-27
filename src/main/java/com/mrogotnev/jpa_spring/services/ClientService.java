package com.mrogotnev.jpa_spring.services;

import com.mrogotnev.jpa_spring.dao.ClientDao;
import com.mrogotnev.jpa_spring.entity.Client;
import com.mrogotnev.jpa_spring.entity.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientService {
    private ClientDao clientDao;
    public Iterable<Client> getAllClients() {
        return clientDao.findAll();
    }

    /*public Client readClient(int id) {
        return clientDao.readClient(id);
    }*/

    public void createClient(Client client) {
        clientDao.save(client);
    }

    /*public void updateClient(int id, Client client) {
        clientDao.updateClient(id, client);
    }

    public void deleteClient(int id) {
        clientDao.deleteClient(id);
    }*/
}
