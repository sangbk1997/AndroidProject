package com.example.sangbk.gameikariam;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Screen extends AppCompatActivity {
    private ImageView flag1;
    private ImageView flag2;
    private ImageView flag3;
    private ImageView flag4;
    private ImageView flag5;
    private ImageView flag6;
    private Dialog dialog;
    private ArrayList<Infor_TownHall> list;
    private EditText levelTownHall;
    private EditText levelWall;
    private RadioGroup Type;
    private Button apply;
    private Button cancel;
    private Infor_TownHall infor_townH=new Infor_TownHall();
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        flag1 = (ImageView) findViewById(R.id.flag1);
        flag2 = (ImageView) findViewById(R.id.flag2);
        flag3 = (ImageView) findViewById(R.id.flag3);
        flag4 = (ImageView) findViewById(R.id.flag4);
        flag5 = (ImageView) findViewById(R.id.flag5);
        flag6 = (ImageView) findViewById(R.id.flag6);

        list=new ArrayList();

        flag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTownHall(flag1);

            }
        });
        flag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTownHall(flag2);

            }
        });
        flag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTownHall(flag3);


            }
        });
        flag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTownHall(flag4);


            }
        });
        flag5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTownHall(flag5);


            }
        });
        flag6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTownHall(flag6);

            }
        });

    }


    public void setTownHall(final ImageView img){
        dialog=new Dialog(this);  // khoi tao dialog
        // xet layout cho dialog
        dialog.setContentView(R.layout.dialog_setup);
        dialog.setTitle("Thiết lập TownHall");
        // hien thi dialog
        dialog.show();
        levelTownHall=(EditText)dialog.findViewById(R.id.level);
        levelWall=(EditText)dialog.findViewById(R.id.levelWall);
        Type=(RadioGroup)dialog.findViewById(R.id.radiogroup);
        if(!(img.getTag().toString().equals("100"))){
            if(Integer.parseInt(img.getTag().toString())==0){
                Toast.makeText(getApplicationContext(),"Xin chao minh la Snag ",Toast.LENGTH_LONG).show();
            }
            setInforTownHall(2);
            Toast.makeText(getApplicationContext(),"Tag : "+img.getTag().toString(),Toast.LENGTH_LONG).show();
    //        Toast.makeText(getApplicationContext(),"Level  :"+list.get(Integer.parseInt(img.getTag().toString())).getLevelTownHall(),Toast.LENGTH_LONG).show();
        }
        apply=(Button)dialog.findViewById(R.id.apply);
        cancel=(Button)dialog.findViewById(R.id.cancel);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infor_townH.setLevelTownHall(Integer.parseInt(levelTownHall.getText().toString()));
                infor_townH.setLevelWall(Integer.parseInt(levelWall.getText().toString()));
                switch (Type.getCheckedRadioButtonId()){
                    case R.id.so1:
                        infor_townH.setTypeHouse("Owner");
                        break;
                    case  R.id.so2:
                         infor_townH.setTypeHouse("Enemy");
                        break;
                    case  R.id.so3:
                         infor_townH.setTypeHouse("Alliance");
                        break;
                }
                Toast.makeText(getApplicationContext(),"Ban vua an vao nut save  ",Toast.LENGTH_LONG).show();
                if(img.getTag().toString().equals("100")){
                    img.setTag(String.valueOf(count));
                    list.add(infor_townH);
                    Toast.makeText(getApplicationContext(),"List size : "+list.size(),Toast.LENGTH_LONG).show();
                    count++;
                }else{
                    Toast.makeText(getApplicationContext(),"Level  :"+list.get(0).getLevelTownHall(),Toast.LENGTH_LONG).show();
                    list.set(Integer.parseInt(img.getTag().toString()),infor_townH);
                }

                int temp_Level=Integer.parseInt(levelTownHall.getText().toString());
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
    public void setInforTownHall(int index){
        levelTownHall.setText(String.valueOf(list.get(index).getLevelTownHall()));
        levelWall.setText(String.valueOf(list.get(index).getLevelWall()));
        if(list.get(index).getTypeHouse().equals("Owner")){
            Type.check(R.id.so1);
        }
        else if(list.get(index).getTypeHouse().equals("Enemy")){
            Type.check(R.id.so2);
        }else{
            Type.check(R.id.so3);
        }
    }

}

