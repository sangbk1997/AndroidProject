package com.example.sangbk.testdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Button button;
    Dialog dialog;
    EditText levelTownHall;
    EditText levelWall;
    RadioGroup Type;
    Button apply;
    Button cancel;
    String type="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=(ImageView)findViewById(R.id.img);
//        button=(Button)findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog=new Dialog(MainActivity.this);
//                dialog.setContentView(R.layout.layout_dialog);
//                dialog.show();
//            }
//        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog=new Dialog(MainActivity.this);  // khoi tao dialog
                // xet layout cho dialog
                dialog.setContentView(R.layout.layout_dialog);
                dialog.setTitle("Thiết lập TownHall");
                // hien thi dialog
                dialog.show();
                levelTownHall=(EditText)dialog.findViewById(R.id.level);
                levelWall=(EditText)dialog.findViewById(R.id.levelWall);
                Type=(RadioGroup)dialog.findViewById(R.id.radiogroup);
                apply=(Button)dialog.findViewById(R.id.apply);
                cancel=(Button)dialog.findViewById(R.id.cancel);
                apply.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (Type.getCheckedRadioButtonId()){
                            case R.id.so1:
                                type="myhouse";
                                break;
                            case  R.id.so2:
                                type="myenemy";
                                break;
                            case  R.id.so3:
                                type="myfriend";
                                break;
                        }
                        String temp=levelTownHall.getText().toString()+levelWall.getText().toString();
                        Toast.makeText(getApplicationContext(),"Ban vua an vao nut save  "+temp+"  "+type,Toast.LENGTH_LONG).show();
                        int temp_Level=Integer.parseInt(levelTownHall.getText().toString());
                        if(temp_Level==1){
                            img.setImageResource(R.drawable.town1);
                        }
                        if(temp_Level>=2 && temp_Level<=3){
                            img.setImageResource(R.drawable.town2);
                        }
                        if(temp_Level>=4 && temp_Level<=6){
                            img.setImageResource(R.drawable.town3);
                        }
                        if(temp_Level>=7 && temp_Level<=9){
                            img.setImageResource(R.drawable.town4);
                        }
                        if(temp_Level>=10 && temp_Level<=12){
                            img.setImageResource(R.drawable.town5);
                        }
                        switch (temp_Level){
                            case 1:
                                img.setImageResource(R.drawable.town1);
                                break;
                            case 2:
                            case 3:
                                img.setImageResource(R.drawable.town2);
                                break;
                            case 4:
                            case 5:
                            case 6:
                                img.setImageResource(R.drawable.town3);
                                break;
                            case 7:
                            case 8:
                            case 9:
                                img.setImageResource(R.drawable.town4);
                                break;
                            case 10:
                            case 11:
                            case 12:
                                img.setImageResource(R.drawable.town5);
                                break;
                            case 13:
                            case 14:
                            case 15:
                                img.setImageResource(R.drawable.town6);
                                break;
                            case 16:
                            case 17:
                                img.setImageResource(R.drawable.town7);
                                break;
                            default:
                                img.setImageResource(R.drawable.town8);
                                break;
                        }
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"Ban vua an vua cancel",Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });

            }
        });

    }

}
