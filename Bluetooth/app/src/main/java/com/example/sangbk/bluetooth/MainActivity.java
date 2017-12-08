package com.example.sangbk.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_ADDRESS = "";
    Button buttonShow;
    ListView deviceList;
    private BluetoothAdapter myBluetooth=null;
    private Set<BluetoothDevice> pairedDevices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonShow = (Button) findViewById(R.id.showDevices);
        deviceList = (ListView) findViewById(R.id.list);
        myBluetooth =BluetoothAdapter.getDefaultAdapter();
        if(myBluetooth==null){
            // show a message that the devices has no bluetooth adapter
            Toast.makeText(getApplicationContext(),"Bluetooth Device Not Available",Toast.LENGTH_LONG).show();
            // finish
            finish();
        }else{
            if(myBluetooth.isEnabled()){

            }else{
                // ask to the user turn bluetooth on
                Intent turnBTon=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(turnBTon,1);

            }
        }
        buttonShow.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                pairedDevicesList();
            }
        });
    }
    private void pairedDevicesList(){
        pairedDevices=myBluetooth.getBondedDevices();
        ArrayList list=new ArrayList();
            if(pairedDevices.size()>0){
                for (BluetoothDevice bt : pairedDevices){
                    list.add(bt.getName()+" \n "+bt.getAddress());
                }
            }else{
                Toast.makeText(getApplicationContext(),"No Paired Bluetooth Devices Found",Toast.LENGTH_LONG).show();
            }
        final ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        deviceList.setAdapter(adapter);
        deviceList.setOnItemClickListener(myListClickListener);

    }
    private AdapterView.OnItemClickListener myListClickListener=new AdapterView.OnItemClickListener(){

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // get the device MAC address, the last 17 chars in the View
            String info=((TextView)view).getText().toString();
            String address=info.substring(info.length()-17);
            // make an intent to start activity
            Intent i=new Intent(MainActivity.this,ledControl.class);
            i.putExtra(EXTRA_ADDRESS,address);
            startActivity(i);
        }
    };



}
