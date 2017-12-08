package com.example.sangbk.setbackgroundthread;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends TabActivity {
    List<Restaurant> model=new ArrayList<Restaurant>();
    List<Restaurant> model2=new ArrayList<Restaurant>();
    RestaurantAdapter adapter=null;
    RestaurantAdapter adapter2=null;
    EditText name=null;
    EditText address=null;
    EditText notes=null;
    RadioGroup types=null;
    RadioGroup sales=null;
    Restaurant current=null;
    int progress=0;
    ProgressBar progressBar;
    ListView list=null;
//    int sit=0,take=0,deli=0,sum=0;
//    int giam0=0,giam20=0,giam50=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.name);
        address=(EditText)findViewById(R.id.addr);
        types=(RadioGroup)findViewById(R.id.types);
        sales=(RadioGroup)findViewById(R.id.sales);
        notes=(EditText)findViewById(R.id.notes);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        Button save=(Button)findViewById(R.id.save);
        save.setOnClickListener(onSave);
        list=(ListView)findViewById(R.id.restaurants);
        adapter=new RestaurantAdapter();
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

//        spec=getTabHost().newTabSpec("tag3");
//        spec.setContent(R.id.thongke);
//        spec.setIndicator("Statistics", getResources()
//                .getDrawable(R.drawable.thongke));
//        getTabHost().addTab(spec);

        getTabHost().setCurrentTab(0);

        list.setOnItemClickListener(onListClick);
    }
    private MenuItem.OnMenuItemClickListener select=new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {

            return true;
        }
    };
    private View.OnClickListener onSave=new View.OnClickListener() {
        public void onClick(View v) {
            current=new Restaurant();
//            TextView Sum=(TextView)findViewById(R.id.sum);
//            sum++;
            current.setName(name.getText().toString());
            current.setAddress(address.getText().toString());
            current.setNotes(notes.getText().toString());


            switch (types.getCheckedRadioButtonId()) {
                case R.id.sit_down:
                    current.setType("Sit_down");
//                    sit++;
                    break;

                case R.id.take_out:
                    current.setType("Take_out");
//                    take++;
                    break;

                case R.id.delivery:
                    current.setType("delivery");
//                    deli++;
                    break;
            }
            switch (sales.getCheckedRadioButtonId()) {
                case R.id.no:
                    current.setSale("Discount 0%");
//                    giam0++;
                    break;

                case R.id.giam20:
                    current.setSale("Discount 20%");
//                    giam20++;
                    break;

                case R.id.giam50:
                    current.setSale("Discount 50%");
//                    giam50++;
                    break;
            }
            model.add(current);
            model2.add(current);
//            setSumInfoDiscount(giam0,giam20,giam50);
//            setSumTypeR(sit,take,deli);


        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.toast:
                String message=current.getNotes();
                Toast.makeText(this,message, LENGTH_LONG).show();
                return  true;
            case R.id.Tang:
                Collections.sort(model, new Comparator<Restaurant>() {
                    @Override
                    public int compare(Restaurant o1, Restaurant o2) {
                        return (o1.getName().compareToIgnoreCase(o2.getName()));
                    }
                });
                break;
            case R.id.Giam:
                String kaka=String.valueOf(model.size());
                Toast.makeText(this,kaka, LENGTH_LONG).show();

                Collections.sort(model, new Comparator<Restaurant>() {
                    @Override
                    public int compare(Restaurant o1, Restaurant o2) {
                        return (o2.getName().compareToIgnoreCase(o1.getName()));
                    }
                });
                return true;
            case R.id.run:
                setProgressBarVisibility(true);
                progressBar.setMax(model2.size());
                adapter.clear();
                HelloThread ex=new HelloThread();
                ex.start();
                break;
            case R.id.clear:
                adapter.clear();
                break;

        }
        adapter.notifyDataSetChanged();
        return(super.onOptionsItemSelected(item));
    }
    private void doSomeLongWork(final int r) throws InterruptedException {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setProgress(r+1);
                adapter.add(model2.get(r));

            }
        });
        Thread.sleep(2000);
    }
    public class HelloThread extends Thread {
        public void run() {
            for (int i = 0; i < model2.size(); i++) {
                try {
                    doSomeLongWork(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    private AdapterView.OnItemClickListener onListClick=new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent,
                                View view, int position,
                                long id) {
            current=model.get(position);

            name.setText(current.getName());
            address.setText(current.getAddress());
            notes.setText(current.getNotes());
            if (current.getType().equals("Sit_down")) {
                types.check(R.id.sit_down);
            }
            else if (current.getType().equals("Take_out")) {
                types.check(R.id.take_out);
            }
            else {
                types.check(R.id.delivery);
            }
            if (current.getSale().equals("Discount 20%")) {
                sales.check(R.id.giam20);
            }
            else if (current.getSale().equals("Discount 50%")) {
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
//        private LinearLayout example=null;

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