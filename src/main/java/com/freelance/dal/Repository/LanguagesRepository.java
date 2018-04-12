package com.freelance.dal.Repository;

import com.freelance.dal.Entity.LanguageLevel;
import com.freelance.dal.Entity.Languages;
import com.freelance.dal.Entity.SignUp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguagesRepository extends CrudRepository<Languages, Long> {
    public Iterable<Languages> findAll();
}
