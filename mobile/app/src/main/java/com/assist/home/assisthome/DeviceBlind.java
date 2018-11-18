package com.assist.home.assisthome;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import com.android.volley.RequestQueue;
import com.assist.home.assisthome.api.API;
import com.assist.home.assisthome.api.Device;
import com.assist.home.assisthome.api.devices.Blind;

public class DeviceBlind extends AppActivity {
    TextView state;
    Button up, down;
    ImageView img;
    Blind d;
    Intent myIntent = getIntent();
    LinearLayout blind_all;
    RelativeLayout loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d = (Blind) API.devices.get(this.getIntent().getStringExtra("device"));
        super.setContent(R.layout.activity_device_blind,d.name);

        API.getInstance(this).getRequestQueue();
        loading=(RelativeLayout) findViewById(R.id.loadingPanel);
        up = (Button) findViewById(R.id.blind_up);
        down=(Button) findViewById(R.id.blind_down);
        state = (TextView) findViewById(R.id.blind_state);
        img=(ImageView) findViewById(R.id.blind_img);
        blind_all=(LinearLayout) findViewById(R.id.blind_all);

        up.setOnClickListener(up_Handler);
        down.setOnClickListener(down_Handler);
    }

    public void open(){
        state.setText(getString(R.string.blind_opened));
        img.setImageResource(R.drawable.blind_open);
    }

    public void close(){
        state.setText(R.string.blind_closed);
        img.setImageResource(R.drawable.blind_close);
    }

    View.OnClickListener up_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            d.switchState(true);
            open();
        }

    };

    View.OnClickListener down_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            d.switchState(false);
            close();
        }

    };

    public void Loading(){
        blind_all.setVisibility(View.GONE);
        loading.setVisibility(View.VISIBLE);

    }

    public void Loaded(){
        blind_all.setVisibility(View.VISIBLE);
        loading.setVisibility(View.GONE);

    }

}
