package com.example.sangbk.firebasetutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        listView=(ListView)findViewById(R.id.list);
        FirebaseApp myFirebase=new FirebaseApp("http://sangbk.firebaseio.com/");
    }
}
