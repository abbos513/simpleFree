package com.freelance.dal.Repository;

import com.freelance.dal.Entity.LanguageLevel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageLevelRepository extends CrudRepository<com.freelance.dal.Entity.LanguageLevel, Long>{
    public Iterable<LanguageLevel> findAll();
//    public LanguageLevel findAllById(Long id);
}