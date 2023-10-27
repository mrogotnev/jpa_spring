package com.mrogotnev.jpa_spring.controller;

import com.mrogotnev.jpa_spring.dao.ProjectDao;
import com.mrogotnev.jpa_spring.entity.Client;
import com.mrogotnev.jpa_spring.entity.Project;
import com.mrogotnev.jpa_spring.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;
    private ProjectDao projectDao;
    @GetMapping("/getAllEmployees")
    public Iterable<Client> test() {
        return clientService.getAllClients();
    }

    @PostMapping("/createClient")
    public void createEmployee(@RequestBody Client client) {
        clientService.createClient(client);
    }

    @GetMapping("/getAllProjects")
    public Iterable<Project> test01() {
        return projectDao.findAll();
    }

    @PostMapping("/createProject")
    public void add(@RequestBody Project project){
        projectDao.save(project);
    }
}
