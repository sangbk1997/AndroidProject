package com.example.sangbk.implictintend;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Phuong thuc duoc goi khi click Send Email
    public void sendEmail(View view){
        // Danh sach nguoi nhan
        String [] recipients=new String[]{"20156367@student.hust.edu.vn"};
        String subject="Hi, How are you";
        String content="This is my test email";
        Intent intentEmail=new Intent(Intent.ACTION_SEND,Uri.parse("mailto:"));
        intentEmail.putExtra(Intent.EXTRA_EMAIL,recipients);
        intentEmail.putExtra(Intent.EXTRA_SUBJECT,subject);
        intentEmail.putExtra(Intent.EXTRA_TEXT,content);
        intentEmail.setType("text/plain");
        startActivity(Intent.createChooser(intentEmail,"Choose an email client from browser"));
    }
    // Phuong thuc duoc goi khi click vao search Google
    public void searchGoogle(View view){
        String url="http://google.com";
        // mot Intent khong tuong minh, yeu cau mo mot url
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
