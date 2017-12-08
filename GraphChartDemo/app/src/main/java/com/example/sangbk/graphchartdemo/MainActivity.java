package com.example.sangbk.graphchartdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // create instance of a PieGraph we just created
    PieGraph yummyPie = new PieGraph();
    GraphicalView graphicalView = yummyPie.getGraphicalView(this, 3, 2, 1);

    LinearLayout pieGraph = (LinearLayout) findViewById(R.id.pieGraph);
      // pieGraph is just a regular LinearLayout you need to create in .xml file

    pieGraph.addView(graphicalView);
}
