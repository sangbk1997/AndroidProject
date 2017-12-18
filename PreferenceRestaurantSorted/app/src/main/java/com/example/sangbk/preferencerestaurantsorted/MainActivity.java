package com.example.sangbk.preferencerestaurantsorted;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    RestaurantAdapter adapter=null;
    Cursor model=null;
    RestaurantHelper helper=null;
    SharedPreferences prefs=null;
    ListView list=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper=new RestaurantHelper(this);
//        model=helper.getAll(prefs.getString("sort_order","name"))
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        model=helper.getAll(prefs.getString("sort_order","name"));
        prefs.registerOnSharedPreferenceChangeListener(prefListener);
        startManagingCursor(model);
        adapter=new RestaurantAdapter(model);
        list =(ListView)findViewById(R.id.restaurants);
        list.setAdapter(adapter);
        list.setOnItemClickListener(onListClick);

//        setListAdapter(adapter);


    }
    private SharedPreferences.OnSharedPreferenceChangeListener prefListener=new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
            if(s.equals("sort_order")){
                initList();
            }
        }
    };

    private void initList(){
        if(model != null){
            stopManagingCursor(model);
            model.close();
        }
        model=helper.getAll(prefs.getString("sort_order","name"));
        startManagingCursor(model);
        adapter=new RestaurantAdapter(model);
        list.setAdapter(adapter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        helper.close();
    }


    private AdapterView.OnItemClickListener onListClick=new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent,
                                View view, int position,
                                long id) {
            Intent i=new Intent(MainActivity.this,DetailForm.class);
            i.putExtra("ID_EXTRA",String.valueOf(id));
            startActivity(i);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.add){
            startActivity(new Intent(MainActivity.this,DetailForm.class));
            return true;
        }
        else if(item.getItemId()==R.id.sort){
            startActivity(new Intent(this, EditPreferences.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class RestaurantAdapter extends CursorAdapter {
        public RestaurantAdapter( Cursor c) {
            super(MainActivity.this, c);
        }

        @Override
        public void bindView(View view, Context context, Cursor c) {
            RestaurantHolder holder=(RestaurantHolder)view.getTag();
            holder.populaterFrom(c,helper);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {

            LayoutInflater inflater=getLayoutInflater();
            View row=inflater.inflate(R.layout.row,viewGroup,false);
            RestaurantHolder holder=new RestaurantHolder(row);
            row.setTag(holder);
            return row;
        }


    }

    static class RestaurantHolder {
        private TextView name = null;
        private TextView address = null;
        private ImageView icon = null;
        RestaurantHolder(View row) {
            name=(TextView)row.findViewById(R.id.title);
            address=(TextView)row.findViewById(R.id.address);
            icon=(ImageView)row.findViewById(R.id.icon);

        }

        void populaterFrom(Cursor c, RestaurantHelper helper) {
            name.setText(helper.getName(c));
            address.setText(helper.getAddress(c));
            if(helper.getType(c).equals("Sit_down")){
                icon.setImageResource(R.drawable.ball_red);
            }else if(helper.getType(c).equals("Take_out")){
                icon.setImageResource(R.drawable.ball_yellow);
            }else{
                icon.setImageResource(R.drawable.ball_green);
            }
        }
    }
}