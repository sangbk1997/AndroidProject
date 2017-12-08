package com.example.sangbk.android_basic1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class Main3Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Read XML file to add MenuItem to menu
        // doc file xml để thêm các MenuItem vào menu
        this.getMenuInflater().inflate(R.menu.menu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout rootView=(RelativeLayout)this.findViewById(R.id.line);
        int itemId=item.getItemId();
        switch(itemId){
            case R.id.menu_red:
                if(item.isChecked()){
                    item.setChecked(false);
                }else{
                    item.setChecked(true);
                }
                rootView.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu_blue:
                if(item.isChecked()){
                    item.setChecked(false);
                }else{
                    item.setChecked(true);
                }
                rootView.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.menu_black:
                if(item.isChecked()){
                    item.setChecked(false);
                }else{
                    item.setChecked(true);
                }
                rootView.setBackgroundColor(Color.BLACK);
                return true;
            default:
                rootView.setBackgroundColor(Color.DKGRAY);
                return super.onOptionsItemSelected(item);

        }

    }

}
