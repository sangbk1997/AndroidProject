package com.example.sangbk.qlsanpham;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailItem extends AppCompatActivity {
    private EditText name=null;
    private EditText count=null;
    private EditText cost=null;
    private Button save=null;
    private Button reset=null;
    private String ItemID=null;
    private MySQLHelper helper=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);
        name=(EditText)findViewById(R.id.tensp);
        count=(EditText)findViewById(R.id.soluongsp);
        cost=(EditText)findViewById(R.id.giasp);
        save=(Button)findViewById(R.id.save);
        reset=(Button)findViewById(R.id.reset);
        helper=new MySQLHelper(this);
//        String a=getIntent().getStringExtra(MainActivity.EXTRA_ID);
        ItemID=getIntent().getStringExtra("id");
        if(ItemID!=null){
            onLoad();
//            Toast.makeText(this,ItemID,Toast.LENGTH_LONG).show();
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ItemID!=null){
                    helper.update(ItemID,name.getText().toString(),count.getText().toString(),cost.getText().toString());
                }else{
                    helper.insert(name.getText().toString(),count.getText().toString(),cost.getText().toString());
                }
                finish();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.delete(ItemID);
                finish();
            }
        });
    }
    public void onSaveInstanceState(Bundle state){
        super.onSaveInstanceState(state);
        state.putString("name",name.getText().toString());
        state.putString("count",count.getText().toString());
        state.putString("cost",count.getText().toString());

    }
    public void onRestoreInstanceState(Bundle state){
        super.onRestoreInstanceState(state);
        name.setText(state.getString("name"));
        count.setText(state.getString("count"));
        cost.setText(state.getString("count"));
    }

    private void onLoad() {
        Cursor c=helper.getById(ItemID);
        c.moveToFirst();
        name.setText(helper.getName(c));
        count.setText(helper.getCount(c));
        cost.setText(helper.getCost(c));
        c.close();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        helper.close();
    }
}
