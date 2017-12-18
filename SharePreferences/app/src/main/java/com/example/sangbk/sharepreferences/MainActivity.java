package com.example.sangbk.sharepreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBarSound;
    private SeekBar seekBarBrightness;
    private RadioGroup radioGroupDiffLevel;
    private RadioButton radioButtonEasy;
    private RadioButton radioButtonMedium;
    private RadioButton radioButtonHard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBarSound=(SeekBar)findViewById(R.id.seekbar1);
        seekBarBrightness=(SeekBar)findViewById(R.id.seekbar2);
        radioGroupDiffLevel=(RadioGroup)findViewById(R.id.radiogroup);
        radioButtonEasy=(RadioButton)findViewById(R.id.easy);
        radioButtonMedium=(RadioButton)findViewById(R.id.mediun);
        radioButtonHard=(RadioButton)findViewById(R.id.hard);
        // hiển thị thông tin đã set up trong lần trước
        this.loadGameSetting();
    }

    private void loadGameSetting() {
        SharedPreferences sharePreferences=this.getSharedPreferences("gameSetting", Context.MODE_PRIVATE);
        if(sharePreferences !=null){
            int brightness=sharePreferences.getInt("brightness",90);
            int sound=sharePreferences.getInt("sound",95);
            int checkedRadioButtonId=sharePreferences.getInt("checkedRadioButtonId",R.id.mediun);
            seekBarSound.setProgress(sound);
            seekBarBrightness.setProgress(brightness);
            radioGroupDiffLevel.check(checkedRadioButtonId);

        }
        else{
            radioGroupDiffLevel.check(R.id.mediun);
            Toast.makeText(this,"Use the default game setting ",Toast.LENGTH_LONG).show();

        }
    }
    public void doSave(View v){
        // File chia sẻ sủ dụng trong nội bộ ứng dụng , hoặc các ứng dụng được chia sẻ cùng User
        SharedPreferences sharedPreferences=this.getSharedPreferences("gameSetting",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("brightness",this.seekBarBrightness.getProgress());
        editor.putInt("sound",this.seekBarSound.getProgress());
        int checkedRadioButtonId=radioGroupDiffLevel.getCheckedRadioButtonId();
        editor.putInt("checkedRadioButtonId",checkedRadioButtonId);
        // save
        editor.apply();
        Toast.makeText(this,"Game setting saved ",Toast.LENGTH_LONG).show();

    }
}
