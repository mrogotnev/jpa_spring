package com.mrogotnev.jpa_spring.mappers;

import com.mrogotnev.jpa_spring.dto.OldProjectJSONFormat;
import com.mrogotnev.jpa_spring.entity.Client;
import com.mrogotnev.jpa_spring.entity.Project;

public class ProjectMapper {

    public Project oldProjectJsonToEntityProject(OldProjectJSONFormat oldProjectJSONFormat) {
        Project project = new Project();
        Client client = new Client();
        client.setId(oldProjectJSONFormat.getClientId());
        project.setClient(client);
        project.setProjectName(oldProjectJSONFormat.getProjectName());
        project.setStatus(oldProjectJSONFormat.isStatus());
        return project;
    }

    public OldProjectJSONFormat EntityProjectToOldProjectJson(Project project) {
        OldProjectJSONFormat oldProjectJSONFormat = new OldProjectJSONFormat();
        oldProjectJSONFormat.setClientId(project.getClient().getId());
        oldProjectJSONFormat.setProjectName(project.getProjectName());
        oldProjectJSONFormat.setStatus(oldProjectJSONFormat.isStatus());
        return oldProjectJSONFormat;
    }


}
