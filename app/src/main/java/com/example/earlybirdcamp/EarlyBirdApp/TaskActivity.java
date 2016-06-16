package com.example.earlybirdcamp.EarlyBirdApp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/*
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       Calendar c = Calendar.getInstance();
       c.setTime(new Date()); // Now use today date.
       c.add(Calendar.DATE, 5); // Adding 5 days
      String output = sdf.format(c.getTime());
get */





public class TaskActivity extends AppCompatActivity{
    ArrayList<Task> tasksLists;

    private String user;
    private static final String TAG = "TaskActivity";

//    public SimpleDateFormat getDueDate(int days){
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        Calendar c =  Calendar.getInstance();
//
//        return
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        Intent intent = getIntent();
        tasksLists = new ArrayList<Task>();
        user = intent.getStringExtra("user");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //--> If you have multiple icons, it allows you to switch among them
        switch (item.getItemId()) {
            case R.id.action_add_task: // --> if it's the + icon
                final AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("Add a new task")
                        .setMessage("What do you want to do next?")
                        //--> this is how The Dialog is gonna look (check the special_dialog.xml)
                        .setView(R.layout.special_dialog)
                         //--> set the functionality of a button/ what the button is gonna be user for
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                //-->it sets the dialog
                                Dialog dialog = (Dialog) dialogInterface;
                                Spinner spin = (Spinner) dialog.findViewById(R.id.priority_spinner);
                                //-->COMMENTED CODE #1 GOES HERE
                                int select = spin.getSelectedItemPosition();//-->level of priority
                                // --> create Task Object:
                                //taskName, taskDescription, days
                                EditText taskNameObject = (EditText) dialog.findViewById(R.id.taskName);
                                EditText taskDescriptionObject = (EditText) dialog.findViewById(R.id.taskDescription);
                                EditText daysObject = (EditText) dialog.findViewById(R.id.days);

                                String taskName = taskNameObject.getText().toString();
                                String taskDescription = taskDescriptionObject.getText().toString();
                                int days = Integer.parseInt(daysObject.getText().toString());
                                // 1- Figure out how to get due date (dd/mm/yyyy)

                                //2- Create a Task object

                                //3- Add task object to the ArrayList   tasksLists;



                                // public Task(String title, String desc, int days, Date due_date) {
                                //Task new_task = new Task();
                                //
                                Toast.makeText(TaskActivity.this, "this is my Toast message!!! =) " + select, Toast.LENGTH_LONG).show();

                                //String text = spin.getSelectedItem().toString();

                                //String task = String.valueOf(taskEditText.getText());
                                //Log.d(TAG, "Task to add: " + task);
                                //This is where we log the task stuff added
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
/*   COMMENTED CODE #1

                                spin.setOnItemSelectedListener(new OnItemSelectedListener() {

                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View selectedItemView,
                                                               int pos, long id) {
                                        Toast.makeText(parent.getContext(),
                                                "On Item Select : \n" + parent.getItemAtPosition(pos).toString(),
                                                Toast.LENGTH_LONG).show();
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> arg0) {
                                        //  Auto-generated method stub

                                    }

                                });
*/