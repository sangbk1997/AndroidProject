package com.example.sangbk.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SeekBar  seekBar;
    Button nextButton;
    Button preButton;
    TextView progressView;
    int progressNow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar=(SeekBar)findViewById(R.id.seekbar);
        seekBar.setMax(100);
        seekBar.setProgress(0);
        nextButton=(Button)findViewById(R.id.next);
        preButton=(Button)findViewById(R.id.pre);
        progressView=(TextView)findViewById(R.id.text);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressNow=progress;
                progressView.setText("Progress :"+progress+"/ "+seekBar.getMax());
                Toast.makeText(getApplicationContext(),"Changing progress",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"User drawing the progress",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                progressView.setText("Progress :"+progressNow+"/ "+seekBar.getMax());
                Toast.makeText(getApplicationContext(),"Stop tracking seekbar",Toast.LENGTH_LONG).show();
            }
        });

        nextButton.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(progressNow<=100 && (progressNow+5)<=100){
                    progressNow+=5;
                }
                progressView.setText("Progress :"+progressNow+" / "+seekBar.getMax());
            }
        });

        preButton.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(progressNow>0 && (progressNow-5)>=0){
                    progressNow-=5;

                }
                progressView.setText("Progress :"+ progressNow + " / "+seekBar.getMax());
            }
        });
    }

}
