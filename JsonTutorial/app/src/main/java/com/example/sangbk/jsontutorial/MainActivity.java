package com.example.sangbk.jsontutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText outputText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outputText=(EditText)findViewById(R.id.editTxt);

    }
    public void runExample(View view){
        try{
            // Dcc file : res/raw/company.json va tra ve doi tuong Company
            Company company=ReadJsonExample.readCompanyJSONFile(this);
            outputText.setText(company.toString());

        }catch (Exception e){
            outputText.setText(e.getMessage());
            e.printStackTrace();
        }
    }
}




