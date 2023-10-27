package com.mrogotnev.jpa_spring.dao;

import com.mrogotnev.jpa_spring.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProjectDao extends CrudRepository<Project, Long> {

}
