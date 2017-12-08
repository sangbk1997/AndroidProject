package com.example.sangbk.loginikariam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText editUser, editPassword;
    CheckBox checksave;
    // dat ten cho tap tin luu trang thai
    String prefname="my_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button)findViewById(R.id.save);
        editUser=(EditText)findViewById(R.id.user);
        editPassword=(EditText)findViewById(R.id.pass);
        checksave=(CheckBox)findViewById(R.id.checked);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });
    }
    public void doLogin(){
        finish(); // dong man hinh hien tai
        Intent i=new Intent(this,Login.class);
        // truyen du lieu qua man hinh moi
        i.putExtra("user",editUser.getText().toString());
        startActivity(i);// mo man hinh moi

    }
    protected  void onPause(){
        super.onPause();
        // goi ham luu trang thai
        savingPreferences();
    }
    protected void onResume(){
        super.onResume();
        restoringPreference();
    }
    public void savingPreferences(){
        // tao doi tuong getSharedPreference
        SharedPreferences pre=getSharedPreferences(prefname,MODE_PRIVATE);
        // Tao doi tuong editor de luu thay doi
        SharedPreferences.Editor editor=pre.edit();
        String user=editUser.getText().toString();
        String pass=editPassword.getText().toString();
        boolean checked=checksave.isChecked();
        if(!checked){
            // xoa moi luu tru trươc do
            editor.clear();
        }else{
            // luu vao editor
            editor.putString("user",user);
            editor.putString("password",pass);
            editor.putBoolean("checked",checked);
        }
        // chap nhan luu xuong file
        editor.commit();
    }
    // doc ham da luu truoc do
    public void restoringPreference(){
        SharedPreferences pre=getSharedPreferences(prefname,MODE_PRIVATE);
        // lay gia tri check ra, neu khong thay thi gia tri mac dinh la false
        boolean checked=pre.getBoolean("checked",false);
        if (checked){
            // lay user , pass neu khong thay gia tri mac dinh la rông
            String user=pre.getString("user","");
            String pass=pre.getString("password","");
            editUser.setText(user);
            editPassword.setText(pass);
        }
        checksave.setChecked(checked);
    }
}
