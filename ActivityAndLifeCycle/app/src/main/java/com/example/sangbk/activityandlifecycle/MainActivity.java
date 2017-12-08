package com.example.sangbk.activityandlifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String msg="Android: ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"The onCreate() event ",Toast.LENGTH_LONG).show();
    }

    // Called when the activity is about to become visible


    protected  void onStart(){
        super.onStart();
        Toast.makeText(this,"The onStart() event ",Toast.LENGTH_LONG).show();
    }
    // Call when the activity has become visibel
    protected void onResume(){
        super.onResume();
        Toast.makeText(this,"The onResume() event ",Toast.LENGTH_LONG).show();
    }
    // Called when another activity is taking focus
    protected void onPause(){
        super.onPause();
        Toast.makeText(this,"The onPause() event ",Toast.LENGTH_LONG).show();
    }

    // Called when the activity is no longer visible
    protected  void onStop(){
        super.onStop();
        Toast.makeText(this,"The onStop() event ",Toast.LENGTH_LONG).show();
    }

    // Call just before the activity is destroyed
    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"The onDestroy() event ",Toast.LENGTH_LONG).show();
    }

}

