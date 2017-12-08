package com.example.sangbk.myselfintentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText age;
    private EditText province;
    private Button next;
    private static final int REQUEST_CODE =100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name);
        age=(EditText)findViewById(R.id.age);
        province=(EditText)findViewById(R.id.yourProvince);
        next=(Button)findViewById(R.id.button);

        //
        next.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),GreettingYou.class);
                intent.putExtra("Name",name.getText().toString());
                intent.putExtra("Age",age.getText().toString());
                intent.putExtra("Province ",province.getText().toString());
                startActivityForResult(intent,REQUEST_CODE);

            }
        });
    }

}
