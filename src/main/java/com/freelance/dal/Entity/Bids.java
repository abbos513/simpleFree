package com.freelance.dal.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Bids {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private MyUser user;
    private String bidText;
    private Date offeredDeadline;
    private double offeredPrice;
    @ManyToOne
    private Project project;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }

    public String getBidText() {
        return bidText;
    }

    public void setBidText(String bidText) {
        this.bidText = bidText;
    }

    public String getOfferedDeadline() {
        int year = offeredDeadline.getYear()+1900;
        int month = offeredDeadline.getMonth()+1;
        int day = offeredDeadline.getDate();
        return ""+day+" / "+month+" / "+year;
    }

    public void setOfferedDeadline(Date offeredDeadline) {
        this.offeredDeadline = offeredDeadline;
    }

    public double getOfferedPrice() {
        return offeredPrice;
    }

    public void setOfferedPrice(double offeredPrice) {
        this.offeredPrice = offeredPrice;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    public String getUserFullName() {
        return user.getFirstName() + " " + user.getLastName();
    }


}