//        doConfigureFlag();
//
//    }
//    public void doConfigureFlag(){
//        Intent data = getIntent();
//        String flag = data.getStringExtra("id_back");
//        int levelToInt = Integer.parseInt(data.getStringExtra("level"));
//        switch (flag) {
//            case "flag1":
////                listTownHall[0]=temp;
//                if (levelToInt == 1) {
//                    flag1.setImageResource(getDrawableIdByName(this, "town1"));
//                }
//                if (levelToInt >= 2 && levelToInt <= 3) {
//                    flag1.setImageResource(getDrawableIdByName(this, "town2"));
//                }
//                if (levelToInt >= 4 && levelToInt <= 6) {
//                    flag1.setImageResource(getDrawableIdByName(this, "town3"));
//                }
//                if (levelToInt >= 7 && levelToInt <= 9) {
//                    flag1.setImageResource(getDrawableIdByName(this, "town4"));
//                }
//                if (levelToInt >= 10 && levelToInt <= 12) {
//                    flag1.setImageResource(getDrawableIdByName(this, "town5"));
//                }
//                if (levelToInt >= 13 && levelToInt <= 15) {
//                    flag1.setImageResource(getDrawableIdByName(this, "town6"));
//                }
//                if (levelToInt >= 16 && levelToInt <= 17) {
//                    flag1.setImageResource(getDrawableIdByName(this, "town7"));
//                } else {
//                    flag1.setImageResource(getDrawableIdByName(this, "town8"));
//                }
//                break;
//            case "flag2":
////                listTownHall[1]=temp;
//                if (levelToInt == 1) {
//                    flag2.setImageResource(getDrawableIdByName(this, "town1"));
//                }
//                if (levelToInt >= 2 && levelToInt <= 3) {
//                    flag2.setImageResource(getDrawableIdByName(this, "town2"));
//                }
//                if (levelToInt >= 4 && levelToInt <= 6) {
//                    flag2.setImageResource(getDrawableIdByName(this, "town3"));
//                }
//                if (levelToInt >= 7 && levelToInt <= 9) {
//                    flag2.setImageResource(getDrawableIdByName(this, "town4"));
//                }
//                if (levelToInt >= 10 && levelToInt <= 12) {
//                    flag2.setImageResource(getDrawableIdByName(this, "town5"));
//                }
//                if (levelToInt >= 13 && levelToInt <= 15) {
//                    flag2.setImageResource(getDrawableIdByName(this, "town6"));
//                }
//                if (levelToInt >= 16 && levelToInt <= 17) {
//                    flag2.setImageResource(getDrawableIdByName(this, "town7"));
//                } else {
//                    flag2.setImageResource(getDrawableIdByName(this, "town8"));
//                }
//                break;
//            case "flag3":
////                listTownHall[2]=temp;
//                if (levelToInt == 1) {
//                    flag3.setImageResource(getDrawableIdByName(this, "town1"));
//                }
//                if (levelToInt >= 2 && levelToInt <= 3) {
//                    flag3.setImageResource(getDrawableIdByName(this, "town2"));
//                }
//                if (levelToInt >= 4 && levelToInt <= 6) {
//                    flag3.setImageResource(getDrawableIdByName(this, "town3"));
//                }
//                if (levelToInt >= 7 && levelToInt <= 9) {
//                    flag3.setImageResource(getDrawableIdByName(this, "town4"));
//                }
//                if (levelToInt >= 10 && levelToInt <= 12) {
//                    flag3.setImageResource(getDrawableIdByName(this, "town5"));
//                }
//                if (levelToInt >= 13 && levelToInt <= 15) {
//                    flag3.setImageResource(getDrawableIdByName(this, "town6"));
//                }
//                if (levelToInt >= 16 && levelToInt <= 17) {
//                    flag3.setImageResource(getDrawableIdByName(this, "town7"));
//                } else {
//                    flag3.setImageResource(getDrawableIdByName(this, "town8"));
//                }
//                break;
//            case "flag4":
////                listTownHall[3]=temp;
//                if (levelToInt == 1) {
//                    flag4.setImageResource(getDrawableIdByName(this, "town1"));
//                }
//                if (levelToInt >= 2 && levelToInt <= 3) {
//                    flag4.setImageResource(getDrawableIdByName(this, "town2"));
//                }
//                if (levelToInt >= 4 && levelToInt <= 6) {
//                    flag4.setImageResource(getDrawableIdByName(this, "town3"));
//                }
//                if (levelToInt >= 7 && levelToInt <= 9) {
//                    flag4.setImageResource(getDrawableIdByName(this, "town4"));
//                }
//                if (levelToInt >= 10 && levelToInt <= 12) {
//                    flag4.setImageResource(getDrawableIdByName(this, "town5"));
//                }
//                if (levelToInt >= 13 && levelToInt <= 15) {
//                    flag4.setImageResource(getDrawableIdByName(this, "town6"));
//                }
//                if (levelToInt >= 16 && levelToInt <= 17) {
//                    flag4.setImageResource(getDrawableIdByName(this, "town7"));
//                } else {
//                    flag4.setImageResource(getDrawableIdByName(this, "town8"));
//                }
//                break;
//
//            case "flag5":
////                listTownHall[4]=temp;
//                if (levelToInt == 1) {
//                    flag1.setImageResource(getDrawableIdByName(this, "town1"));
//                }
//                if (levelToInt >= 2 && levelToInt <= 3) {
//                    flag5.setImageResource(getDrawableIdByName(this, "town2"));
//                }
//                if (levelToInt >= 4 && levelToInt <= 6) {
//                    flag5.setImageResource(getDrawableIdByName(this, "town3"));
//                }
//                if (levelToInt >= 7 && levelToInt <= 9) {
//                    flag5.setImageResource(getDrawableIdByName(this, "town4"));
//                }
//                if (levelToInt >= 10 && levelToInt <= 12) {
//                    flag5.setImageResource(getDrawableIdByName(this, "town5"));
//                }
//                if (levelToInt >= 13 && levelToInt <= 15) {
//                    flag5.setImageResource(getDrawableIdByName(this, "town6"));
//                }
//                if (levelToInt >= 16 && levelToInt <= 17) {
//                    flag5.setImageResource(getDrawableIdByName(this, "town7"));
//                } else {
//                    flag5.setImageResource(getDrawableIdByName(this, "town8"));
//                }
//                break;
//            case "flag6":
////                listTownHall[5]=temp;
//                if (levelToInt == 1) {
//                    flag6.setImageResource(getDrawableIdByName(this, "town1"));
//                }
//                if (levelToInt >= 2 && levelToInt <= 3) {
//                    flag6.setImageResource(getDrawableIdByName(this, "town2"));
//                }
//                if (levelToInt >= 4 && levelToInt <= 6) {
//                    flag6.setImageResource(getDrawableIdByName(this, "town3"));
//                }
//                if (levelToInt >= 7 && levelToInt <= 9) {
//                    flag6.setImageResource(getDrawableIdByName(this, "town4"));
//                }
//                if (levelToInt >= 10 && levelToInt <= 12) {
//                    flag6.setImageResource(getDrawableIdByName(this, "town5"));
//                }
//                if (levelToInt >= 13 && levelToInt <= 15) {
//                    flag6.setImageResource(getDrawableIdByName(this, "town6"));
//                }
//                if (levelToInt >= 16 && levelToInt <= 17) {
//                    flag6.setImageResource(getDrawableIdByName(this, "town7"));
//                } else {
//                    flag6.setImageResource(getDrawableIdByName(this, "town8"));
//                }
//                break;
//
//        }

