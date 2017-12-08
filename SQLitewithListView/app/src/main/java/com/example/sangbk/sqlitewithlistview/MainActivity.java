package com.example.sangbk.sqlitewithlistview;

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
    private ListView listItems;
    private MySQLHelper helper;
    private Cursor model;
    private ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listItems=(ListView)findViewById(R.id.list_item);
        helper=new MySQLHelper(this);
        model=helper.getAll();
        startManagingCursor(model);
        adapter=new ItemAdapter(model);
        listItems.setAdapter(adapter);
    }
    protected void onDestroy(){
        super.onDestroy();
        helper.close();
    }

    private AdapterView.OnItemClickListener onListClick=new
            AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent,
                                        View view, int position,
                                        long id) {
                    model.moveToPosition(position);
                    Intent intent=new Intent(MainActivity.this,DetailItem.class);
                    intent.putExtra("tensanpham",helper.getName(model));
                    intent.putExtra("soluong",helper.getCount(model));
                    intent.putExtra("dongia",helper.getCost(model));
                    startActivity(intent);
                }
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.add){
            startActivity(new Intent(this,DetailItem.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class ItemAdapter extends CursorAdapter{

        public ItemAdapter( Cursor c) {
            super(MainActivity.this, c);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View row=inflater.inflate(R.layout.row,parent,false);
            ItemHolder holder=new ItemHolder(row);
            row.setTag(holder);
            return row;
        }

        @Override
        public void bindView(View view, Context context, Cursor c) {
            ItemHolder holder=(ItemHolder)view.getTag();
            holder.populateIFrom(c,helper);
        }
    }
    class ItemHolder{
        private TextView name=null;
        private TextView count=null;
        private TextView cost=null;
        ItemHolder(View v){
            name=(TextView)findViewById(R.id.item);
            count=(TextView)findViewById(R.id.count);
            cost=(TextView)findViewById(R.id.cost);
        }
        void populateIFrom(Cursor c, MySQLHelper helper){
            name.setText(helper.getName(c));
            count.setText(helper.getCount(c));
            cost.setText(helper.getCost(c));
        }
    }
}
