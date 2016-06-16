package com.example.earlybirdcamp.EarlyBirdApp;

/**
 * Created by earlybirdcamp on 6/14/16.
 */
public class Task {

    String title;
    String desc;
    int days;

    public Task(){

    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDesc(){
        return desc;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public int getDays(){
        return days;
    }

    public void setDays(int days){
        this.days = days;
    }

}
