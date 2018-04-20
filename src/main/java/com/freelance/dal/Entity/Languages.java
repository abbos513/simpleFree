package com.freelance.dal.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Languages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String language;
    @OneToMany(mappedBy = "language")
    private List<UserLanguageLevel> userLanguageLevels;
    @ManyToMany
    private List<Project> projects;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public List<UserLanguageLevel> getUserLanguageLevels() {
        return userLanguageLevels;
    }

    public void setUserLanguageLevels(List<UserLanguageLevel> userLanguageLevels) {
        this.userLanguageLevels = userLanguageLevels;
    }
}
