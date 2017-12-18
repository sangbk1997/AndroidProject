package com.example.sangbk.sqliterestaurant;

import android.app.TabActivity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends TabActivity {
    RestaurantAdapter adapter=null;
    Cursor model=null;
    EditText name=null;
    EditText address=null;
    EditText notes=null;
    RadioGroup types=null;
    RestaurantHelper helper=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper=new RestaurantHelper(this);
        name=(EditText)findViewById(R.id.name);
        address=(EditText)findViewById(R.id.addr);
        types=(RadioGroup)findViewById(R.id.types);
        notes=(EditText)findViewById(R.id.notes);
        Button save=(Button)findViewById(R.id.save);
        save.setOnClickListener(onSave);
        ListView list=(ListView)findViewById(R.id.restaurants);
        model=helper.getAll();
        startManagingCursor(model);
        adapter=new RestaurantAdapter(model);
        list.setAdapter(adapter);

        TabHost.TabSpec spec=getTabHost().newTabSpec("tag1");

        spec.setContent(R.id.restaurants);
        spec.setIndicator("", getResources().getDrawable(R.drawable.list));
        getTabHost().addTab(spec);

        spec=getTabHost().newTabSpec("tag2");
        spec.setContent(R.id.details);
        spec.setIndicator("", getResources()
                .getDrawable(R.drawable.restaurant));
        getTabHost().addTab(spec);
        getTabHost().setCurrentTab(0);

        list.setOnItemClickListener(onListClick);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        helper.close();
    }

    private View.OnClickListener onSave=new View.OnClickListener() {
        public void onClick(View v) {
            String type=null;
            switch (types.getCheckedRadioButtonId()) {
                case R.id.sit_down:
                    type ="Sit_down";
                    break;

                case R.id.take_out:
                    type="Take_out";
                    break;

                case R.id.delivery:
                    type="Delivery";
                    break;
            }
            helper.insert(name.getText().toString(),address.getText().toString(),type,notes.getText().toString());
            model.requery();
        }
    };




    private AdapterView.OnItemClickListener onListClick=new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent,
                                View view, int position,
                                long id) {
            model.moveToPosition(position);
            name.setText(helper.getName(model));
            address.setText(helper.getAddress(model));
            notes.setText(helper.getNotes(model));
            if (helper.getType(model).equals("Sit_down")) {
                types.check(R.id.sit_down);
            }
            else if (helper.getType(model).equals("Take_out")) {
                types.check(R.id.take_out);
            }
            else {
                types.check(R.id.delivery);
            }
            getTabHost().setCurrentTab(1);
        }
    };

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