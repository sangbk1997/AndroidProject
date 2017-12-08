package com.example.sangbk.playsongservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    // Method nay duoc goi khi nguoi dung kich vao play
    public void onPlay(View view){
        // Tao ra mot Intent cho mot dich vu
        Intent intent=new Intent(this,PlaySong.class);
        // goi phuong thuc startService
        startService(intent);

    }
    // Method nay duoc goi khi nguoi dung click Stop
    public void onStop(View view){
        // Tao mot doi tuong Intent
        Intent intent=new Intent(this,PlaySong.class);
        stopService(intent);
    }

}
