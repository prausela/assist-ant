package com.assist.home.assisthome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class DeviceActivity extends AppActivity {
    private GridView dView;
    private DeviceCardAdapter dAdapter;
    ArrayList<DeviceCard> devices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices_cards);

        getRoutine();
        dView = (GridView) findViewById(R.id.mainGrid);
        dAdapter = new DeviceCardAdapter(this,devices);
        dView.setAdapter(dAdapter);
    }

    public void getRoutine(){
        devices.add(new DeviceCard("Aire",R.drawable.ac));
        devices.add(new DeviceCard("Horno",R.drawable.oven));
        devices.add(new DeviceCard("Heladera",R.drawable.fridge));
        devices.add(new DeviceCard("Puerta",R.drawable.door_close));
        devices.add(new DeviceCard("Persiana",R.drawable.blind_close));

    }
}
