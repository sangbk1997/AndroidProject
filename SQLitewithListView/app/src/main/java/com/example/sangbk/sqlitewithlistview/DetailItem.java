package com.example.sangbk.sqlitewithlistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailItem extends AppCompatActivity {
    private TextView tensanpham;
    private TextView soluong;
    private TextView dongia;
    private Button save;
    private MySQLHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);
        tensanpham=(TextView)findViewById(R.id.tenTxt);
        soluong=(TextView)findViewById(R.id.soluongTxt);
        dongia=(TextView)findViewById(R.id.giaTxt);
        save=(Button)findViewById(R.id.save);
        helper=new MySQLHelper(this);
        Intent intent=getIntent();
        tensanpham.setText(intent.getStringExtra("tensanpham"));
        soluong.setText(intent.getStringExtra("soluong"));
        dongia.setText(intent.getStringExtra("dongia"));
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.insertItem(tensanpham.getText().toString(),Integer.parseInt(soluong.getText().toString()),Integer.parseInt(dongia.getText().toString()));
            }
        });
    }
}
