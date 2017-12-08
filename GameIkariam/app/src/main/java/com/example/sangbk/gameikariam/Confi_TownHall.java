package com.example.sangbk.gameikariam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class Confi_TownHall extends AppCompatActivity {
    private EditText level;
    private EditText count_Hoplite;
    private EditText count_SG;
    private EditText count_Swordsman;
    private EditText count_Spearman;
    private EditText count_SulphurC;
    private EditText count_Archer;
    private EditText count_Slinger;
    private EditText count_Mortar;
    private EditText count_Catapult;
    private EditText count_Ram;
    private EditText count_Balloon_Bom;
    private EditText count_Gyrocopter;
    private EditText count_Cook;
    private EditText count_Doctor;
    private EditText count_Barbarian_Axe;
    private Button save;
    private  Button cancel;
    Screen screen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confi__town_hall);
        level=(EditText)findViewById(R.id.level);
        count_Hoplite=(EditText)findViewById(R.id.count_Hop);
         count_SG=(EditText)findViewById(R.id.count_StreamGiant);
         count_Swordsman=(EditText)findViewById(R.id.count_Swordsman);
         count_Spearman=(EditText)findViewById(R.id.count_Spearman);
         count_SulphurC=(EditText)findViewById(R.id.count_Sul);
         count_Archer=(EditText)findViewById(R.id.count_Archer);
         count_Slinger=(EditText)findViewById(R.id.count_Slinger);
         count_Mortar=(EditText)findViewById(R.id.count_Mortar);
         count_Catapult=(EditText)findViewById(R.id.count_Catapult);
         count_Ram=(EditText)findViewById(R.id.count_Ram);
         count_Balloon_Bom=(EditText)findViewById(R.id.count_Balloon);
         count_Gyrocopter=(EditText)findViewById(R.id.count_Gyrocopter);
         count_Cook=(EditText)findViewById(R.id.count_Cook);
         count_Doctor=(EditText)findViewById(R.id.count_Doctor);
         count_Barbarian_Axe=(EditText)findViewById(R.id.count_Barbarian_Axe);
          save=(Button)findViewById(R.id.save);
           cancel=(Button)findViewById(R.id.cancel);
