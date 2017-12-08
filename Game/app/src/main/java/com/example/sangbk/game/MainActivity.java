package com.example.sangbk.game;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {
    private ProgressBar progressBar;
    private TextView maxTime;
    private TextView currentTime;
    private TextView diem;
    private Button play;
    private Button finish;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private EditText str;
    private int diemso=0;
    private int progress=0;
    private Handler handlerThread;
    private Random random=new Random();
    String icons[]={"ball_green","ball_yellow","ball_red"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_main);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        maxTime=(TextView)findViewById(R.id.time);
        currentTime=(TextView)findViewById(R.id.time2);
        diem=(TextView)findViewById(R.id.time3);
        play=(Button)findViewById(R.id.play);
        img1=(ImageView)findViewById(R.id.icon1);
        img2=(ImageView)findViewById(R.id.icon2);
        img3=(ImageView)findViewById(R.id.icon3);
        str=(EditText)findViewById(R.id.text);

        img1.setOnClickListener(new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(progress>1 && progress<99){
                    if(img1.getTag().toString().equals(str.getText().toString())){
                        diemso++;
                        diem.setText("Điểm số :"+diemso);
                    }
                }

            }
        });
        img2.setOnClickListener(new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(progress>1 && progress<99){
                    if(img2.getTag().toString().equals(str.getText().toString())){
                        diemso++;
                        diem.setText("Điểm số :"+diemso);
                    }
                }
            }
        });
        img3.setOnClickListener(new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(progress>1 && progress<99){
                    if(img3.getTag().toString().equals(str.getText().toString())) {
                        diemso++;
                        diem.setText("Điểm số :"+diemso);
                    }
                }
            }
        });
    }

    // Tim id theo ten
    public int getDrawableIdByName(String resName){
        String pkg=getPackageName();
        int resID=getResources().getIdentifier(resName,"drawable",pkg);
        return resID;
    }
    public int getDrawable(String str){
        if(str=="1"){
            return R.drawable.ball_green;
        } else if (str == "2") {

            return R.drawable.ball_red;
        }
        return R.drawable.ball_yellow;
    }
    public void finishGame(View view){
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
    }

    public void playGame(View view) throws InterruptedException {

            setProgressBarVisibility(true);
            diemso=0;
            UpdateStatus update = new UpdateStatus();
            update.start();
            Thread.sleep(2000);
    }


    private void doSomeLongWork(final int r) throws InterruptedException {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                int temp,temp1,temp2;
                temp=random.nextInt(3);
                temp1=temp+1;
                temp2=temp+2;
                progressBar.setProgress(r);
                img1.setImageResource(getDrawableIdByName(icons[temp%3]));
                img1.setTag(setTag(temp));
                img2.setImageResource(getDrawableIdByName(icons[(temp1)%3]));
                img2.setTag(setTag(temp1));
                img3.setImageResource(getDrawableIdByName(icons[(temp2)%3]));
                img3.setTag(setTag(temp2));
                currentTime.setText("Current Time : "+r);
            }



        });
        Thread.sleep(500);
    }
    public String setTag(int r){
        if(r%3==0){
            return "green";
        }
        else if(r%3==1){
            return "yellow";
        }
        return "red";
    }
    public class UpdateStatus extends Thread {
        public void run() {
            for (int i = 0; i <= 100; i++) {
                progress=i;
                if(progress>1 && progress <99){
                    play.setClickable(false);
                    img1.setClickable(true);
                    img2.setClickable(true);
                    img3.setClickable(true);
                }
                else{
                    img1.setClickable(false);
                    img2.setClickable(false);
                    img3.setClickable(false);
                    play.setClickable(true);
                }
                try {
                    doSomeLongWork(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }

}