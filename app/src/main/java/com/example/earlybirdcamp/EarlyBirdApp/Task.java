package com.example.earlybirdcamp.EarlyBirdApp;

import java.util.Date;

/**
 * Created by earlybirdcamp on 6/14/16.
 */
public class Task {

    private String title;
    private String desc;
    private int days;
    private Date due_date;

    public Task(String title, String desc, int days, Date due_date) {
        this.title = title;
        this.desc = desc;
        this.days = days;
        this.due_date = due_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }
}
