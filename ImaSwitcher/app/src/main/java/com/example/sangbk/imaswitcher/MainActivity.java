package com.example.sangbk.imaswitcher;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {

    private ImageSwitcher imageSwitcher;
    private Button buttonPrevious;
    private Button buttonNext;

    private final String[] imageNames={"ball_red","ball_green","ball_yellow"};
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        buttonPrevious = (Button) findViewById(R.id.button_previous);
        buttonNext = (Button) findViewById(R.id.button_next);

        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);

        // Hoạt hình khi chuyển sang ảnh khác.
        Animation out= AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        Animation in= AnimationUtils.loadAnimation(this, android.R.anim.fade_in);

        // Sét đặt hiệu ứng hoạt hình khi chuyển ảnh.
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);

        //
        imageSwitcher.setFactory(new ViewFactory() {

            // Trả về View để hiển thị ảnh.
            // (Thông thường sử dung ImageView).
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());

                imageView.setBackgroundColor(Color.LTGRAY);
                imageView.setScaleType(ImageView.ScaleType.CENTER);

                ImageSwitcher.LayoutParams params= new ImageSwitcher.LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
                imageView.setLayoutParams(params);
                return imageView;
            }
        });

        this.currentIndex=0;
        this.showImage(this.currentIndex);

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


    private void previousImage()  {
        if(currentIndex > 0) {
            currentIndex--;
        }else  {
            Toast.makeText(getApplicationContext(), "No Previous Image", Toast.LENGTH_SHORT).show();
            return;
        }
        this.showImage(currentIndex);
    }

    private void nextImage()  {
        if(currentIndex < this.imageNames.length-1) {
            currentIndex++;
        }else  {
            Toast.makeText(getApplicationContext(), "No Next Image", Toast.LENGTH_SHORT).show();
            return;
        }
        this.showImage(currentIndex);
    }


    private void showImage(int imgIndex)  {
        String imageName= this.imageNames[imgIndex];

        int resId= getDrawableResIdByName(imageName);
        if(resId!=  0) {
            this.imageSwitcher.setImageResource(resId);
        }
    }

    // Tìm ID của Image ứng với tên của ảnh (Trong thư mục mipmap).
    public int getDrawableResIdByName(String resName)  {
        String pkgName = this.getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = this.getResources().getIdentifier(resName , "drawable", pkgName);
        Log.i("MyLog", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

}