package com.example.earlybirdcamp.EarlyBirdApp;

import java.text.SimpleDateFormat;

/**
 * Created by earlybirdcamp on 6/14/16.
 */
public class Task {

    private String taskName;
    private String desc;
    private int days;
    SimpleDateFormat dueDate;

    public Task(String taskName, String desc, int days, SimpleDateFormat dueDate) {
        this.taskName = taskName;
        this.desc = desc;
        this.days = days;
        this.dueDate = dueDate;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
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

    public SimpleDateFormat getDue_date() {
        return dueDate;
    }

    public void setDue_date(SimpleDateFormat dueDate) {
        this.dueDate = dueDate;
    }
}
