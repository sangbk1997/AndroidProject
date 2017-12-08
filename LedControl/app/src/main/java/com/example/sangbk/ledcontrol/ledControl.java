package com.example.sangbk.ledcontrol;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;
import java.util.UUID;

public class ledControl extends AppCompatActivity {
    Button btnOn1,btnOn2,btnOn3,btnOn4,btnOn5,btnOn6,btnOn7,btnOn8,btnOff1,btnOff2,btnOff3,btnOff4,btnOff5,btnOff6,btnOff7,btnOff8,btnDis;
    SeekBar brightness1;
    String address=null;
    private ProgressDialog progressDialog;
    BluetoothAdapter myBluetooth=null;
    BluetoothSocket btSocket=null;
    private boolean isBtConnected=false;
    static final UUID myUUID=UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led_control);
        btnOn1=(Button)findViewById(R.id.on1);
        btnOff1=(Button)findViewById(R.id.off1);
        brightness1=(SeekBar)findViewById(R.id.seekbar1);
        btnOn2=(Button)findViewById(R.id.on2);
        btnOff2=(Button)findViewById(R.id.off2);
     //   brightness2=(SeekBar)findViewById(R.id.seekbar);
        btnOn3=(Button)findViewById(R.id.on3);
        btnOff3=(Button)findViewById(R.id.off3);
     //   brightness3=(SeekBar)findViewById(R.id.seekbar);
        btnOn4=(Button)findViewById(R.id.on4);
        btnOff4=(Button)findViewById(R.id.off4);
      //  brightness4=(SeekBar)findViewById(R.id.seekbar);
        btnOn5=(Button)findViewById(R.id.on5);
        btnOff5=(Button)findViewById(R.id.off5);
     //   brightness5=(SeekBar)findViewById(R.id.seekbar);
        btnOn6=(Button)findViewById(R.id.on6);
        btnOff6=(Button)findViewById(R.id.off6);
     //   brightness6=(SeekBar)findViewById(R.id.seekbar);
        btnOn7=(Button)findViewById(R.id.on7);
        btnOff7=(Button)findViewById(R.id.off7);
        btnOn8=(Button)findViewById(R.id.on8);
        btnOff8=(Button)findViewById(R.id.off8);
        btnDis=(Button)findViewById(R.id.disconnect);
        // recive the address of bluetooth device
        Intent newInt=getIntent();
        address=newInt.getStringExtra("address");
        btnOn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed("1"); // method to turn on
            }
        });
        btnOff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed("img2");
            }
        });
        btnOn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed("3"); // method to turn on
            }
        });
        btnOff2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed("4");
            }
        });
        btnOn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed("5"); // method to turn on
            }
        });
        btnOff3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed("6");
            }
        });
        btnOn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed("7"); // method to turn on
            }
        });
        btnOff4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed("8");
            }
        });
        btnOn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed("9"); // method to turn on
            }
        });
        btnOff5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed("10");
            }
        });
        btnOn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed("11"); // method to turn on
            }
        });
        btnOff6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed("12");
            }
        });
        btnOn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed("13"); // method to turn on
            }
        });
        btnOff7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed("14");
            }
        });
        btnOn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed("15"); // method to turn on
            }
        });
        btnOff8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed("16");
            }
        });
        btnDis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Disconnect();
            }
        });
        brightness1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser==true){
                    try{
                        btSocket.getOutputStream().write(String.valueOf(progress).getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
//        brightness2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if(fromUser==true){
//                    try{
//                        btSocket.getOutputStream().write(String.valueOf(progress).getBytes());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//        brightness3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if(fromUser==true){
//                    try{
//                        btSocket.getOutputStream().write(String.valueOf(progress).getBytes());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//        brightness4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if(fromUser==true){
//                    try{
//                        btSocket.getOutputStream().write(String.valueOf(progress).getBytes());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//        brightness5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if(fromUser==true){
//                    try{
//                        btSocket.getOutputStream().write(String.valueOf(progress).getBytes());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//        brightness6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if(fromUser==true){
//                    try{
//                        btSocket.getOutputStream().write(String.valueOf(progress).getBytes());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });

    }
    private  class ConnectBT extends AsyncTask<Void, Void,Void> // UI thread
    {
        private boolean ConnectSuccess=true; // if it's here, it's almost connecte

        @Override
        protected void onPreExecute() {
            progressDialog=ProgressDialog.show(ledControl.this,"Connecting...","Please wait a minutes ! ");
            super.onPreExecute();
        }


        @Override
        protected Void doInBackground(Void... params) {
            try{
                if(btSocket ==null || !isBtConnected){
                    myBluetooth=BluetoothAdapter.getDefaultAdapter();
                    BluetoothDevice dispositivo=myBluetooth.getRemoteDevice(address);  // connects to the device's address and check if it's available
                    btSocket =dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);// create a RFCOMM ( SPP ) connection
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    btSocket.connect(); // start connection
                }
            } catch (IOException e) {
                  ConnectSuccess=false;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) { // after the doInBackground, it checks if everything went fine

            super.onPostExecute(aVoid);
            if(!ConnectSuccess){
                msg("Kết nối thất bại ! Yêu cầu thử lại .");
                finish();
            }else{
                msg("Connected ! ");
                isBtConnected=true;
            }
            progressDialog.dismiss();
        }

    }
    private  void msg(String s){
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }
    private void Disconnect()  {
        if(btSocket !=null){
            try {
                btSocket.close();
            } catch (IOException e) {
                msg("Error");
            }
        }
        finish();
    }
    private void turnOnLed(String s) {
        if(btSocket!=null){
            try {
                btSocket.getOutputStream().write(s.toString().getBytes());
            } catch (IOException e) {
                msg("Error");
            }
        }
    }
    private void turnOffLed(String s){
        if(btSocket!=null){
            try {
                btSocket.getOutputStream().write(s.toString().getBytes());
            } catch (IOException e) {
                msg("Error");
            }
        }
    }
}

