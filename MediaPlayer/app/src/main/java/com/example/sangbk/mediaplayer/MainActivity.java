package com.example.sangbk.mediaplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    private ProgressBar progressBar;
    private TextView currentTime;
    private TextView maxTime;
    private int progress = 0;
    private MediaPlayer mediaPlayer;
    Handler handlerThread=new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        maxTime = (TextView) findViewById(R.id.text1);
        currentTime = (TextView) findViewById(R.id.text2);
        int songID = getRawResIdBName("song");
        mediaPlayer = MediaPlayer.create(this, songID);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.start:
                doStart();
                break;
            case R.id.pause:
                doPause();
                break;
            case R.id.fastter:
                doFastter();
                break;
            case R.id.rewind:
                doRewind();
                break;
            case R.id.stop:
                mediaPlayer.stop();
        }
        return (super.onOptionsItemSelected(item));
    }

    private int getRawResIdBName(String resName) {
        String pkgName = this.getPackageName();
        int resID = getResources().getIdentifier(resName, "raw", pkgName);
        return resID;
    }

    public void doStart(){
        progress=mediaPlayer.getCurrentPosition();
        int duration=mediaPlayer.getDuration();
        if(progress==0){
            progressBar.setMax(duration);
        }else if(progress==duration){
            mediaPlayer.reset();
        }
        mediaPlayer.start();
        UpdateProgressBar updateProgressBar=new UpdateProgressBar();
        updateProgressBar.run();
        handlerThread.postDelayed(updateProgressBar,50);
    }
    public void doPause(){
        mediaPlayer.pause();
//        UpdateProgressBar updateProgressBar=new UpdateProgressBar();
//        updateProgressBar.run();
    }
    public void doRewind(){
        int temp=5000;
        progress=mediaPlayer.getCurrentPosition();
        if(progress-temp>=0){
            mediaPlayer.seekTo(progress-temp);
        }
//        UpdateProgressBar updateProgressBar=new UpdateProgressBar();
//        updateProgressBar.run();
    }
    public void doFastter() {
        int temp = 5000;
        int duration = mediaPlayer.getDuration();
        progress = mediaPlayer.getCurrentPosition();
        if (progress + temp <= 0) {
            mediaPlayer.seekTo(progress + temp);
        }
    }
// Thread sử dụng để Update trạng thái cho SeekBar.
    public class UpdateProgressBar implements Runnable {

    public void run()  {
        int currentPosition = mediaPlayer.getCurrentPosition();
        currentTime.setText("Current Time :"+currentPosition);
        maxTime.setText("Max Time :"+mediaPlayer.getDuration());
        progressBar.setProgress(currentPosition);

        handlerThread.postDelayed(this,50);
    }
  }


}
