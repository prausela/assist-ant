package com.assist.home.assisthome;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.assist.home.assisthome.api.API;
import com.assist.home.assisthome.api.Device;
import com.assist.home.assisthome.api.devices.Door;

public class DeviceDoor extends SingleDevice{
    ImageButton open,close,lock,unlocked;
    ImageView doorimg,lockimg;
    //Intent myIntent = getIntent();
    Door d;
    LinearLayout all;
    RelativeLayout loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d = (Door) API.devices.get(this.getIntent().getStringExtra("device"));

        super.setContent(R.layout.activity_device_door,d.name);

        all=(LinearLayout) findViewById(R.id.door_all);
        open=(ImageButton) findViewById(R.id.door_open);
        close=(ImageButton) findViewById(R.id.door_closed);
        lock=(ImageButton) findViewById(R.id.door_locked);
        unlocked=(ImageButton) findViewById(R.id.door_unlocked);

        lockimg=(ImageView) findViewById(R.id.lock);
        doorimg=(ImageView) findViewById(R.id.doorimg);

        open.setOnClickListener(open_Handler);
        close.setOnClickListener(close_Handler);
        lock.setOnClickListener(lock_Handler);
        unlocked.setOnClickListener(unlocked_Handler);
        loading=(RelativeLayout) findViewById(R.id.loadingPanel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        d.refreshState(this);
        updateState();
    }

    public void updateState() {
        if (d.state.get("status").equals("opened")){
            open();
        } else {
            close();
        }
        if (d.state.get("lock").equals("locked")){
            lock();
        } else {
            unlock();
        }
    }
    public void Loading(){
        all.setVisibility(View.GONE);
        loading.setVisibility(View.VISIBLE);

    }

    public void Loaded(){
        all.setVisibility(View.VISIBLE);
        loading.setVisibility(View.GONE);

    }

    public void lock(){
        lock.setBackgroundResource(R.drawable.door_locked1_btn);
        unlocked.setBackgroundResource(R.drawable.door_unlocked_btn);
        lockimg.setImageResource(R.drawable.lock_close);
    }

    public void unlock(){
        lock.setBackgroundResource(R.drawable.door_lock_btn);
        unlocked.setBackgroundResource(R.drawable.door_unlock_btn);
        lockimg.setImageResource(R.drawable.lock_open);
    }

    public void open(){
        open.setBackgroundResource(R.drawable.door_opened_btn);
        close.setBackgroundResource(R.drawable.door_close_btn);
        doorimg.setImageResource(R.drawable.door_open);
    }

    public void close(){
        close.setBackgroundResource(R.drawable.door_clossed_btn);
        open.setBackgroundResource(R.drawable.door_open_btn);
        doorimg.setImageResource(R.drawable.door_close);
    }


    View.OnClickListener open_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            d.switchState(true);
            open();
        }

    };
    View.OnClickListener close_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            d.switchState(false);
            close();
        }

    };
    View.OnClickListener lock_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            d.switchLock(true);
            lock();
        }

    };
    View.OnClickListener unlocked_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            d.switchLock(false);
            unlock();
        }

    };
}
