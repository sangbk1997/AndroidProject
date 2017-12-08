package com.example.sangbk.autocomplex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String [] yourCountries={"Viet Nam","Nhat Ban","Hoa Ky","Trung Quoc","Thai Lan"};
    String [] yourLanguages={"VietNamese","Japanese","Indian","English","Laos"};
    AutoCompleteTextView Country;
    MultiAutoCompleteTextView Language;
    EditText name;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name1);
        Country=(AutoCompleteTextView)findViewById(R.id.auto);
        Language=(MultiAutoCompleteTextView)findViewById(R.id.mul);
        ArrayAdapter adapterCountry=new ArrayAdapter(this,android.R.layout.simple_list_item_1,yourCountries);
        ArrayAdapter adapterLanguage=new ArrayAdapter(this,android.R.layout.simple_list_item_1,yourLanguages);

        Country.setThreshold(1);
        Language.setThreshold(2);
        Language.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        Country.setAdapter(adapterCountry);
        Language.setAdapter(adapterLanguage);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
    }
    public void show(){
        String temp=this.name.getText().toString()+"  "+this.Country.getText().toString()+"  "+this.Language.getText().toString();
        Toast.makeText(this,temp,Toast.LENGTH_LONG).show();
    }
}
