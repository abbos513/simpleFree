package com.freelance.dal.Repository;

import com.freelance.dal.Entity.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    public Project findById(Long id);
    public List<Project> findAll();
}
