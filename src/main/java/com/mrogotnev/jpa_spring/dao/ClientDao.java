package com.mrogotnev.jpa_spring.dao;

import com.mrogotnev.jpa_spring.entity.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientDao extends CrudRepository<Client, Long> {
    List<Client> findAll();
}
