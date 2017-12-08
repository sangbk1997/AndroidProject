package com.example.sangbk.qlsanpham;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView listView=null;
    private  MySQLHelper helper=null;
    private ItemAdapter adapter=null;
    Cursor model=null;
    public final static String EXTRA_ID="IDItem";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper=new MySQLHelper(this);
        model=helper.getAll();
        startManagingCursor(model);
        adapter=new ItemAdapter(model);
        listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClick);
    }
    protected void onDestroy(){
        super.onDestroy();
        helper.close();
    }

    private AdapterView.OnItemClickListener onListClick=new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent,
                                View view, int position,
                                long id) {
            Intent intent=new Intent(getApplicationContext(),DetailItem.class);
            intent.putExtra("id",String.valueOf(id));
            intent.putExtra("iden",id);
            startActivity(intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.option, menu);
        return (super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.add){
            Intent intent=new Intent(this,DetailItem.class);
            startActivity(intent);
            return  true;
        }
//        if(item.getItemId()==R.id.sort){
//            Intent intent=new Intent(this,Preference.class);
//            startActivity(intent);
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }
    class ItemAdapter extends CursorAdapter {
        ItemAdapter(Cursor c) {
            super(MainActivity.this, c);
        }
        @Override
        public void bindView(View row, Context ctxt,
                             Cursor c) {
            ItemHolder holder=(ItemHolder)row.getTag();
            holder.populateFrom(c, helper);
        }
        @Override
        public View newView(Context ctxt, Cursor c,
                            ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View row=inflater.inflate(R.layout.row, parent, false);
            ItemHolder holder=new ItemHolder(row);
            row.setTag(holder);
            return(row);
        }
    }
    static class ItemHolder {
        private TextView name=null;
        private TextView count=null;
        private TextView cost=null;
        ItemHolder(View row) {
            name=(TextView)row.findViewById(R.id.name);
            count=(TextView)row.findViewById(R.id.count);
            cost=(TextView)row.findViewById(R.id.cost);
        }
        void populateFrom(Cursor c, MySQLHelper helper) {
            name.setText(helper.getName(c));
            count.setText(helper.getCount(c));
            cost.setText(helper.getCost(c));
        }
    }

}
