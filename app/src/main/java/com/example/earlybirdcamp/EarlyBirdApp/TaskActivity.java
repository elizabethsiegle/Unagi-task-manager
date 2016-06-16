package com.example.earlybirdcamp.EarlyBirdApp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import retrofit.http.HEAD;


public class TaskActivity extends AppCompatActivity{
/************************************ VARIABLES *********************************************/
    private RecyclerView taskRecyclerView;
    private TaskAdapter adapter;
    ArrayList<Task> tasksLists;

    private static final String TAG = "TaskActivity";
    int days;
    SimpleDateFormat format;
    //SimpleDateFormat deadlineDay;

 /************************************** TASK HOLDER *******************************************/
 /*
    Functionality: ViewHolder-Recyclerview
    Purpose: to hold the view for one single task. Note: for now it only has the taskName
  */
    private  class TaskHolder extends  RecyclerView.ViewHolder{
        public TextView taskNameView;
        public TextView daysLeftView;
        //public Button doneButton;

        public  TaskHolder(View itemView){ //--> Constructor for a TaskHolder, notice how it takes
            super(itemView);                // --> a View element, this constructor will be called
            taskNameView = (TextView)itemView.findViewById(R.id.task_name_view); //--> in the adapter. Remember that the adapter's job
            daysLeftView = (TextView)itemView.findViewById(R.id.days_left);
        }                               // --> is to inflate/draw a taskHolder element

        //@Override  --> we might need this override
        public void onClick(View v) {
                //-->> ADD CODE HERE: what happens when the user clicks on a task
        }
    }

    /************************************** ADAPTER *******************************************/
    private  class TaskAdapter extends  RecyclerView.Adapter<TaskHolder>{

        private ArrayList<Task> tasksList;  //-->list containing all the user's tasks


        public  TaskAdapter(ArrayList<Task> tasks){//-->constructor, notice that it takes
            tasksList = tasks;                  // --> an ArrayList argument
        }
 //------------------------------------ BindHolder --------------------------------------------
    /* PURPOSE: to create/instantiate a Task Holder (remember a taskholder only holds 1 task)   */
        @Override
        public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = getLayoutInflater(); //--> create/instantiate an inflater,
                                                                //--> so you can draw an element
            View view = layoutInflater.inflate(R.layout.item_task,parent,false);
            view.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            //view.setBackground(getDrawable(R.drawable.light_gradient));
            view.setClickable(true);

            return new TaskHolder(view); // --> Here's where you use the taskHolder constructor,
        }
      /* NOTE: At this point you have inflated/drawn the cell that holds the task, but you haven't populated
       the cell with information yet. That's what the onBingViewHolder is for. */

//--------------------------------- BindHolder --------------------------------------------
    /*PURPOSE: To populate the taskHolder with information  */
        @Override
        public void onBindViewHolder(TaskHolder holder, int position){
            Task task = tasksList.get(position);
            holder.taskNameView.setText(task.getTaskName());
            holder.daysLeftView.setText(String.valueOf(task.getDays()));
        }
 //-------------------------------- getItemsCount --------------------------------------------
     /*PURPOSE: to return the number of elemtnts in the list */
        @Override    // --> returns the item count
        public int getItemCount(){
            return tasksList.size();
        }

    }



    /***************************UPDATE USER INTERFACE *******************************************/

    /*PURPOSE: to rerender the data everytime there is a change and to initialize the adapter  */
    private void updateUI(){
        // fetch data from firebase here to update the list
        //ArrayList<Task> tasks = tasksLists;
        adapter = new TaskAdapter(tasksLists);
        taskRecyclerView.setAdapter(adapter);


    }
    /********************************* ONCREATE *******************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        // -----Code added
        tasksLists = new ArrayList<Task>();  //--> instantiate our arraylist for tasks
        taskRecyclerView  = (RecyclerView) findViewById(R.id.recycler_view); //--> instantiate the reccler view
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this)); // --> sets the linear LayourManager
        updateUI();  //--> initializes the adapter

    }
    @Override
    protected void onResume() {
        super.onResume();
        //fetch date from database

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
                                int select;
                                EditText debug;
                                EditText taskNameObject;
                                EditText taskDescriptionObject;
                                EditText daysObject;

                                //-->it sets the dialog
                                Dialog dialog = (Dialog) dialogInterface;

                                Spinner spin = (Spinner) dialog.findViewById(R.id.priority_spinner);
                                //-->COMMENTED CODE #1 GOES HERE
                                select = spin.getSelectedItemPosition();//-->level of priority
                                // --> create Task Object:
                                //taskName, taskDescription, days
                                taskNameObject = (EditText) dialog.findViewById(R.id.taskName);
                                taskDescriptionObject = (EditText) dialog.findViewById(R.id.taskDescription);
                                daysObject = (EditText) dialog.findViewById(R.id.days);

                                debug = (EditText) dialog.findViewById(R.id.days);

                                String taskName = taskNameObject.getText().toString();
                                String taskDescription = taskDescriptionObject.getText().toString();
                                days = Integer.parseInt(daysObject.getText().toString());



                                String debugS = debug.getText().toString();

                                if(daysObject.getText().toString().compareTo("") == 0) {
                                    days = 1;
                                }
                                else{
                                    days = Integer.parseInt(daysObject.getText().toString());
                                }

                                // 1- Figure out how to get due date (dd/mm/yyyy)
                                //call when new task is added get current date
                                Calendar curr = Calendar.getInstance();
                                Calendar cal = Calendar.getInstance(); //constant
                                cal.add(Calendar.DATE, days); //due date
                                format = new SimpleDateFormat("MM d, yyyy");
                                String deadlineDay = format.format(curr.getTime());
                                if(cal.getTime() == curr.getTime()) {
                                    //task expired
                                    Toast.makeText(TaskActivity.this, "task expired, shame tweet " + select, Toast.LENGTH_LONG).show();
                                }
                                else {
                                    Toast.makeText(TaskActivity.this, "success tweet " + deadlineDay, Toast.LENGTH_LONG).show();
                                }

                                //2- Create a Task object

                                Task newTask = new Task(taskName,taskDescription, days, deadlineDay);

                                //3- Add task object to the ArrayList   tasksLists;
                                tasksLists.add(newTask);
                                updateUI();

                                // public Task(String title, String desc, int days, Date due_date) {
                                //Task new_task = new Task(String title, String desc, int days, Date due_date);
                                //

                                String tweetUrl = "https://twitter.com/intent/tweet?text=Just Completed " + taskName + "!! %23Unagi";
                                Uri uri = Uri.parse(tweetUrl);
                                startActivity(new Intent(Intent.ACTION_VIEW, uri));

                                Toast.makeText(TaskActivity.this, "Task "+ taskName +": " + taskDescription + "due in " + days + "added", Toast.LENGTH_LONG).show();

                                //String text = spin.getSelectedItem().toString();

                                //String task = String.valueOf(taskEditText.getText());
                                //Log.d(TAG, "Task to add: " + task);
                                //This is where we log the task stuff added
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();
                dialog.getButton(dialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.negativeTextColor));
                dialog.getButton(dialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.darkTextColor));
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