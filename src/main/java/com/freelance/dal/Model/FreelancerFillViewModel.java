package com.freelance.dal.Model;

public class FreelancerFillViewModel {
    public String email;
    public String username;
    public String firstName;
    public String lastName;
    public String phoneNumber;

    public int[] languageId;
    public int[] levelId;

    public String city;
    public String regionState;
    public String country;

    public String aboutMe;

    public int[] skillId;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int[] getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int[] languageId) {
        this.languageId = languageId;
    }

    public int[] getLevelId() {
        return levelId;
    }

    public void setLevelId(int[] levelId) {
        this.levelId = levelId;
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

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public int[] getSkillId() {
        return skillId;
    }

    public void setSkillId(int[] skillId) {
        this.skillId = skillId;
    }
}
