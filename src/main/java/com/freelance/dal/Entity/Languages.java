package com.freelance.dal.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Languages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @OneToMany(mappedBy = "language")
    private List<UserLanguageLevel> userLanguageLevels;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<UserLanguageLevel> getUserLanguageLevels() {
        return userLanguageLevels;
    }

    public void setUserLanguageLevels(List<UserLanguageLevel> userLanguageLevels) {
        this.userLanguageLevels = userLanguageLevels;
    }
}
