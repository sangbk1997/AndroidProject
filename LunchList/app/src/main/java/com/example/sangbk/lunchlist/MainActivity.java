package com.example.sangbk.lunchlist;

import android.app.TabActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends TabActivity {
    List<Restaurant> model=new ArrayList<Restaurant>();
    RestaurantAdapter adapter=null;
    EditText name=null;
    EditText address=null;
    RadioGroup types=null;
    RadioGroup sales=null;
    int sit=0,take=0,deli=0,sum=0;
    int giam0=0,giam20=0,giam50=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.name);
        address=(EditText)findViewById(R.id.addr);
        types=(RadioGroup)findViewById(R.id.types);
        sales=(RadioGroup)findViewById(R.id.sales);

        Button save=(Button)findViewById(R.id.save);

        save.setOnClickListener(onSave);

        ListView list=(ListView)findViewById(R.id.restaurants);

        adapter=new RestaurantAdapter();
        list.setAdapter(adapter);

        TabHost.TabSpec spec=getTabHost().newTabSpec("tag1");

        spec.setContent(R.id.restaurants);
        spec.setIndicator("List", getResources().getDrawable(R.drawable.list));
        getTabHost().addTab(spec);

        spec=getTabHost().newTabSpec("tag2");
        spec.setContent(R.id.details);
        spec.setIndicator("Details", getResources()
                .getDrawable(R.drawable.restaurant));
        getTabHost().addTab(spec);

        spec=getTabHost().newTabSpec("tag3");
        spec.setContent(R.id.thongke);
        spec.setIndicator("Statistics", getResources()
                .getDrawable(R.drawable.thongke));
        getTabHost().addTab(spec);

        getTabHost().setCurrentTab(0);

        list.setOnItemClickListener(onListClick);
    }

    private View.OnClickListener onSave=new View.OnClickListener() {
        public void onClick(View v) {
            Restaurant r=new Restaurant();
            TextView Sum=(TextView)findViewById(R.id.sum);
            sum++;
            r.setName(name.getText().toString());
            r.setAddress(address.getText().toString());


            switch (types.getCheckedRadioButtonId()) {
                case R.id.sit_down:
                    r.setType("Sit_down");
                    sit++;
                    break;

                case R.id.take_out:
                    r.setType("Take_out");
                    take++;
                    break;

                case R.id.delivery:
                    r.setType("delivery");
                    deli++;
                    break;
            }
            switch (sales.getCheckedRadioButtonId()) {
                case R.id.no:
                    r.setSale("Discount 0%");
                    giam0++;
                    break;

                case R.id.giam20:
                    r.setSale("Discount 20%");
                    giam20++;
                    break;

                case R.id.giam50:
                    r.setSale("Discount 50%");
                    giam50++;
                    break;
            }
            Collections.sort(model);
            adapter.add(r);
            setSumInfoDiscount(giam0,giam20,giam50);
            setSumTypeR(sit,take,deli);

        }
    };
    public void setSumTypeR(int sit,int take,int deli){
        TextView sd=(TextView)findViewById(R.id.sit);
        TextView to=(TextView)findViewById(R.id.take);
        TextView de=(TextView)findViewById(R.id.deli);
        sd.setText(String.valueOf(sit));
        to.setText(String.valueOf(take));
        de.setText(String.valueOf(deli));
    }
    public void setSumInfoDiscount(int giam0,int giam20,int giam50){
        TextView no=(TextView)findViewById(R.id.giam0);
        TextView dis20=(TextView)findViewById(R.id.giam_20);
        TextView dis50=(TextView)findViewById(R.id.giam_50);
        no.setText(String.valueOf(giam0));
        dis20.setText(String.valueOf(giam20));
        dis50.setText(String.valueOf(giam50));
    }


    private AdapterView.OnItemClickListener onListClick=new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent,
                                View view, int position,
                                long id) {
            Restaurant r=model.get(position);

            name.setText(r.getName());
            address.setText(r.getAddress());
            if (r.getType().equals("Sit_down")) {
                types.check(R.id.sit_down);
            }
            else if (r.getType().equals("Take_out")) {
                types.check(R.id.take_out);
            }
            else {
                types.check(R.id.delivery);
            }
            if (r.getSale().equals("Discount 20%")) {
                sales.check(R.id.giam20);
            }
            else if (r.getSale().equals("Discount 50%")) {
                sales.check(R.id.giam50);
            }
            else {
                sales.check(R.id.no);
            }
            getTabHost().setCurrentTab(1);
        }
    };

    class RestaurantAdapter extends ArrayAdapter<Restaurant> {
        RestaurantAdapter() {
            super(MainActivity.this, R.layout.row, model);
        }

        public View getView(int position, View convertView,
                            ViewGroup parent) {
            View row=convertView;
            RestaurantHolder holder=null;

            if (row==null) {
                LayoutInflater inflater=getLayoutInflater();

                row=inflater.inflate(R.layout.row, parent, false);
                holder=new RestaurantHolder(row);
                row.setTag(holder);
            }
            else {
                holder=(RestaurantHolder)row.getTag();
            }

            holder.populaterFrom(model.get(position));

            return(row);
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
            icon = (ImageView) row.findViewById(R.id.icon);
            icon2 = (ImageView)row.findViewById(R.id.icon2);
//            example =(LinearLayout)row.findViewById(R.id.bgcolor);

        }

        void populaterFrom(Restaurant r) {
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
            }else if(r.getSale().equals("Discount 50%")) {
                icon2.setImageResource(R.drawable.giam50);
            }
        }
    }
}