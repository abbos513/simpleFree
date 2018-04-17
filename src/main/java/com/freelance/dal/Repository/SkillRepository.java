package com.freelance.dal.Repository;

import com.freelance.dal.Entity.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {
    public Iterable<Skill> findByType(String type);
}
