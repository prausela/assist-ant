package com.assist.home.assisthome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class RoutineInnerActivity  extends AppActivity {

    private GridView dView;
    private DeviceCardAdapter dAdapter;
    ArrayList<DeviceCard> devices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_devices_cards);
        super.setContent(R.layout.activity_devices_cards,"Rutina");


        getRoutine();
        dView = (GridView) findViewById(R.id.mainGrid);
        dAdapter = new DeviceCardAdapter(this, devices);
        dView.setAdapter(dAdapter);

        dView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                Toast.makeText(RoutineInnerActivity.this, "Cliked at " + dAdapter.getItem(position).DeviceName, Toast.LENGTH_SHORT).show();
                String name = dAdapter.getItem(position).DeviceName;
                if (name.equals("Aire")) {
                    Intent intent = new Intent(RoutineInnerActivity.this, DeviceAC.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                    startActivity(intent);
                } else if (name.equals("Heladera")) {
                    Intent intent = new Intent(RoutineInnerActivity.this, DeviceFridge.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                    startActivity(intent);
                } else if (name.equals("Horno")) {
                    Intent intent = new Intent(RoutineInnerActivity.this, DeviceOven.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                    startActivity(intent);
                } else if (name.equals("Persiana")) {
                    Intent intent = new Intent(RoutineInnerActivity.this, DeviceBlind.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                    startActivity(intent);
                } else if (name.equals("Puerta")) {
                    Intent intent = new Intent(RoutineInnerActivity.this, DeviceDoor.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                    startActivity(intent);
                }

            }
        });
    }

    public void getRoutine() {
//        devices.add(new DeviceCard("Aire", R.drawable.ac));
//        devices.add(new DeviceCard("Horno", R.drawable.oven));
//        devices.add(new DeviceCard("Heladera", R.drawable.fridge));
//        devices.add(new DeviceCard("Puerta", R.drawable.door_close));
//        devices.add(new DeviceCard("Persiana", R.drawable.blind_close));
//        devices.add(new DeviceCard("Persiana", R.drawable.blind_close));
//        devices.add(new DeviceCard("Persiana", R.drawable.blind_close));


    }
}


