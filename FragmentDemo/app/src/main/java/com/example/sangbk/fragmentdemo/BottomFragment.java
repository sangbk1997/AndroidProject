package com.example.sangbk.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Sangbk on 10/13/2017.
 */

public class BottomFragment extends Fragment {

    private TextView topText;
    private TextView bottomText;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.bottomfagment,container,false);
        topText=(TextView)view.findViewById(R.id.name);
        bottomText=(TextView)view.findViewById(R.id.age);

        return view;
    }
    public void showText(String toText,String boText){
        topText.setText(toText);
        bottomText.setText(boText);
    }
}
