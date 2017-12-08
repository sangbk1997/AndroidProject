package com.example.sangbk.ikariam_part1;

import android.app.TabActivity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends TabActivity {
    AutoCompleteTextView ten_NV=null;
    EditText mau_NV=null;
    EditText satthuong_NV=null;
    EditText giap_NV=null;
    EditText sodan_NV=null;
    NVAdapter adapter=null;
    ListView list=null;
    ImageView icon=null;
    MySQLHelper helper=null;
    Cursor model=null;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList listNV=new ArrayList();
        listNV.add("hoplite");
        listNV.add("steam_giant");
        listNV.add("barbarian_axe_swinger");
        listNV.add("spearman");
        listNV.add("swordsman");
        listNV.add("slinger");
        listNV.add("archer");
        listNV.add("sulphur_carabineer");
        listNV.add("gyrocopter");
        listNV.add("balloon_bombardier");
        listNV.add("ram");
        listNV.add("catapult");
        listNV.add("mortar");
        listNV.add("cook");
        listNV.add("doctor");
        ten_NV=(AutoCompleteTextView) findViewById(R.id.auto);
        mau_NV=(EditText)findViewById(R.id.mauNV);
        satthuong_NV=(EditText) findViewById(R.id.satthuongNV);
        giap_NV=(EditText) findViewById(R.id.giapNV);
        sodan_NV=(EditText)findViewById(R.id.sodanNV);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listNV);
        ten_NV.setAdapter(arrayAdapter);
        ten_NV.setThreshold(1);
        Button save=(Button)findViewById(R.id.save);
        Button cancel=(Button)findViewById(R.id.cancel);
        save.setOnClickListener(onSave);
        cancel.setOnClickListener(onCancel);
        list=(ListView)findViewById(R.id.listNV);
        helper=new MySQLHelper(this);
        model=helper.getAll();
        startManagingCursor(model);
        adapter=new NVAdapter(model);
        list.setAdapter(adapter);

        TabHost.TabSpec spec=getTabHost().newTabSpec("tag1");

        spec.setContent(R.id.listNV);
        spec.setIndicator("", getResources().getDrawable(R.drawable.list));
        getTabHost().addTab(spec);
        spec=getTabHost().newTabSpec("tag2");
        spec.setContent(R.id.details);
        spec.setIndicator("", getResources()
                .getDrawable(R.drawable.configure));
        getTabHost().addTab(spec);
        getTabHost().setCurrentTab(0);
        list.setOnItemClickListener(onListClick);
    }


    private View.OnClickListener onSave=new View.OnClickListener() {
        public void onClick(View v) {
            helper.insert(ten_NV.getText().toString(),mau_NV.getText().toString(),satthuong_NV.getText().toString(),giap_NV.getText().toString(),sodan_NV.getText().toString());
            model.requery();
            getTabHost().setCurrentTab(0);
        }
    };
    private View.OnClickListener onCancel=new View.OnClickListener() {
        public void onClick(View v) {
            helper.delete(ten_NV.getText().toString());
            model.requery();
            getTabHost().setCurrentTab(0);
        }
    };

    private AdapterView.OnItemClickListener onListClick=new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent,
                                View view, int position,
                                long id) {
            model.moveToPosition(position);
            ten_NV.setText(helper.getTen(model));
            mau_NV.setText(helper.getMau(model));
            satthuong_NV.setText(helper.getSatThuong(model));
            giap_NV.setText(helper.getGiap(model));
            sodan_NV.setText(helper.getSoDan(model));
            getTabHost().setCurrentTab(1);
        }
    };




    class NVAdapter extends CursorAdapter {


        public NVAdapter( Cursor c) {
            super(MainActivity.this, c);
        }
        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View row=inflater.inflate(R.layout.row,parent,false);
            NVHolder holder=new NVHolder(row);
            row.setTag(holder);
            return row;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            NVHolder holder=(NVHolder)view.getTag();
            holder.populaterFrom(cursor,helper);
        }
    }


    class NVHolder {
        private TextView ten_NV=null;
        private TextView mau_NV=null;
        private TextView satThuong_NV=null;
        private TextView giap_NV=null;
        private TextView soDan_NV=null;
        private ImageView icon_NV=null;
//        MainActivity mainActivity=null;

        NVHolder(View row) {
            ten_NV = (TextView) row.findViewById(R.id.ten);
            mau_NV = (TextView) row.findViewById(R.id.mau);
            satThuong_NV =(TextView)row.findViewById(R.id.satthuong);
            giap_NV = (TextView) row.findViewById(R.id.giap);
            soDan_NV = (TextView) row.findViewById(R.id.sodan);
            icon_NV=(ImageView)row.findViewById(R.id.imgNV);
        }

        void populaterFrom(Cursor c, MySQLHelper helper) {
//            icon_NV.setImageResource(R.drawable.archer);
            ten_NV.setText(helper.getTen(c));
            String temp=helper.getTen(c);
            icon_NV.setImageResource(getDrawableIdByName(temp));
            mau_NV.setText(helper.getMau(c));
            satThuong_NV.setText(helper.getSatThuong(c));
            giap_NV.setText(helper.getGiap(c));
            soDan_NV.setText(helper.getSoDan(c));
        }


    }
    // Tim id theo ten
    public int getDrawableIdByName(String resName){
        String pkg=getPackageName();
        int resID=getResources().getIdentifier(resName,"drawable",pkg);
        return resID;
    }
}