//package com.example.earlybirdcamp.EarlyBirdApp;
//
///**
// * Created by earlybirdcamp on 6/14/16.
// */
//
//import android.content.Context;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class TaskLab {
//    private static TaskLab sTaskLab;
//    private List<Task> mTasks;
//
//    public static TaskLab get(Context context){
//        if (sTaskLab == null){
//            sTaskLab = new TaskLab(context);
//        }
//        return sTaskLab;
//    }
//
//    private TaskLab(Context context){
//        mTasks = new ArrayList<>();
//        for (int i = 0; i < 100 ; i++){
//            Task task = new Task(Integer.toString(i));
//            mTasks.add(task);
//
//        }
//    }
//
//    public List<Task> getTask(){
//        return mTasks;
//    }
//
//    public Task getTask(String title){
//        for (Task task: mTasks){
//            if(task.getTitle().equals(title)){
//                return task;
//            }
//        }
//        return null;
//    }
//}
