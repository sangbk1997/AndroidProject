package com.example.sangbk.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {
    private String firstName;
    private String lastName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        // Intent truyen sang
        Intent intent = getIntent();
        firstName = intent.getStringExtra("firstName");
        lastName = intent.getStringExtra("lastName");
        String greeting = "Hello " + firstName + "  " + lastName;
        TextView textGreeting = (TextView) findViewById(R.id.greeting);
        textGreeting.setText(greeting);
    }

        // KHi Activity nay hoan thanh
        // Co the can gui phan hoi gi do ve cho Activity da goi no
        public void finish(){

              // chuan bi du lieu Intent
            Intent data=new Intent();
            data.putExtra("Feedback ","I'm"+this.firstName +" Hi");
            // Activity da hoan thanh Ok , tra ve du lieu
            this.setResult(Activity.RESULT_OK,data);
            super.finish();
    }
    // Phuong thuc duoc goi khi nguoi dung nhan vao nut Back
    public void backClicked(View view){
        // goi phuong thuc onBackPressed()
        this.onBackPressed();
    }
}
