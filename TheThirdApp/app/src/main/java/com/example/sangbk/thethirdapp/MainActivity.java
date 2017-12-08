package com.example.sangbk.thethirdapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Restaurants> model=new ArrayList<Restaurants>();
    ArrayAdapter<Restaurants> adapter=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save=(Button)findViewById(R.id.save);
        save.setOnClickListener(onsave);
        ListView list=(ListView)findViewById(R.id.restaurants);
        adapter=new ArrayAdapter<Restaurants>(this,android.R.layout.simple_list_item_checked,model);
        list.setAdapter(adapter);
    }
    private View.OnClickListener onsave=new View.OnClickListener() {
        public void onClick(View v) {
            Restaurants r=new Restaurants();
            EditText name = (EditText) findViewById(R.id.name);
            EditText address = (EditText) findViewById(R.id.add);
            r.setName(name.getText().toString());
            r.setAddress(address.getText().toString());
            RadioGroup types = (RadioGroup) findViewById(R.id.types);
            switch (types.getCheckedRadioButtonId()) {
                case R.id.take_out:
                    r.setType("Take_out");
                    break;
                case R.id.sit_down:
                    r.setType("Sit_Down");
                    break;
                case R.id.delivery:
                    r.setType("Delivery");
                    break;
            }
            RadioGroup sales = (RadioGroup) findViewById(R.id.sales);
            switch (sales.getCheckedRadioButtonId()) {
                case R.id.no:
                    r.setSale("No_Discount");
                    break;
                case R.id.giam20:
                    r.setSale("Discount 20%");
                    break;
                case R.id.giam50:
                    r.setSale("Discount 50%");
                    break;
            }
            adapter.add(r);
        }
    };

}
