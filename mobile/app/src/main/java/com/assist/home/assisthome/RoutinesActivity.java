package com.assist.home.assisthome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RoutinesActivity extends AppActivity {
    private ListView RView;
    private RoutinesAdapter RAdapter;
    ArrayList<Routine> routines = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContent(R.layout.activity_routines,"Rutinas");

        getRoutine();
        RView = (ListView) findViewById(R.id.customListView);
        RAdapter = new RoutinesAdapter(this,routines);
        RView.setAdapter(RAdapter);
        RView.setClickable(true);


        RView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = (int) parent.getItemAtPosition(position);
                Toast.makeText(RoutinesActivity.this, "Cliked at " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void getRoutine(){
//        List<DeviceCard> list=new ArrayList<>();
//        list.add(new DeviceCard("Aire",R.drawable.ac));
//        list.add(new DeviceCard("Puerta",R.drawable.door_close));
//        list.add(new DeviceCard("Persiana",R.drawable.blind_close));
//        list.add(new DeviceCard("Heladera",R.drawable.fridge));
//        list.add(new DeviceCard("Horno",R.drawable.oven));
//
//        routines.add(new Routine("Viaje",list));
//        routines.add(new Routine("Casa",list));
//        routines.add(new Routine("Noche",list));
//        routines.add(new Routine("Plantas",list));

    }
}
