package com.example.earlybirdcamp.EarlyBirdApp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class TaskActivity extends AppCompatActivity{
    private String user;
    private static final String TAG = "TaskActivity";
//
    //Spinner spinner = (Spinner) findViewById(R.id.priority_spinner);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        Intent intent = getIntent();
        user = intent.getStringExtra("user");
        //TextView textView = (TextView) findViewById(R.id.text);
        //textView.setText("You made it! THIS IS THE INFO STORED IN THE SESSION" + user);

        //Spinn
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_task:
                //final EditText taskEditText = new EditText(this);
                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("Add a new task")
                        .setMessage("What do you want to do next?")
                        //.setView(taskEditText)
                        .setView(R.layout.special_dialog)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
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
