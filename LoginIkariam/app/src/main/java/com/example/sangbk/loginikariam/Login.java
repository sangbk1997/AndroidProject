package com.example.sangbk.loginikariam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView infor;
    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        infor=(TextView)findViewById(R.id.infor);
        exit=(Button)findViewById(R.id.button);
        Intent i=getIntent();
         String user=i.getStringExtra("user");
        infor.setText("Hello "+ user);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
