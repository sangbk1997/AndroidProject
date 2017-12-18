package com.example.sangbk.internalstoragedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private Button saveButton;
    private Button readButton;
    private TextView textView;
    private EditText editText;
    // La ten file don gian
    // chú y : Khong cho phép đg dan dai
    private String simpleFileName="note.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveButton=(Button)findViewById(R.id.save);
        readButton=(Button)findViewById(R.id.read);
        textView=(TextView)findViewById(R.id.text);
        editText=(EditText)findViewById(R.id.edittext);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readData();
            }
        });

    }
    private void saveData(){
        String data=editText.getText().toString();
        try {
            FileOutputStream out=openFileOutput(simpleFileName,MODE_PRIVATE);
            out.write(data.getBytes());
            out.close();
            Toast.makeText(getApplicationContext(),"File save ",Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
        }
        // ghi du lieu
    }
    private void readData(){
        // mo luong doc file
        try {
            FileInputStream in=openFileInput(simpleFileName);
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            StringBuffer sb=new StringBuffer();
            String s=null;
            while((s=br.readLine())!=null){
                sb.append(s).append("\n");
            }
            this.textView.setText(sb.toString());
        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();

        }
        Toast.makeText(getApplicationContext(),"Read file",Toast.LENGTH_LONG).show();

    }
}

