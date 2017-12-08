package com.example.sangbk.thesecondapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Restaurant r=new Restaurant();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save=(Button)findViewById(R.id.save);
        save.setOnClickListener(onsave);
    }
    private View.OnClickListener onsave=new View.OnClickListener(){
        public void onClick(View v){
            EditText name=(EditText)findViewById(R.id.name);
            EditText address=(EditText)findViewById(R.id.add);
            r.setName(name.getText().toString());
            r.setAddress(address.getText().toString());
            RadioGroup types=(RadioGroup)findViewById(R.id.types);
            switch (types.getCheckedRadioButtonId()){
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
            RadioGroup sales=(RadioGroup)findViewById(R.id.sales);
            switch (sales.getCheckedRadioButtonId()){
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
            String temp="Thong tin nha hang : " +name.getText().toString()+"   "+address.getText().toString()+"   "+r.getType()+"   "
                    +r.getSale();
            Toast.makeText(MainActivity.this,temp,Toast.LENGTH_LONG).show();
        }

    };

}
