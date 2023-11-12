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
    public Iterable<OldProjectJSONFormat> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/readProject/{id}")
    public OldProjectJSONFormat readProject(@PathVariable Long id) {
        return projectService.readProject(id);
    }

    @PostMapping(value = "/createProject", consumes = {"application/json"})
    public Long createEmployee(@RequestBody OldProjectJSONFormat oldProjectJSONFormat) {
        return projectService.createProject(oldProjectJSONFormat);
    }

    @PutMapping("/updateProject/{id}")
    public void updateProject(@PathVariable Long id, @RequestBody Project project) {
        projectService.updateProject(id, project);
    }

    @DeleteMapping("/deleteProject/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }

}
