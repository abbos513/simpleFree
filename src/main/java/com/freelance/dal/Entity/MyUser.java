package com.freelance.dal.Entity;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @OneToMany(mappedBy = "user")
    private List<UserLanguageLevel> languages;
    private String city;
    private String regionState;
    private String country;
    private String aboutText;
    @ManyToMany
    private List<Skill> skills;
    @OneToMany(mappedBy = "user")
    private List<Project> projects;
    @OneToMany(mappedBy = "user")
    private List<Bids> bids;
    @Nullable
    private boolean isFilled;

    public List<Bids> getBids() {
        return bids;
    }

    public void setBids(List<Bids> bids) {
        this.bids = bids;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<UserLanguageLevel> getLanguages() {
        return languages;
    }

    public void setLanguages(List<UserLanguageLevel> languages) {
        this.languages = languages;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public MyUser(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public MyUser() {    }

    public MyUser(String firstName, String lastName, String phoneNumber, List<UserLanguageLevel> languages, String city, String regionState, String country, String aboutText) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.languages = languages;
        this.city = city;
        this.regionState = regionState;
        this.country = country;
        this.aboutText = aboutText;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegionState() {
        return regionState;
    }

    public void setRegionState(String regionState) {
        this.regionState = regionState;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAboutText() {
        return aboutText;
    }

    public void setAboutText(String aboutText) {
        this.aboutText = aboutText;
    }
}
