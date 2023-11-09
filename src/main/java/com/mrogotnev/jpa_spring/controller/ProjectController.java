package com.mrogotnev.jpa_spring.controller;

import com.mrogotnev.jpa_spring.dto.OldProjectJSONFormat;
import com.mrogotnev.jpa_spring.entity.Project;
import com.mrogotnev.jpa_spring.services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProjectController {
    private ProjectService projectService;

    @GetMapping("/getAllProjects")
    public Iterable<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/readProject/{id}")
    public Project readProject(@PathVariable int id) {
        return projectService.readProject(id);
    }

    @PostMapping(value = "/createProject", consumes = {"application/json"})
    public void createEmployee(@RequestBody OldProjectJSONFormat oldProjectJSONFormat) {
        projectService.createProject(oldProjectJSONFormat);
    }

    @PutMapping("/updateProject/{id}")
    public void updateProject(@PathVariable int id, @RequestBody Project project) {
        projectService.updateProject(id, project);
    }

    @DeleteMapping("/deleteProject/{id}")
    public void deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
    }

}
