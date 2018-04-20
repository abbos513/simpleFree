package com.freelance.dal.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class LanguageLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    private String level;
    @OneToMany(mappedBy = "level")
    private List<UserLanguageLevel> userLanguageLevels;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<UserLanguageLevel> getUserLanguageLevels() {
        return userLanguageLevels;
    }

    public void setUserLanguageLevels(List<UserLanguageLevel> userLanguageLevels) {
        this.userLanguageLevels = userLanguageLevels;
    }
}
