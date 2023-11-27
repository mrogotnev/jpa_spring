package com.mrogotnev.jpa_spring.services;

import com.mrogotnev.jpa_spring.dao.ClientDao;
import com.mrogotnev.jpa_spring.dto.OldClientJSONFormat;
import com.mrogotnev.jpa_spring.entity.Client;
import com.mrogotnev.jpa_spring.mappers.ClientMapper;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class ClientService {
    private ClientDao clientDao;
    private ClientMapper clientMapper;
    private EntityManager entityManager;

    public Iterable<OldClientJSONFormat> getAllClients() {
        Iterable<Client> clients = clientDao.findAll();
        ArrayList<OldClientJSONFormat> oldClients = new ArrayList<>();
        for (Client client : clients) {
            oldClients.add(clientMapper.entityClientToOldJson(client));
        }
        return oldClients;
    }

    @Transactional
    public Long createClient(OldClientJSONFormat oldClientJSONFormat) {
        Client client = clientMapper.oldJsonToEntityClient(oldClientJSONFormat);
        entityManager.persist(client);
        return client.getId();
    }

    public OldClientJSONFormat readClient(Long id) {
        Client client = clientDao.findById(id).stream().findAny().orElse(null);
        return clientMapper.entityClientToOldJson(client);
    }

    public void updateClient(Long id, OldClientJSONFormat oldClient) {
        Client client = clientMapper.oldJsonToEntityClient(oldClient);
        client.setId(id);
        clientDao.save(client);
    }

    public void deleteClient(Long id) {
        clientDao.deleteById(id);
    }
}
