package com.example.sangbk.imageswitcher;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private ImageSwitcher imageSwitcher;
    private Button buttonNext;
    private Button buttonPrevious;
    String imageNames[]={"ball_red","ball_green","ball_yellow"};
    private int currentIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imgswitcher);
        buttonNext = (Button) findViewById(R.id.button2);
        buttonPrevious = (Button) findViewById(R.id.button1);
        // Hoạt hình khi chuyển sang ảnh khác.
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);

        // Sét đặt hiệu ứng hoạt hình khi chuyển ảnh.
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);
        // Tra ve View de hien thi anh
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setBackgroundColor(Color.DKGRAY);
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                ImageSwitcher.LayoutParams params = new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                imageView.setLayoutParams(params);
                return imageView;
            }
        });

        currentIndex = 0;
        showImange(currentIndex);
        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousImage();
            }
        });
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextImage();
            }
        });
    }

    private void nextImage(){
        if(currentIndex<imageNames.length-1){
            currentIndex++;
        }else{
            Toast.makeText(getApplicationContext(),"No Next Image",Toast.LENGTH_LONG).show();
            return;
        }
        this.showImange(currentIndex);
    }
    private void previousImage(){
        if(currentIndex>0){
            currentIndex--;
        }else{
            Toast.makeText(getApplicationContext(),"No Previous Image",Toast.LENGTH_LONG).show();
            return;
        }
        this.showImange(currentIndex);
    }
    // ham xau anh
    private void showImange(int imgIndex){
        String imageName=this.imageNames[imgIndex];
        int resID=getDrawableResIdByName(imageName);
        if(resID!=0){
            this.imageSwitcher.setImageResource(resID);
        }
    }
    // Tim id cua image ung voi ten cua anh trong thu muc mipmap
    public int getDrawableResIdByName(String resName){
        String pkgName=this.getPackageName();
        // Tra ve 0 neu khong tim thay
        int resID=this.getResources().getIdentifier(resName,"drawable",pkgName);
        return resID;
    }
}
