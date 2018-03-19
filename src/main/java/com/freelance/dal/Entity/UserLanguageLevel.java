package com.freelance.dal.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserLanguageLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private MyUser user;
    @ManyToOne
    private Languages languages;
    @ManyToOne
    private LanguageLevel level;
}
