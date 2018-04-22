package com.freelance.dal.Repository;

import com.freelance.dal.Entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    public Project findById(Long id);
}
