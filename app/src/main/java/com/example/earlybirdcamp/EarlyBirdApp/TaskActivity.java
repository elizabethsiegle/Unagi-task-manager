package com.example.earlybirdcamp.EarlyBirdApp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;



public class TaskActivity extends AppCompatActivity{
    private String user;
    private static final String TAG = "TaskActivity";
//

    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        Intent intent = getIntent();
        user = intent.getStringExtra("user");
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
                final AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("Add a new task")
                        .setMessage("What do you want to do next?")
                        //.setView(taskEditText)
                        .setView(R.layout.special_dialog)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {


                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Spinner spin = (Spinner) findViewById(R.id.priority_spinner);
                                String[]  array_name = getResources().getStringArray(R.array.priority_array);

                                ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(TaskActivity.this, android.R.layout.simple_spinner_item, array_name);
                                adapter_state.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                spin.setAdapter(adapter_state);

                                Toast.makeText(TaskActivity.this, "this is my Toast message!!! =)",
                                        Toast.LENGTH_LONG).show();
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
