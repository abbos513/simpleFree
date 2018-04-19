package com.freelance.dal.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String skill;
    private String type;
    @ManyToMany
    private List<MyUser> user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
