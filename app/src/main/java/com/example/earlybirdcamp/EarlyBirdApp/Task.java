package com.example.earlybirdcamp.EarlyBirdApp;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Created by earlybirdcamp on 6/14/16.
 */
public class Task {

    private String taskName;
    private String desc;
    private int days;

   // private Date due_date;
   // private SimpleDateFormat due_date;

    public Task(String taskName, String desc, int days) {
        this.taskName = taskName;
        this.desc = desc;
        this.days = days;
       // this.due_date = ;
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

//    public SimpleDateFormat getDue_date() {
////        return due_date;
////    }
//
//    public void setDue_date(SimpleDateFormat due_date) {
//        this.due_date = due_date;
//    }
}
