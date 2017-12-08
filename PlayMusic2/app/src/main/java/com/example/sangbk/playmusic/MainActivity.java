package com.example.sangbk.playmusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView currentTime;
    private TextView maxTime;
    private int choose=0;
    private Button buttonStart;
    private Button buttonPause;
    private Button buttonRewind;
    private Button buttonFastter;
    int progress=0;
    private MediaPlayer mediaPlayer;
    private Handler threadHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        currentTime=(TextView)findViewById(R.id.text1);
        maxTime=(TextView)findViewById(R.id.text2);
        buttonStart=(Button)findViewById(R.id.button2);
        buttonPause=(Button)findViewById(R.id.button3);
        buttonRewind=(Button)findViewById(R.id.button1);
        buttonFastter=(Button)findViewById(R.id.button4);
        buttonPause.setClickable(false);
//         Tao doi tuong Mediaplayer de quan ly
        int resID=getRawIdByName("song");
        mediaPlayer=MediaPlayer.create(this,resID);
        progressBar.setProgress(0);
        progressBar.setMax(mediaPlayer.getDuration());
        mediaPlayer.start();

    }
//    public boolean onCreateOptionMenu(Menu menu){
//       new MenuInflater(this).inflate(R.menu.option,menu);
//        return (super.onCreateOptionsMenu(menu));
//    }
//    public boolean onOptionItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case R.id.start:
//                choose=1;
//                break;
//            case R.id.pause:
//                choose=2;
//                break;
//            case R.id.fastter:
//                choose =3;
//                break;
//            case R.id.rewind:
//                choose=4;
//            case R.id.stop:
//                choose=0;
//                break;
//        }
//        return (super.onOptionsItemSelected(item));
//    }
    public int getRawIdByName(String name){
        String pkg=getPackageName();
        int resID=getResources().getIdentifier(name,"raw",pkg);
        return resID;
    }
    public void doStart(View view){
        progress=mediaPlayer.getCurrentPosition();
        int duration=mediaPlayer.getDuration();
        if(progress==0){
            progressBar.setMax(duration);
        }else if(progress==duration){
            mediaPlayer.reset();
        }
        mediaPlayer.start();
        buttonPause.setClickable(true);
        buttonStart.setClickable(false);
        UpdateProgressBar updateProgressBar=new UpdateProgressBar();
        updateProgressBar.run();
        threadHandler.postDelayed(updateProgressBar,50);
    }
    public void doPause(View view){
        mediaPlayer.pause();
        this.buttonPause.setClickable(false);
        buttonStart.setClickable(true);
//        UpdateProgressBar updateProgressBar=new UpdateProgressBar();
//        updateProgressBar.run();
    }
    public void doRewind(View view){
        int temp=5000;
        progress=mediaPlayer.getCurrentPosition();
        if(progress-temp>=0){
            mediaPlayer.seekTo(progress-temp);
        }
//        UpdateProgressBar updateProgressBar=new UpdateProgressBar();
//        updateProgressBar.run();
    }
    public void doFastter(View view){
        int temp=5000;
        int duration=mediaPlayer.getDuration();
        progress=mediaPlayer.getCurrentPosition();
        if(progress+temp<=0){
            mediaPlayer.seekTo(progress+temp);
        }
//        UpdateProgressBar updateProgressBar=new UpdateProgressBar();
//        updateProgressBar.run();
    }
//    public class UpdateProgressBar extends Thread{
//        public void run(){
//           progress=mediaPlayer.getCurrentPosition();
//            currentTime.setText("Progress :"+progress);
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    setProgressBarVisibility(true);
//                    progressBar.setProgress(progress);
//                }
//            });
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    // Thread sử dụng để Update trạng thái cho SeekBar.
    class UpdateProgressBar implements Runnable {

        public void run()  {
            int currentPosition = mediaPlayer.getCurrentPosition();
            currentTime.setText("Current Time :"+currentPosition);
            maxTime.setText("Max Time :"+mediaPlayer.getDuration());
            progressBar.setProgress(currentPosition);

           threadHandler.postDelayed(this,50);
        }
    }


}
