package com.example.sangbk.dialogdemo;

import android.app.Dialog;
import android.content.Context;
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
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView=null;
    private  MySQLHelper helper=null;
    private ItemAdapter adapter=null;
    Cursor model=null;
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
            Toast.makeText(getApplicationContext(),"Nothing to show for you",Toast.LENGTH_LONG).show();
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
            Dialog dialog = new Dialog(this); // khoi tao dialog
            dialog.setContentView(R.layout.customdialog);// xet layout cho dialog
            dialog.setTitle("Thêm sản phẩm vào ListView"); // xet title
            final Button dialogButton=(Button)dialog.findViewById(R.id.save);
            Button dialogButton2=(Button)dialog.findViewById(R.id.cancel);
            final EditText name=(EditText)dialog.findViewById(R.id.tensp);
            final EditText count=(EditText)dialog.findViewById(R.id.soluongsp);
            final EditText cost=(EditText)dialog.findViewById(R.id.giasp);
            // khai bao bat su kien
            dialog.show();
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    helper.insert(name.getText().toString(),count.getText().toString(),cost.getText().toString());
                }
            });
            dialogButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    helper.delete(name.getText().toString());

                }
            });
            return  true;

        }
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


