package com.example.sangbk.supergame;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
    private ImageView img4;
    private ImageView img5;
    private ImageView img6;
    private ImageView img7;
    private ImageView img8;
    private ImageView img9;
    private ImageView img10;
    private ImageView img11;
    private ImageView img12;
    private ImageView imgchoose;
    private EditText str;
    private int diemso=0;
    private int progress=0;
    private RadioGroup types;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Handler handlerThread;
    private Random random=new Random();
    String icons[]={"chuot","trau","ho","meo","rong","ran","ngua","de","khi","ga","cho","lon"};
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
        img4=(ImageView)findViewById(R.id.icon4);
        img5=(ImageView)findViewById(R.id.icon5);
        img6=(ImageView)findViewById(R.id.icon6);
        img7=(ImageView)findViewById(R.id.icon7);
        img8=(ImageView)findViewById(R.id.icon8);
        img9=(ImageView)findViewById(R.id.icon9);
        img10=(ImageView)findViewById(R.id.icon10);
        img11=(ImageView)findViewById(R.id.icon11);
        img12=(ImageView)findViewById(R.id.icon12);
        imgchoose=(ImageView)findViewById(R.id.img_choose);
        str=(EditText)findViewById(R.id.text);
        types=(RadioGroup)findViewById(R.id.radiogroup);
        radioButton1=(RadioButton)findViewById(R.id.radio1);
        radioButton2=(RadioButton)findViewById(R.id.radio2);
        radioButton3=(RadioButton)findViewById(R.id.radio3);
        radioButton4=(RadioButton)findViewById(R.id.radio4);

        img1.setOnClickListener(new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(progress>1 && progress<99){
                    if(img1.getTag().toString().equals(str.getText().toString())){
                        diemso++;
                        diem.setText("Điểm số :"+diemso);
                    }else{
                        if(diemso >0) {
                            diemso--;
                            diem.setText("Điểm số :" + diemso);
                        }
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
                    else{
                        if(diemso >0) {
                            diemso--;
                            diem.setText("Điểm số :" + diemso);
                        }
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
                    else{
                        if(diemso >0) {
                            diemso--;
                            diem.setText("Điểm số :" + diemso);
                        }
                    }
                }
            }
        });
        img4.setOnClickListener(new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(progress>1 && progress<99){
                    if(img4.getTag().toString().equals(str.getText().toString())){
                        diemso++;
                        diem.setText("Điểm số :"+diemso);
                    }
                    else{
                        if(diemso >0) {
                            diemso--;
                            diem.setText("Điểm số :" + diemso);
                        }
                    }
                }

            }
        });
        img5.setOnClickListener(new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(progress>1 && progress<99){
                    if(img5.getTag().toString().equals(str.getText().toString())){
                        diemso++;
                        diem.setText("Điểm số :"+diemso);
                    }
                    else{
                        if(diemso >0) {
                            diemso--;
                            diem.setText("Điểm số :" + diemso);
                        }
                    }
                }
            }
        });
        img6.setOnClickListener(new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(progress>1 && progress<99){
                    if(img6.getTag().toString().equals(str.getText().toString())) {
                        diemso++;
                        diem.setText("Điểm số :"+diemso);
                    }
                    else{
                        if(diemso >0) {
                            diemso--;
                            diem.setText("Điểm số :" + diemso);
                        }
                    }
                }
            }
        });
        img7.setOnClickListener(new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(progress>1 && progress<99){
                    if(img7.getTag().toString().equals(str.getText().toString())){
                        diemso++;
                        diem.setText("Điểm số :"+diemso);
                    }
                    else{
                        if(diemso >0) {
                            diemso--;
                            diem.setText("Điểm số :" + diemso);
                        }
                    }
                }

            }
        });
        img8.setOnClickListener(new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(progress>1 && progress<99){
                    if(img8.getTag().toString().equals(str.getText().toString())){
                        diemso++;
                        diem.setText("Điểm số :"+diemso);
                    }
                    else{
                        if(diemso >0) {
                            diemso--;
                            diem.setText("Điểm số :" + diemso);
                        }
                    }
                }
            }
        });
        img9.setOnClickListener(new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(progress>1 && progress<99){
                    if(img9.getTag().toString().equals(str.getText().toString())) {
                        diemso++;
                        diem.setText("Điểm số :"+diemso);
                    }
                    else{
                        if(diemso >0) {
                            diemso--;
                            diem.setText("Điểm số :" + diemso);
                        }
                    }
                }
            }
        });
        img10.setOnClickListener(new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(progress>1 && progress<99){
                    if(img10.getTag().toString().equals(str.getText().toString())){
                        diemso++;
                        diem.setText("Điểm số :"+diemso);
                    }
                    else{
                        if(diemso >0) {
                            diemso--;
                            diem.setText("Điểm số :" + diemso);
                        }
                    }
                }

            }
        });
        img11.setOnClickListener(new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(progress>1 && progress<99){
                    if(img11.getTag().toString().equals(str.getText().toString())){
                        diemso++;
                        diem.setText("Điểm số :"+diemso);
                    }
                    else{
                        if(diemso >0) {
                            diemso--;
                            diem.setText("Điểm số :" + diemso);
                        }
                    }
                }
            }
        });
        img12.setOnClickListener(new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(progress>1 && progress<99){
                    if(img12.getTag().toString().equals(str.getText().toString())) {
                        diemso++;
                        diem.setText("Điểm số :"+diemso);
                    }
                }
                else{
                    if(diemso >0) {
                        diemso--;
                        diem.setText("Điểm số :" + diemso);
                    }
                }
            }
        });
        if(progress==100){
            Toast.makeText(this,"Times Up",Toast.LENGTH_LONG).show();
        }
    }


