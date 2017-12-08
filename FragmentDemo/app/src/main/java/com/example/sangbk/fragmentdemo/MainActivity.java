package com.example.sangbk.fragmentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showText(String topText,String bottomText){
        BottomFragment bottomFragment=(BottomFragment)this.getFragmentManager().findFragmentById(R.id.fragment2);
        bottomFragment.showText(topText,bottomText);
    }
}
