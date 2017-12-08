package com.example.sangbk.thefourthapp;

import android.graphics.Color;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Restaurant> model = new ArrayList<Restaurant>();
    RestaurantAdapter adapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(onSave);
        ListView list = (ListView) findViewById(R.id.restaurants);
        adapter = new RestaurantAdapter();
        list.setAdapter(adapter);


    }

    private View.OnClickListener onSave = new View.OnClickListener() {
        public void onClick(View v) {
            Restaurant r = new Restaurant();
            EditText name = (EditText) findViewById(R.id.name);
            EditText address = (EditText) findViewById(R.id.add);
            r.setName(name.getText().toString());
            r.setAddress(address.getText().toString());
            RadioGroup types = (RadioGroup) findViewById(R.id.types);
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
            RadioGroup sales = (RadioGroup) findViewById(R.id.sales);
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

    class RestaurantAdapter extends ArrayAdapter<Restaurant> {
        RestaurantAdapter() {
            super(MainActivity.this, R.layout.row, model);
        }
//để hiển thị item lên ListView khi duyệt qua mảng chứa dữ liệu cần hiển thị (trong trường hợp này là this._listItems).
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            RestaurantHolder holder = null;
            if (row == null) {
                // Doc tap tin row.xml de lay cac thanh phan
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.row, null, false);
                holder = new RestaurantHolder(row);
                row.setTag(holder);
            } else {
                holder = (RestaurantHolder) row.getTag();
            }
            holder.populaterFrom(model.get(position),position);
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

        void populaterFrom(Restaurant r,int positiont) {
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
            if((positiont%2)==0){
                example.setBackgroundColor(Color.BLUE);
                name.setTextColor(Color.WHITE);
                address.setTextColor(Color.WHITE);
                salse.setTextColor(Color.WHITE);
            }
            else{
                example.setBackgroundColor(Color.GREEN);
                name.setTextColor(Color.BLACK);
                address.setTextColor(Color.BLACK);
                salse.setTextColor(Color.BLACK);

            }

        }
    }
}