//    @Override
//    protected void onStop() {
//        super.onStop();
//        if(diemso>20){
//            Toast.makeText(this,"Bạn thật là giỏi với số điểm :"+diemso,Toast.LENGTH_LONG).show();
//        }else if(diemso>5 && diemso<20){
//            Toast.makeText(this,"Hãy cố gắng lần sau nhe ",Toast.LENGTH_LONG).show();
//        }else{
//            Toast.makeText(this,"Bạn chơi chưa tốt với số điểm :"+diemso,Toast.LENGTH_LONG).show();
//        }
//    }

    // Tim id theo ten
    public int getDrawableIdByName(String resName){
        String pkg=getPackageName();
        int resID=getResources().getIdentifier(resName,"drawable",pkg);
        return resID;
    }
    public void setImgChoose(){
        imgchoose.setImageResource(getDrawableIdByName(str.getText().toString()));
    }

    public void playGame(View view) throws InterruptedException {

        setProgressBarVisibility(true);
        setGame();
        setImgChoose();
        UpdateStatus update = new UpdateStatus();
        update.start();
//        Thread.sleep(2000);
    }
    public void setGame(){
        diemso=0;
        diem.setText("Số Điểm : 0");
    }
    public void finishGame(View view){
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    private void doSomeLongWork(final int r) throws InterruptedException {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                int temp,temp1,temp2,temp3,temp4,temp5,temp6,temp7,temp8,temp9,temp10,temp11;
                temp=random.nextInt(11);
                temp1=temp+1;
                temp2=temp+2;
                temp3=temp+3;
                temp4=temp+4;
                temp5=temp+5;
                temp6=temp+6;
                temp7=temp+7;
                temp8=temp+8;
                temp9=temp+9;
                temp10=temp+10;
                temp11=temp+11;
                progressBar.setProgress(r);
                img1.setImageResource(getDrawableIdByName(icons[temp%12]));
                img1.setTag(setTag(temp));
                img2.setImageResource(getDrawableIdByName(icons[(temp1)%12]));
                img2.setTag(setTag(temp1));
                img3.setImageResource(getDrawableIdByName(icons[(temp2)%12]));
                img3.setTag(setTag(temp2));
                img4.setImageResource(getDrawableIdByName(icons[(temp3)%12]));
                img4.setTag(setTag(temp3));
                img5.setImageResource(getDrawableIdByName(icons[(temp4)%12]));
                img5.setTag(setTag(temp4));
                img6.setImageResource(getDrawableIdByName(icons[(temp5)%12]));
                img6.setTag(setTag(temp5));
                img7.setImageResource(getDrawableIdByName(icons[(temp6)%12]));
                img7.setTag(setTag(temp6));
                img8.setImageResource(getDrawableIdByName(icons[(temp7)%12]));
                img8.setTag(setTag(temp7));
                img9.setImageResource(getDrawableIdByName(icons[(temp8)%12]));
                img9.setTag(setTag(temp8));
                img10.setImageResource(getDrawableIdByName(icons[(temp9)%12]));
                img10.setTag(setTag(temp9));
                img11.setImageResource(getDrawableIdByName(icons[(temp10)%12]));
                img11.setTag(setTag(temp10));
                img12.setImageResource(getDrawableIdByName(icons[(temp11)%12]));
                img12.setTag(setTag(temp11));
                currentTime.setText("Current Time : "+r);
            }



        });
        switch (types.getCheckedRadioButtonId()){
            case R.id.radio1:
                Thread.sleep(2000);
                break;
            case R.id.radio2:
                Thread.sleep(1000);
                break;
            case R.id.radio3:
                Thread.sleep(500);
                break;
            case R.id.radio4:
                Thread.sleep(200);
                break;
            default:
                Thread.sleep(1000);
                break;
        }

    }
    public String setTag(int r){
        switch (r%12){
            case 0:
                return "chuot";
            case 1:
                return "trau";
            case 3:
                return "ho";
            case 4:
                return "meo";
            case 5:
                return "rong";
            case 6:
                return "ran";
            case 7:
                return "ngua";
            case 8:
                return "de";
            case 9:
                return "khi";
            case 10:
                return "ga";
            case 11:
                return "cho";
            default:
                return "lon";
        }
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
                    img4.setClickable(true);
                    img5.setClickable(true);
                    img6.setClickable(true);
                    img7.setClickable(true);
                    img8.setClickable(true);
                    img9.setClickable(true);
                    img10.setClickable(true);
                    img11.setClickable(true);
                    img12.setClickable(true);
                }
                else{
                    img1.setClickable(false);
                    img2.setClickable(false);
                    img3.setClickable(false);
                    img4.setClickable(false);
                    img5.setClickable(false);
                    img6.setClickable(false);
                    img7.setClickable(false);
                    img8.setClickable(false);
                    img9.setClickable(false);
                    img10.setClickable(false);
                    img11.setClickable(false);
                    img12.setClickable(false);
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