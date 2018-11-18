package com.assist.home.assisthome;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.assist.home.assisthome.api.API;
import com.assist.home.assisthome.api.Device;

public class DeviceDoor extends AppActivity{
    ImageButton open,close,lock,unlocked;
    ImageView doorimg,lockimg;
    //Intent myIntent = getIntent();
    Device d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d = API.devices.get(this.getIntent().getStringExtra("device"));

        super.setContent(R.layout.activity_device_door,d.name);

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

    }

    View.OnClickListener open_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            open.setBackgroundResource(R.drawable.door_opened_btn);
            close.setBackgroundResource(R.drawable.door_close_btn);
            doorimg.setImageResource(R.drawable.door_open);
        }

    };
    View.OnClickListener close_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            close.setBackgroundResource(R.drawable.door_clossed_btn);
            open.setBackgroundResource(R.drawable.door_open_btn);
            doorimg.setImageResource(R.drawable.door_close);
        }

    };
    View.OnClickListener lock_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            lock.setBackgroundResource(R.drawable.door_locked1_btn);
            unlocked.setBackgroundResource(R.drawable.door_unlocked_btn);
            lockimg.setImageResource(R.drawable.lock_close);
        }

    };
    View.OnClickListener unlocked_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            lock.setBackgroundResource(R.drawable.door_lock_btn);
            unlocked.setBackgroundResource(R.drawable.door_unlock_btn);
            lockimg.setImageResource(R.drawable.lock_open);
        }

    };
}
