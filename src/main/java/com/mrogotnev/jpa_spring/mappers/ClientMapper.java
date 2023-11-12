package com.mrogotnev.jpa_spring.mappers;

import com.mrogotnev.jpa_spring.dto.OldClientJSONFormat;
import com.mrogotnev.jpa_spring.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public Client oldJsonToEntityClient(OldClientJSONFormat oldClientJSONFormat) {
        Client client = new Client();
        if (oldClientJSONFormat.getId() != null) {
            client.setId((long) oldClientJSONFormat.getId());
        }
        client.setFirstName(oldClientJSONFormat.getFirstName());
        client.setLastName(oldClientJSONFormat.getLastName());
        client.setCompanyName(oldClientJSONFormat.getCompanyName());
        return client;
    }

    public OldClientJSONFormat entityClientToOldJson (Client client) {
        OldClientJSONFormat oldClientJSONFormat = new OldClientJSONFormat();
        if (client.getId() != null) {
            oldClientJSONFormat.setId(client.getId());
        }
        oldClientJSONFormat.setFirstName(client.getFirstName());
        oldClientJSONFormat.setLastName(client.getLastName());
        oldClientJSONFormat.setCompanyName(client.getCompanyName());
        return oldClientJSONFormat;
    }
}
