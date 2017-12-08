package com.example.sangbk.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText textFirstName;
    private EditText textLastName;
    private TextView textFeedBack;
    public static final int MY_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textFirstName = (EditText) findViewById(R.id.text1);
        textLastName = (EditText) findViewById(R.id.text2);
        textFeedBack = (TextView) findViewById(R.id.feedback);

    }

    // Khi GreetingActivity hoan thanh, no gui phan hoi lai
    // Neu ban da start no bang cach su dung startActivityForResult
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

         if(requestCode==MY_REQUEST_CODE && resultCode== Activity.RESULT_OK){
             String feedback=data.getStringExtra("FeedBack");
             this.textFeedBack.setText(feedback);

         }else{
             textFeedBack.setText(" ! ?");
         }

   }

   // phuong thuc duoc goi khi nguoi dung click vao button "showGreetin"
    public void showGreeting(View view){
        String firstName=textFirstName.getText().toString();
        String lastName=textLastName.getText().toString();
        Intent intent=new Intent(this,GreetingActivity.class);
        intent.putExtra("firstName",firstName);
        intent.putExtra("lastName",lastName);
        // Yeu cau startActivity chi dinh trong Intent
        // gui yeu cau ma khong can hoi dap
        // this.startActivity(intent)

        // Yeu cau start Activity va cho phan hoi
        this.startActivityForResult(intent,MY_REQUEST_CODE);

    }



}