//        String id=getIntent().getStringExtra("id");
//        if(id!=""){
//            switch (id){
//                case "flag1":
//                    level.setText(screen.listTownHall[0].getLevel());
//                    count_Hoplite.setText(String.valueOf(screen.
//                            listTownHall[0].getSoHoplite()));
//                    count_SG
//                            .setText(String.valueOf(screen.listTownHall[0].getSoSteamGiant()));
//                    count_Swordsman.setText(String.valueOf(screen.listTownHall[0].getSoSwordsman()));
//                    count_Spearman.setText(String.valueOf(screen.listTownHall[0].getSoSpearman()));
//                    count_SulphurC.setText(String.valueOf(screen.listTownHall[0].getSoSulphur_C()));
//                    count_Archer.setText(String.valueOf(screen.listTownHall[0].getSoArcher()));
//                    count_Slinger.setText(String.valueOf(screen.listTownHall[0].getSoSlinger()));
//                    count_Mortar.setText(String.valueOf(screen.listTownHall[0].getSoMortar()));
//                    count_Catapult.setText(String.valueOf(screen.listTownHall[0].getSoCatapult()));
//                    count_Ram.setText(String.valueOf(screen.listTownHall[0].getSoRam()));
//                    count_Balloon_Bom.setText(String.valueOf(screen.listTownHall[0].getSoBalloon_Bombardier()));
//                    count_Gyrocopter.setText(String.valueOf(screen.listTownHall[0].getSoGyrocopter()));
//                    count_Cook.setText(String.valueOf(screen.listTownHall[0].getSoCook()));
//                    count_Doctor.setText(String.valueOf(screen.listTownHall[0].getSoDoctor()));
//                    count_Barbarian_Axe.setText(String.valueOf(screen.listTownHall[0].getSoBarbarian_Axe()));
//                    break;
//                case "flag2":
//                    level.setText(screen.listTownHall[1].getLevel());
//                    count_Hoplite.setText(String.valueOf(screen.listTownHall[1].getSoHoplite()));
//                    count_SG.setText(String.valueOf(screen.listTownHall[1].getSoSteamGiant()));
//                    count_Swordsman.setText(String.valueOf(screen.listTownHall[1].getSoSwordsman()));
//                    count_Spearman.setText(String.valueOf(screen.listTownHall[1].getSoSpearman()));
//                    count_SulphurC.setText(String.valueOf(screen.listTownHall[1].getSoSulphur_C()));
//                    count_Archer.setText(String.valueOf(screen.listTownHall[1].getSoArcher()));
//                    count_Slinger.setText(String.valueOf(screen.listTownHall[1].getSoSlinger()));
//                    count_Mortar.setText(String.valueOf(screen.listTownHall[1].getSoMortar()));
//                    count_Catapult.setText(String.valueOf(screen.listTownHall[1].getSoCatapult()));
//                    count_Ram.setText(String.valueOf(screen.listTownHall[1].getSoRam()));
//                    count_Balloon_Bom.setText(String.valueOf(screen.listTownHall[1].getSoBalloon_Bombardier()));
//                    count_Gyrocopter.setText(String.valueOf(screen.listTownHall[1].getSoGyrocopter()));
//                    count_Cook.setText(String.valueOf(screen.listTownHall[1].getSoCook()));
//                    count_Doctor.setText(String.valueOf(screen.listTownHall[1].getSoDoctor()));
//                    count_Barbarian_Axe.setText(String.valueOf(screen.listTownHall[1].getSoBarbarian_Axe()));
//                    break;
//                case "flag3":
//                    level.setText(screen.listTownHall[2].getLevel());
//                    count_Hoplite.setText(String.valueOf(screen.listTownHall[2].getSoHoplite()));
//                    count_SG.setText(String.valueOf(screen.listTownHall[2].getSoSteamGiant()));
//                    count_Swordsman.setText(String.valueOf(screen.listTownHall[2].getSoSwordsman()));
//                    count_Spearman.setText(String.valueOf(screen.listTownHall[2].getSoSpearman()));
//                    count_SulphurC.setText(String.valueOf(screen.listTownHall[2].getSoSulphur_C()));
//                    count_Archer.setText(String.valueOf(screen.listTownHall[2].getSoArcher()));
//                    count_Slinger.setText(String.valueOf(screen.listTownHall[2].getSoSlinger()));
//                    count_Mortar.setText(String.valueOf(screen.listTownHall[2].getSoMortar()));
//                    count_Catapult.setText(String.valueOf(screen.listTownHall[2].getSoCatapult()));
//                    count_Ram.setText(String.valueOf(screen.listTownHall[2].getSoRam()));
//                    count_Balloon_Bom.setText(String.valueOf(screen.listTownHall[2].getSoBalloon_Bombardier()));
//                    count_Gyrocopter.setText(String.valueOf(screen.listTownHall[2].getSoGyrocopter()));
//                    count_Cook.setText(String.valueOf(screen.listTownHall[2].getSoCook()));
//                    count_Doctor.setText(String.valueOf(screen.listTownHall[2].getSoDoctor()));
//                    count_Barbarian_Axe.setText(String.valueOf(screen.listTownHall[2].getSoBarbarian_Axe()));
//                    break;
//                case "flag4":
//                    level.setText(screen.listTownHall[3].getLevel());
//                    count_Hoplite.setText(String.valueOf(screen.listTownHall[3].getSoHoplite()));
//                    count_SG.setText(String.valueOf(screen.listTownHall[3].getSoSteamGiant()));
//                    count_Swordsman.setText(String.valueOf(screen.listTownHall[3].getSoSwordsman()));
//                    count_Spearman.setText(String.valueOf(screen.listTownHall[3].getSoSpearman()));
//                    count_SulphurC.setText(String.valueOf(screen.listTownHall[3].getSoSulphur_C()));
//                    count_Archer.setText(String.valueOf(screen.listTownHall[3].getSoArcher()));
//                    count_Slinger.setText(String.valueOf(screen.listTownHall[3].getSoSlinger()));
//                    count_Mortar.setText(String.valueOf(screen.listTownHall[3].getSoMortar()));
//                    count_Catapult.setText(String.valueOf(screen.listTownHall[3].getSoCatapult()));
//                    count_Ram.setText(String.valueOf(screen.listTownHall[3].getSoRam()));
//                    count_Balloon_Bom.setText(String.valueOf(screen.listTownHall[3].getSoBalloon_Bombardier()));
//                    count_Gyrocopter.setText(String.valueOf(screen.listTownHall[3].getSoGyrocopter()));
//                    count_Cook.setText(String.valueOf(screen.listTownHall[3].getSoCook()));
//                    count_Doctor.setText(String.valueOf(screen.listTownHall[3].getSoDoctor()));
//                    count_Barbarian_Axe.setText(String.valueOf(screen.listTownHall[3].getSoBarbarian_Axe()));
//                    break;
//                case "flag5":
//                    level.setText(screen.listTownHall[4].getLevel());
//                    count_Hoplite.setText(String.valueOf(screen.listTownHall[4].getSoHoplite()));
//                    count_SG.setText(String.valueOf(screen.listTownHall[4].getSoSteamGiant()));
//                    count_Swordsman.setText(String.valueOf(screen.listTownHall[4].getSoSwordsman()));
//                    count_Spearman.setText(String.valueOf(screen.listTownHall[4].getSoSpearman()));
//                    count_SulphurC.setText(String.valueOf(screen.listTownHall[4].getSoSulphur_C()));
//                    count_Archer.setText(String.valueOf(screen.listTownHall[4].getSoArcher()));
//                    count_Slinger.setText(String.valueOf(screen.listTownHall[4].getSoSlinger()));
//                    count_Mortar.setText(String.valueOf(screen.listTownHall[4].getSoMortar()));
//                    count_Catapult.setText(String.valueOf(screen.listTownHall[4].getSoCatapult()));
//                    count_Ram.setText(String.valueOf(screen.listTownHall[4].getSoRam()));
//                    count_Balloon_Bom.setText(String.valueOf(screen.listTownHall[4].getSoBalloon_Bombardier()));
//                    count_Gyrocopter.setText(String.valueOf(screen.listTownHall[4].getSoGyrocopter()));
//                    count_Cook.setText(String.valueOf(screen.listTownHall[4].getSoCook()));
//                    count_Doctor.setText(String.valueOf(screen.listTownHall[4].getSoDoctor()));
//                    count_Barbarian_Axe.setText(String.valueOf(screen.listTownHall[4].getSoBarbarian_Axe()));
//                    break;
//                case "flag6":
//                    level.setText(screen.listTownHall[5].getLevel());
//                    count_Hoplite.setText(String.valueOf(screen.listTownHall[5].getSoHoplite()));
//                    count_SG.setText(String.valueOf(screen.listTownHall[5].getSoSteamGiant()));
//                    count_Swordsman.setText(String.valueOf(screen.listTownHall[5].getSoSwordsman()));
//                    count_Spearman.setText(String.valueOf(screen.listTownHall[5].getSoSpearman()));
//                    count_SulphurC.setText(String.valueOf(screen.listTownHall[5].getSoSulphur_C()));
//                    count_Archer.setText(String.valueOf(screen.listTownHall[5].getSoArcher()));
//                    count_Slinger.setText(String.valueOf(screen.listTownHall[5].getSoSlinger()));
//                    count_Mortar.setText(String.valueOf(screen.listTownHall[5].getSoMortar()));
//                    count_Catapult.setText(String.valueOf(screen.listTownHall[5].getSoCatapult()));
//                    count_Ram.setText(String.valueOf(screen.listTownHall[5].getSoRam()));
//                    count_Balloon_Bom.setText(String.valueOf(screen.listTownHall[5].getSoBalloon_Bombardier()));
//                    count_Gyrocopter.setText(String.valueOf(screen.listTownHall[5].getSoGyrocopter()));
//                    count_Cook.setText(String.valueOf(screen.listTownHall[5].getSoCook()));
//                    count_Doctor.setText(String.valueOf(screen.listTownHall[5].getSoDoctor()));
//                    count_Barbarian_Axe.setText(String.valueOf(screen.listTownHall[5].getSoBarbarian_Axe()));
//                    break;
//            }
//        }
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // chuan bi du lieu Intent
//                Intent data=new Intent(getApplicationContext(),Screen.class);
//                String id=getIntent().getStringExtra("id");
//                data.putExtra("id_back",id);
//                data.putExtra("level",level.getText().toString());
//                data.putExtra("soHoplite",count_Hoplite.getText().toString());
//                data.putExtra("soSteamGiant",count_SG.getText().toString());
//                data.putExtra("soSwordsman",count_Swordsman.getText().toString());
//                data.putExtra("soSpearman",count_Spearman.getText().toString());
//                data.putExtra("soSulphur_C",count_SulphurC.getText().toString());
//                data.putExtra("soArcher",count_Archer.getText().toString());
//                data.putExtra("soSlinger",count_Slinger.getText().toString());
//                data.putExtra("soMortar",count_Mortar.getText().toString());
//                data.putExtra("soCatapult",count_Catapult.getText().toString());
//                data.putExtra("soRam",count_Ram.getText().toString());
//                data.putExtra("soBalloon_Bombardier",count_Balloon_Bom.getText().toString());
//                data.putExtra("soGyrocopter",count_Gyrocopter.getText().toString());
//                data.putExtra("soCook",count_Cook.getText().toString());
//                data.putExtra("soDoctor",count_Doctor.getText().toString());
//                data.putExtra("soBarbarian-Axe ",count_Barbarian_Axe.getText().toString());
////                setResult(Activity.RESULT_OK,data);
////                finish();
//                startActivity(data);
//                finish();
//            }
//        });
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }
}
