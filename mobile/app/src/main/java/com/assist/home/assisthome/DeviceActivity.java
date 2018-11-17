package com.assist.home.assisthome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ViewStubCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DeviceActivity extends AppActivity {
    private GridView dView;
    private DeviceCardAdapter dAdapter;
    ArrayList<DeviceCard> devices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_devices_cards);
        super.setContent(R.layout.activity_devices_cards,getString(R.string.devices_title));

        getDevices();
        dView = (GridView) findViewById(R.id.mainGrid);
        dAdapter = new DeviceCardAdapter(this,devices);
        dView.setAdapter(dAdapter);

        dView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                Toast.makeText(DeviceActivity.this, "Cliked at " + dAdapter.getItem(position).DeviceName, Toast.LENGTH_SHORT).show();
                String name=dAdapter.getItem(position).DeviceName;
                if(name.equals(getString(R.string.ac_title_short))){
                    Intent intent = new Intent(DeviceActivity.this,DeviceAC.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                    startActivity(intent);
                }
                else if(name.equals(getString(R.string.refrigerator_title))){
                    Intent intent = new Intent(DeviceActivity.this,DeviceFridge.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                    startActivity(intent);
                }
                else if(name.equals(getString(R.string.oven_title))){
                    Intent intent = new Intent(DeviceActivity.this,DeviceOven.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                    startActivity(intent);
                }
                else if(name.equals(getString(R.string.blind_title))){
                    Intent intent = new Intent(DeviceActivity.this,DeviceBlind.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                    startActivity(intent);
                }
                else if(name.equals(getString(R.string.door_title))){
                    Intent intent = new Intent(DeviceActivity.this,DeviceDoor.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                    startActivity(intent);
                }

                }
        });
    }

    public void getDevices(){
        devices.add(new DeviceCard(getString(R.string.ac_title_short), R.drawable.ac));
        devices.add(new DeviceCard(getString(R.string.oven_title), R.drawable.oven));
        devices.add(new DeviceCard(getString(R.string.refrigerator_title), R.drawable.fridge));
        devices.add(new DeviceCard(getString(R.string.door_title),R.drawable.door_close));
        devices.add(new DeviceCard(getString(R.string.blind_title),R.drawable.blind_close));
        devices.add(new DeviceCard(getString(R.string.blind_title),R.drawable.blind_close));
        devices.add(new DeviceCard(getString(R.string.blind_title),R.drawable.blind_close));


    }
}
