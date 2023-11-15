package com.mrogotnev.jpa_spring.services;

import com.mrogotnev.jpa_spring.dao.ProjectDao;
import com.mrogotnev.jpa_spring.dto.OldProjectJSONFormat;
import com.mrogotnev.jpa_spring.entity.Project;
import com.mrogotnev.jpa_spring.mappers.ProjectMapper;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class ProjectService {
    private ProjectDao projectDao;
    private ProjectMapper projectMapper;
    private EntityManager entityManager;

    public Iterable<OldProjectJSONFormat> getAllProjects() {
        Iterable<Project> projects = projectDao.findAll();
        ArrayList<OldProjectJSONFormat> oldProjects = new ArrayList<>();
        for (Project project : projects) {
            oldProjects.add(projectMapper.entityProjectToOldProjectJson(project));
        }
        return oldProjects;
    }

    public OldProjectJSONFormat readProject(Long id) {
        Project project = projectDao.findById(id).stream().findAny().orElse(null);
        return projectMapper.entityProjectToOldProjectJson(project);
    }

    @Transactional
    public Long createProject(OldProjectJSONFormat oldProjectJSONFormat) {
        Project project = projectMapper.oldProjectJsonToEntityProject(oldProjectJSONFormat);
        entityManager.persist(project);
        entityManager.flush();
        return project.getId();
    }

    public void updateProject(Long id, OldProjectJSONFormat oldProject) {
        Project project = projectMapper.oldProjectJsonToEntityProject(oldProject);
        project.setId(id);
        projectDao.save(project);
    }

    public void deleteProject(Long id) {
        projectDao.deleteById(id);
    }
}