package com.example.sangbk.bluetooth_arduino;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends Activity {
    Button b1,b2,b3,b4;
    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        BA=BluetoothAdapter.getDefaultAdapter();
        lv=(ListView)findViewById(R.id.listView);
    }
    public void On(View v){
        if(!BA.isEnabled()){
            Intent turnOn=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOn,0);
            Toast.makeText(getApplicationContext(),"Turned On",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext()," Already On",Toast.LENGTH_LONG).show();
        }
    }

    public void Off(View v){
        BA.disable();
        Toast.makeText(getApplicationContext(),"Turned Off",Toast.LENGTH_LONG).show();


    }
    public void Visible(View v){
        Intent getVisible =new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(getVisible,0);
    }
    public void List(View v){
        pairedDevices =BA.getBondedDevices();
        ArrayList list=new ArrayList();
        for(BluetoothDevice bt : pairedDevices){
           // DeviceItem newDevice= new DeviceItem(device.getName(),device.getAddress(),"false");
            list.add(bt.getName());
            Toast.makeText(getApplicationContext(),"Showing Paired Devices",Toast.LENGTH_LONG).show();
            final ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
            lv.setAdapter(adapter);
        }
    }


}