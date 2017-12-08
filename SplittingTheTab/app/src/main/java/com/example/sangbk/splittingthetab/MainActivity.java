package com.example.sangbk.splittingthetab;

import android.app.TabActivity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends TabActivity {
    List<Restaurants> model=new ArrayList<Restaurants>();
    RestaurantAdapter adapter=null;
    EditText name=null;
    EditText address=null;
    RadioGroup types=null;
    RadioGroup sales=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        address = (EditText) findViewById(R.id.address);
        types = (RadioGroup) findViewById(R.id.types);
        sales = (RadioGroup) findViewById(R.id.sales);
        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(onSave);
        ListView list = (ListView)findViewById(R.id.restaurants);
        adapter = new RestaurantAdapter();
        list.setAdapter(adapter);
        TabHost.TabSpec spec = getTabHost().newTabSpec("tag1");
        spec.setContent(R.id.restaurants);
        spec.setIndicator("List", getResources().getDrawable(R.drawable.list));
        getTabHost().addTab(spec);
        spec = getTabHost().newTabSpec("tag2");
        spec.setContent(R.id.details);
        spec.setIndicator("Details", getResources().getDrawable(R.drawable.restaurant));
        getTabHost().addTab(spec);
        getTabHost().setCurrentTab(0);
        list.setOnItemClickListener(onListClick);
    }
        private View.OnClickListener onSave=new View.OnClickListener(){
            public void onClick(View v) {
                Restaurants r = new Restaurants();
                EditText name = (EditText) findViewById(R.id.name);
                EditText address = (EditText) findViewById(R.id.add);
                r.setName(name.getText().toString());
                r.setAddress(address.getText().toString());
                switch (types.getCheckedRadioButtonId()) {
                    case R.id.take_out:
                        r.setType("Take_out");
                        break;
                    case R.id.sit_down:
                        r.setType("Sit_down");
                        break;
                    case R.id.delivery:
                        r.setType("Delivery");
                        break;
                }
                switch (sales.getCheckedRadioButtonId()) {
                    case R.id.no:
                        r.setSale("No_Discount");
                        break;
                    case R.id.giam20:
                        r.setSale("Discount 20%");
                        break;
                    case R.id.giam50:
                        r.setSale("Discount 50%");
                        break;
               }
                adapter.add(r);

            }
        };
        private AdapterView.OnItemClickListener onListClick=new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent,View view, int position,long id) {
                Restaurants r = model.get(position);
                name.setText(r.getName());
                address.setText(r.getAddress());
                if (r.getType().equals("Sit_down")) {
                    types.check(R.id.sit_down);
                } else if (r.getType().equals("Take_out")) {
                    types.check(R.id.take_out);
                } else {
                    types.check(R.id.delivery);
                }
                if (r.getSale().equals("No_Discount")) {
                    sales.check(R.id.no);
                } else if (r.getSale().equals("Discount 20%")) {
                    sales.check(R.id.giam20);
                } else {
                    sales.check(R.id.giam50);
                }
                getTabHost().setCurrentTab(1);
            }
        };

    class RestaurantAdapter extends ArrayAdapter<Restaurants>{
        RestaurantAdapter(){
            super(MainActivity.this,R.layout.row,model);
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            RestaurantHolder holder = null;
            if (row == null) {
                // Doc tap tin row.xml de lay cac thanh phan
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.row, parent, false);
                holder = new RestaurantHolder(row);
                row.setTag(holder);
            } else {
                holder = (RestaurantHolder) row.getTag();
            }
            holder.populaterFrom(model.get(position));
            return (row);
        }
    }
    static class RestaurantHolder {
        private TextView name = null;
        private TextView address = null;
        private TextView salse=null;
        private ImageView icon = null;
        private ImageView icon2=  null;
        private LinearLayout example=null;

        RestaurantHolder(View row) {
            name = (TextView) row.findViewById(R.id.title);
            address = (TextView) row.findViewById(R.id.address);
            salse =(TextView)row.findViewById(R.id.dis);
            icon = (ImageView) row.findViewById(R.id.image);
            icon2 = (ImageView)row.findViewById(R.id.image2);
            example =(LinearLayout)row.findViewById(R.id.bgcolor);

        }

        void populaterFrom(Restaurants r) {
            name.setText(r.getName());
            address.setText(r.getAddress());
            salse.setText(r.getSale());

            if (r.getType().equals("Sit_down")) {
                icon.setImageResource(R.drawable.ball_red);
            } else if (r.getType().equals("Take_out")) {
                icon.setImageResource(R.drawable.ball_yellow);

            } else {
                icon.setImageResource(R.drawable.ball_green);
            }
            if(r.getSale().equals("Discount 20%")){
                icon2.setImageResource(R.drawable.giam20);
            }else if(r.getSale().equals("Discount 50%")){
                icon2.setImageResource(R.drawable.giam50);
            }

                example.setBackgroundColor(Color.GREEN);
                name.setTextColor(Color.BLACK);
                address.setTextColor(Color.BLACK);
                salse.setTextColor(Color.BLACK);

         }
    }
}

