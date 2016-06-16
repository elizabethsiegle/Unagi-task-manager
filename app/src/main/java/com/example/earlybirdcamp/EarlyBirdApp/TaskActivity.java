package com.example.earlybirdcamp.EarlyBirdApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;


public class TaskActivity extends FragmentActivity{
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        Intent intent = getIntent();
        user = intent.getStringExtra("user");
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText("You made it! THIS IS THE INFO STORED IN THE SESSION" + user);
    }
}
