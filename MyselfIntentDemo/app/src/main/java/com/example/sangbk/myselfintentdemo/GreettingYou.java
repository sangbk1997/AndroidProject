package com.example.sangbk.myselfintentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class GreettingYou extends AppCompatActivity {
     private EditText greeting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetting_you);
        greeting=(EditText)findViewById(R.id.text3);
        Intent intent=getIntent();
        String temp=intent.getStringExtra("Name")+" "+intent.getStringExtra("Age")+" "+intent.getStringExtra("Province");
        greeting.setText(temp);
        
    }
}
