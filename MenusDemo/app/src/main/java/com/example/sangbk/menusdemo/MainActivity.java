package com.example.sangbk.menusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// load file menu của chúng ta ở đây.
        getMenuInflater().inflate(R.menu.option, menu);
        return true;
    }
    // Hàm sử lý sự kiện khi click vào mỗi item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.edit:
                Toast.makeText(this,"Edi",Toast.LENGTH_LONG).show();
                break;
            case R.id.delete:
                Toast.makeText(this,"Delete",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
