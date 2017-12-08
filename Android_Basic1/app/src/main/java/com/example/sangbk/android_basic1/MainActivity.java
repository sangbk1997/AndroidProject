package com.example.sangbk.android_basic1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);

        button1.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // Tạo một Intent
                // Mang nội dung sẽ gửi tới Main2Activity
                Intent myIntent=new Intent(MainActivity.this,Main2Activity.class);
                myIntent.putExtra("text1","Nguyễn Bình Sang");
                myIntent.putExtra("text2","Nguyễn Đình Hà");
                // yêu cầu chạy Main2Activity
                MainActivity.this.startActivity(myIntent);
            }
        });
        button2.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // Tạo một Intent
                // Mang nội dung sẽ gửi tới Main2Activity
                Intent myIntent=new Intent(MainActivity.this,Main3Activity.class);

                // yêu cầu chạy Main2Activity
                MainActivity.this.startActivity(myIntent);
            }
        });
        button3.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // Tạo một Intent
                // Mang nội dung sẽ gửi tới Main2Activity
                Intent myIntent=new Intent(MainActivity.this,Main4Activity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        button4.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // Tạo một Intent
                // Mang nội dung sẽ gửi tới Main2Activity
                Intent myIntent=new Intent(MainActivity.this,Main5Activity.class);

                // yêu cầu chạy Main2Activity
                MainActivity.this.startActivity(myIntent);
            }
        });
        button5.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // Tạo một Intent
                // Mang nội dung sẽ gửi tới Main2Activity
                Intent myIntent=new Intent(MainActivity.this,Main6Activity.class);

                // yêu cầu chạy Main2Activity
                MainActivity.this.startActivity(myIntent);
            }
        });

    }
}
