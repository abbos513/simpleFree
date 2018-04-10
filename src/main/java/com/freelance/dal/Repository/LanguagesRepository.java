package com.freelance.dal.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguagesRepository extends CrudRepository<com.freelance.dal.Entity.Languages, Long> {
    public Iterable<com.freelance.dal.Entity.Languages> findAll();
}