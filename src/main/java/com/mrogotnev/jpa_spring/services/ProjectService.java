package com.mrogotnev.jpa_spring.services;

import com.mrogotnev.jpa_spring.dao.ProjectDao;
import com.mrogotnev.jpa_spring.dto.OldProjectJSONFormat;
import com.mrogotnev.jpa_spring.entity.Client;
import com.mrogotnev.jpa_spring.entity.Project;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProjectService {
    private ProjectDao projectDao;
    private ClientService clientService;

    public Iterable<Project> getAllProjects() {
        return projectDao.findAll();
    }

    public Project readProject(int id) {
        return projectDao.findById((long) id).stream().findAny().orElse(null);
    }

    public void createProject(OldProjectJSONFormat oldProjectJSONFormat) {
        Project project = new Project();
        project.setProjectName(oldProjectJSONFormat.getProjectName());
        project.setStatus(oldProjectJSONFormat.isStatus());
        Client client = new Client();
        client.setId(oldProjectJSONFormat.getClientId());
        project.setClient(client);
        projectDao.save(project);
    }

    public void updateProject(int id, Project project) {
        project.setId(id);
        projectDao.save(project);
    }

    public void deleteProject(int id) {
        projectDao.deleteById((long) id);
    }
}