//    public int getDrawableIdByName(Context context, String name) {
//        String pgkname = getPackageName();
//        int resID = getResources().getIdentifier(name, "drawable", pgkname);
//        return resID;
//
//    }
////    protected void onActivityResult(int requestCode, int resultCode, Intent data){
////        if (resultCode== Activity.RESULT_OK && requestCode==MY_REQUEST_CODE){
////            TownHall temp=new TownHall();
////            String level=data.getStringExtra("level");
////            temp.setLevel(level);
////            int levelToInt=Integer.parseInt(level);
////            String soHoplite=data.getStringExtra("soHoplite");
////            temp.setSoHoplite(Integer.parseInt(soHoplite));
////            String soSteamGiant=data.getStringExtra("soSteamGiant");
////            temp.setSoSteamGiant(Integer.parseInt(soSteamGiant));
////            String soSwordsman=data.getStringExtra("soSwordsman");
////            temp.setSoSwordsman(Integer.parseInt(soSwordsman));
////            String soSpearman=data.getStringExtra("soSpearman");
////            temp.setSoSpearman(Integer.parseInt(soSpearman));
////            String soSulphur_C=data.getStringExtra("soSulphur_C");
////            temp.setSoSulphur_C(Integer.parseInt(soSulphur_C));
////            String soArcher=data.getStringExtra("soArcher");
////            temp.setSoArcher(Integer.parseInt(soArcher));
////            String soSlinger=data.getStringExtra("soSlinger");
////            temp.setSoSlinger(Integer.parseInt(soSlinger));
////            String soMortar=data.getStringExtra("soMortar");
////            temp.setSoMortar(Integer.parseInt(soMortar));
////            String soCatapult=data.getStringExtra("soCatapult");
////            temp.setSoCatapult(Integer.parseInt(soCatapult));
////            String soRam=data.getStringExtra("soRam");
////            temp.setSoRam(Integer.parseInt(soRam));
////            String soBalloon_Bom=data.getStringExtra("soBalloon_Bombardier");
////            temp.setSoBalloon_Bombardier(Integer.parseInt(soBalloon_Bom));
////            String soGyrocopter=data.getStringExtra("soGyrocopter");
////            temp.setSoGyrocopter(Integer.parseInt(soGyrocopter));
////            String soCook=data.getStringExtra("soCook");
////            temp.setSoCook(Integer.parseInt(soCook));
////            String soDoctor=data.getStringExtra("soDoctor");
////            temp.setSoDoctor(Integer.parseInt(soDoctor));
////            String soBarbarian_Axe=data.getStringExtra("soBarbarian-Axe ");
////            temp.setSoBarbarian_Axe(Integer.parseInt(soBarbarian_Axe));
//            switch (data.getStringExtra("id_back")){
//                case "flag1":
//                    listTownHall[0]=temp;
//                    if(levelToInt==1){
//                        flag1.setImageResource(getDrawableIdByName(this,"town1"));
//                    }
//                    if(levelToInt>=2 && levelToInt<=3){
//                        flag1.setImageResource(getDrawableIdByName(this,"town2"));
//                    }
//                    if(levelToInt>=4 && levelToInt<=6){
//                        flag1.setImageResource(getDrawableIdByName(this,"town3"));
//                    }
//                    if(levelToInt>=7 && levelToInt<=9){
//                        flag1.setImageResource(getDrawableIdByName(this,"town4"));
//                    }
//                    if(levelToInt>=10 && levelToInt<=12){
//                        flag1.setImageResource(getDrawableIdByName(this,"town5"));
//                    }
//                    if(levelToInt>=13 && levelToInt<=15){
//                        flag1.setImageResource(getDrawableIdByName(this,"town6"));
//                    }
//                    if(levelToInt>=16 && levelToInt<=17){
//                        flag1.setImageResource(getDrawableIdByName(this,"town7"));
//                    }
//                    else{
//                        flag1.setImageResource(getDrawableIdByName(this,"town8"));
//                    }
//                    break;
//                case "flag2":
//                    listTownHall[1]=temp;
//                    if(levelToInt==1){
//                        flag2.setImageResource(getDrawableIdByName(this,"town1"));
//                    }
//                    if(levelToInt>=2 && levelToInt<=3){
//                        flag2.setImageResource(getDrawableIdByName(this,"town2"));
//                    }
//                    if(levelToInt>=4 && levelToInt<=6){
//                        flag2.setImageResource(getDrawableIdByName(this,"town3"));
//                    }
//                    if(levelToInt>=7 && levelToInt<=9){
//                        flag2.setImageResource(getDrawableIdByName(this,"town4"));
//                    }
//                    if(levelToInt>=10 && levelToInt<=12){
//                        flag2.setImageResource(getDrawableIdByName(this,"town5"));
//                    }
//                    if(levelToInt>=13 && levelToInt<=15){
//                        flag2.setImageResource(getDrawableIdByName(this,"town6"));
//                    }
//                    if(levelToInt>=16 && levelToInt<=17){
//                        flag2.setImageResource(getDrawableIdByName(this,"town7"));
//                    }
//                    else{
//                        flag2.setImageResource(getDrawableIdByName(this,"town8"));
//                    }
//                    break;
//                case "flag3":
//                    listTownHall[2]=temp;
//                    if(levelToInt==1){
//                        flag3.setImageResource(getDrawableIdByName(this,"town1"));
//                    }
//                    if(levelToInt>=2 && levelToInt<=3){
//                        flag3.setImageResource(getDrawableIdByName(this,"town2"));
//                    }
//                    if(levelToInt>=4 && levelToInt<=6){
//                        flag3.setImageResource(getDrawableIdByName(this,"town3"));
//                    }
//                    if(levelToInt>=7 && levelToInt<=9){
//                        flag3.setImageResource(getDrawableIdByName(this,"town4"));
//                    }
//                    if(levelToInt>=10 && levelToInt<=12){
//                        flag3.setImageResource(getDrawableIdByName(this,"town5"));
//                    }
//                    if(levelToInt>=13 && levelToInt<=15){
//                        flag3.setImageResource(getDrawableIdByName(this,"town6"));
//                    }
//                    if(levelToInt>=16 && levelToInt<=17){
//                        flag3.setImageResource(getDrawableIdByName(this,"town7"));
//                    }
//                    else{
//                        flag3.setImageResource(getDrawableIdByName(this,"town8"));
//                    }
//                    break;
//                case "flag4":
//                    listTownHall[3]=temp;
//                    if(levelToInt==1){
//                        flag4.setImageResource(getDrawableIdByName(this,"town1"));
//                    }
//                    if(levelToInt>=2 && levelToInt<=3){
//                        flag4.setImageResource(getDrawableIdByName(this,"town2"));
//                    }
//                    if(levelToInt>=4 && levelToInt<=6){
//                        flag4.setImageResource(getDrawableIdByName(this,"town3"));
//                    }
//                    if(levelToInt>=7 && levelToInt<=9){
//                        flag4.setImageResource(getDrawableIdByName(this,"town4"));
//                    }
//                    if(levelToInt>=10 && levelToInt<=12){
//                        flag4.setImageResource(getDrawableIdByName(this,"town5"));
//                    }
//                    if(levelToInt>=13 && levelToInt<=15){
//                        flag4.setImageResource(getDrawableIdByName(this,"town6"));
//                    }
//                    if(levelToInt>=16 && levelToInt<=17){
//                        flag4.setImageResource(getDrawableIdByName(this,"town7"));
//                    }
//                    else{
//                        flag4.setImageResource(getDrawableIdByName(this,"town8"));
//                    }
//                    break;
//
//                case "flag5":
//                    listTownHall[4]=temp;
//                    if(levelToInt==1){
//                        flag1.setImageResource(getDrawableIdByName(this,"town1"));
//                    }
//                    if(levelToInt>=2 && levelToInt<=3){
//                        flag5.setImageResource(getDrawableIdByName(this,"town2"));
//                    }
//                    if(levelToInt>=4 && levelToInt<=6){
//                        flag5.setImageResource(getDrawableIdByName(this,"town3"));
//                    }
//                    if(levelToInt>=7 && levelToInt<=9){
//                        flag5.setImageResource(getDrawableIdByName(this,"town4"));
//                    }
//                    if(levelToInt>=10 && levelToInt<=12){
//                        flag5.setImageResource(getDrawableIdByName(this,"town5"));
//                    }
//                    if(levelToInt>=13 && levelToInt<=15){
//                        flag5.setImageResource(getDrawableIdByName(this,"town6"));
//                    }
//                    if(levelToInt>=16 && levelToInt<=17){
//                        flag5.setImageResource(getDrawableIdByName(this,"town7"));
//                    }
//                    else{
//                        flag5.setImageResource(getDrawableIdByName(this,"town8"));
//                    }
//                    break;
//                case "flag6":
//                    listTownHall[5]=temp;
//                    if(levelToInt==1){
//                        flag6.setImageResource(getDrawableIdByName(this,"town1"));
//                    }
//                    if(levelToInt>=2 && levelToInt<=3){
//                        flag6.setImageResource(getDrawableIdByName(this,"town2"));
//                    }
//                    if(levelToInt>=4 && levelToInt<=6){
//                        flag6.setImageResource(getDrawableIdByName(this,"town3"));
//                    }
//                    if(levelToInt>=7 && levelToInt<=9){
//                        flag6.setImageResource(getDrawableIdByName(this,"town4"));
//                    }
//                    if(levelToInt>=10 && levelToInt<=12){
//                        flag6.setImageResource(getDrawableIdByName(this,"town5"));
//                    }
//                    if(levelToInt>=13 && levelToInt<=15){
//                        flag6.setImageResource(getDrawableIdByName(this,"town6"));
//                    }
//                    if(levelToInt>=16 && levelToInt<=17){
//                        flag6.setImageResource(getDrawableIdByName(this,"town7"));
//                    }
//                    else{
//                        flag6.setImageResource(getDrawableIdByName(this,"town8"));
//                    }
//                    break;
//
//            }
//        }
//
//    }
//    public int getDrawableIdByName(Context context,String name){
//        String pgkname=getPackageName();
//        int resID=getResources().getIdentifier(name,"drawable",pgkname);
//        return resID;
//
//    }
//}
