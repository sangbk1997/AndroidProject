package com.example.sangbk.android_basic1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent=getIntent();
        // tham số trong intent truyền từ mainActivity
        String value1=intent.getStringExtra("text1");
        String value2=intent.getStringExtra("text2");
        final TextView textView1=(TextView)this.findViewById(R.id.text1);
        final TextView textView2=(TextView)this.findViewById(R.id.text2);
        textView1.setText(value1);
        textView2.setText(value2);
        Button button=(Button)this.findViewById(R.id.button6);
        button.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                textView1.setText("You click button");
            }
        });

        // xử lý sự kiện click bào button và giữ lâu
        button.setOnLongClickListener(new Button.OnLongClickListener(){

            @Override
            public boolean onLongClick(View v) {
                textView2.setText("You long click button");
                return true;
            }
        });
    }
}
