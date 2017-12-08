package com.example.sangbk.firstapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    Restaurants r=new Restaurants();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save=(Button)findViewById(R.id.save);
        save.setOnClickListener(onsave);
    }
    public View.OnClickListener onsave=new View.OnClickListener(){
        public void onClick(View v){
            EditText name=(EditText)findViewById(R.id.name);
            EditText address=(EditText)findViewById(R.id.add);
            r.setName(name.getText().toString());
            r.setAddress(address.getText().toString());
            String temp="Da da nhap vao nha hang : "+name.getText().toString()+" va dia chi : "+address.getText().toString();
            Toast.makeText(MainActivity.this,temp,Toast.LENGTH_LONG).show();
        }
    };
}
