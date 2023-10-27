package com.mrogotnev.jpa_spring.dao;

import com.mrogotnev.jpa_spring.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientDao extends CrudRepository<Client, Long> {
    //crud + getall
}
