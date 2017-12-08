package com.example.sangbk.autocomplextextandmutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {
    EditText name;
    AutoCompleteTextView country;
    MultiAutoCompleteTextView language;
    Button button;
    String []countries={"Viet Nam","Nhat Ban","Han Quoc","Thai Lan"};
    String [] languages={"C++","Java","Python","Swift","PHP"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name);
        country=(AutoCompleteTextView)findViewById(R.id.country);
        language=(MultiAutoCompleteTextView)findViewById(R.id.multi_language);
        button=(Button)findViewById(R.id.button);
        ArrayAdapter adapter_Country=new ArrayAdapter(this,android.R.layout.simple_list_item_1,countries);
        country.setAdapter(adapter_Country);
        country.setThreshold(1);
        ArrayAdapter adapter_Language=new ArrayAdapter(this,android.R.layout.simple_list_item_1,languages);
        language.setAdapter(adapter_Language);
        language.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        language.setThreshold(1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfo();
            }

            private void showInfo() {
                String info=name.getText().toString() +"  "+ " Biet : "+language.getText().toString()+" o "+country.getText().toString();
                Toast.makeText(MainActivity.this,info, LENGTH_LONG).show();
            }


        });

    }
}
