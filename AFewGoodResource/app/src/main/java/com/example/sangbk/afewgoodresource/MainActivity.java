package com.example.sangbk.afewgoodresource;

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
import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends TabActivity {
    List<Restaurant> model=new ArrayList<Restaurant>();
    RestaurantAdapter adapter=null;
    RestaurantAdapter adapter2=null;
    EditText name=null;
    EditText address=null;
    EditText notes=null;
    RadioGroup types=null;
    RadioGroup sales=null;
    Restaurant current=null;
    AtomicBoolean isActive=new AtomicBoolean(true);
    int progress=0;
    ProgressBar progressBar;
    ListView list=null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"The onCreate() event",Toast.LENGTH_LONG).show();
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
        getTabHost().setCurrentTab(0);
        list.setOnItemClickListener(onListClick);
    }


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
                String message="No restaurant selected";
                if (current!=null) {
                    message=current.getNotes();
                }
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                return(true);
            case R.id.Tang:
                Collections.sort(model, new Comparator<Restaurant>() {
                    @Override
                    public int compare(Restaurant o1, Restaurant o2) {
                        return (o1.getName().compareToIgnoreCase(o2.getName()));
                    }
                });
                return true;
            case R.id.Giam:
                Collections.sort(model, new Comparator<Restaurant>() {
                    @Override
                    public int compare(Restaurant o1, Restaurant o2) {
                        return (o2.getName().compareToIgnoreCase(o1.getName()));
                    }
                });
                return true;
            case R.id.run:
                progressBar.setVisibility(0);
                startWork();
                return true;
            case R.id.clear:
                adapter.clear();
                return true;

        }
        adapter.notifyDataSetChanged();
        return(super.onOptionsItemSelected(item));
    }



    private void startWork() {
        progressBar.setVisibility(0);
        new Thread(longTask).start();
    }



    private void doSomeLongWork(final int incr) {
        runOnUiThread(new Runnable() {
            public void run() {
                progress+=incr;
                progressBar.setProgress(progress);
            }
        });
        try {
            Thread.sleep(500); // should be something more useful!
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    private View.OnClickListener onSave=new View.OnClickListener() {
        public void onClick(View v) {
            current=new Restaurant();
            current.setName(name.getText().toString());
            current.setAddress(address.getText().toString());
            current.setNotes(notes.getText().toString());
            switch (types.getCheckedRadioButtonId()) {
                case R.id.sit_down:
                    current.setType("Sit_down");
                    break;

                case R.id.take_out:
                    current.setType("Take_out");
                    break;

                case R.id.delivery:
                    current.setType("delivery");
                    break;
            }
            switch (sales.getCheckedRadioButtonId()) {
                case R.id.no:
                    current.setSale("Discount 0%");
                    break;

                case R.id.giam20:
                    current.setSale("Discount 20%");
                    break;

                case R.id.giam50:
                    current.setSale("Discount 50%");
                    break;
            }
//            adapter.add(current);
            model.add(current);
        }
    };



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




    private Runnable longTask=new Runnable() {
        public void run() {
            for (int i=0;i<20 && isActive.get();i++) {
                doSomeLongWork(5);
            }
            if (isActive.get()) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        progressBar.setVisibility(8);
                        Toast.makeText(MainActivity.this,"Finish () !!",Toast.LENGTH_LONG).show();
                        progress=0;
                    }
                });
            }
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

        RestaurantHolder(View row) {
            name = (TextView) row.findViewById(R.id.title);
            address = (TextView) row.findViewById(R.id.address);
            salse =(TextView)row.findViewById(R.id.dis);
            icon = (ImageView) row.findViewById(R.id.icon);
            icon2 = (ImageView)row.findViewById(R.id.icon2);
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