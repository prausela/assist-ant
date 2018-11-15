package com.assist.home.assisthome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RoutinesActivity extends AppActivity {
    private ListView RView;
    private RoutinesAdapter RAdapter;
    ArrayList<Routine> routines = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContent(R.layout.activity_routines);

        getRoutine();
        RView = (ListView) findViewById(R.id.customListView);
        RAdapter = new RoutinesAdapter(this,routines);
        RView.setAdapter(RAdapter);
    }

    public void getRoutine(){
        routines.add(new Routine("Viaje"));
        routines.add(new Routine("Casa"));
        routines.add(new Routine("Noche"));
        routines.add(new Routine("Plantas"));

    }
}
