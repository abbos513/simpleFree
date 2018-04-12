package com.freelance.dal.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageLevelRepository extends CrudRepository<com.freelance.dal.Entity.LanguageLevel, Long>{
    public List<com.freelance.dal.Entity.LanguageLevel> findAll();
}