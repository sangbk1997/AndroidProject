package com.example.sangbk.moreactivebai12;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class DetailForm extends Activity {
    private EditText name=null;
    private EditText address=null;
    private EditText notes=null;
    private RadioGroup radioGroup=null;
    private Button save=null;
    String restaurantId=null;
    RestaurantHelper helper=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_form);
        restaurantId=getIntent().getStringExtra("ID_EXTRA");
        if(restaurantId !=null){
            load();
        }
        helper=new RestaurantHelper(this);
        name=(EditText)findViewById(R.id.name);
        address=(EditText)findViewById(R.id.addr);
        notes=(EditText)findViewById(R.id.notes);
        save=(Button)findViewById(R.id.save);
        radioGroup=(RadioGroup)findViewById(R.id.types);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type=null;
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.sit_down:
                        type ="Sit_down";
                        break;

                    case R.id.take_out:
                        type="Take_out";
                        break;

                    case R.id.delivery:
                        type="Delivery";
                        break;
                }
                if(restaurantId==null){
                     helper.insert(name.getText().toString(),address.getText().toString(),type,notes.getText().toString());

                }else{
                    helper.update(restaurantId,name.getText().toString(),address.getText().toString(),type,notes.getText().toString());
                }
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        helper.close();
    }
    private  void load(){
        Cursor c=helper.getById(restaurantId);
        c.moveToFirst();
        name.setText(helper.getName(c));
        address.setText(helper.getAddress(c));
        notes.setText(helper.getNotes(c));
        if(helper.getType(c).equals("Sit_down")){
            radioGroup.check(R.id.sit_down);
        }
        else if(helper.getType(c).equals("Take_out")){
            radioGroup.check(R.id.take_out);
        }else{
            radioGroup.check(R.id.delivery);
        }
        c.close();
    }

}
