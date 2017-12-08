package com.example.sangbk.bluetooth;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.IOException;
import java.util.UUID;

public class ledControl extends AppCompatActivity {

    Button btnOn, btnOff,btnDis;
    SeekBar brightness;
    String address=null;
    private ProgressDialog progressDialog;
    BluetoothAdapter myBluetooth=null;
    BluetoothSocket btSocket=null;
    private boolean isBtConnected=false;
    static final UUID myUUID =UUID.fromString("00001101-0000-1000-8000-\n" +
            "00805F9B34FB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led_control);
        Intent newint=getIntent();
        address=newint.getStringExtra(MainActivity.EXTRA_ADDRESS);
        //view of the ledControl layout
        // call the widgets
        btnOn=(Button)findViewById(R.id.button1);
        btnOff=(Button)findViewById(R.id.button2);
        btnDis=(Button)findViewById(R.id.button3);
        brightness=(SeekBar)findViewById(R.id.seekbar);

    }
    private void Disconnect(){
        if(btSocket!=null){
            try {
                btSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
