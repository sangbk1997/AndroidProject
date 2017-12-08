package com.example.sangbk.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Country ex1=new Country("Việt Nam",0000);
        Country ex2=new Country("Trung Quốc",0001);
        Country ex3=new Country("Hoa Kỳ",0002);
        Country ex4=new Country("Nhật Bản",0003);
        Country ex5=new Country("Đức",0005);
        Country [] arrayCountry=new Country[]{ex1,ex2,ex3,ex4,ex5};
        ListView listView=(ListView)findViewById(R.id.list);
        ArrayAdapter<Country> arrayAdapter=new ArrayAdapter<Country>(this,android.R.layout.simple_list_item_1,arrayCountry);
        listView.setAdapter(arrayAdapter);
    }
}
