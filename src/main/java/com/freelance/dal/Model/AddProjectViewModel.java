package com.freelance.dal.Model;

import java.util.Date;

public class AddProjectViewModel {

    private String projectTitle;
    private String aboutProject;
    private String deadline;
    private double projectBudget;
    private int[] skillIds;
    private int[] languageIds;

    public int[] getSkillIds() {
        return skillIds;
    }

    public void setSkillIds(int[] skillIds) {
        this.skillIds = skillIds;
    }

    public int[] getLanguageIds() {
        return languageIds;
    }

    public void setLanguageIds(int[] languageIds) {
        this.languageIds = languageIds;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getAboutProject() {
        return aboutProject;
    }

    public void setAboutProject(String aboutProject) {
        this.aboutProject = aboutProject;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public double getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(double projectBudget) {
        this.projectBudget = projectBudget;
    }
}
