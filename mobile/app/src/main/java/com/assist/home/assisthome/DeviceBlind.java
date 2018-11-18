package com.assist.home.assisthome;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.assist.home.assisthome.api.API;
import com.assist.home.assisthome.api.Device;

public class DeviceBlind extends AppActivity {
    TextView state;
    Button up, down;
    ImageView img;
    Intent myIntent = getIntent();
    Device d;
    LinearLayout blind_all;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d = API.devices.get(this.getIntent().getStringExtra("device"));
        super.setContent(R.layout.activity_device_blind,d.name);


        up = (Button) findViewById(R.id.blind_up);
        down=(Button) findViewById(R.id.blind_down);
        state = (TextView) findViewById(R.id.blind_state);
        img=(ImageView) findViewById(R.id.blind_img);
        blind_all=(LinearLayout) findViewById(R.id.blind_all);

        up.setOnClickListener(up_Handler);
        down.setOnClickListener(down_Handler);
    }

    public void Loading(){
        blind_all.setVisibility(View.GONE);
    }

    public void Loaded(){
        blind_all.setVisibility(View.VISIBLE);
    }
    View.OnClickListener up_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            state.setText(getString(R.string.blind_opened));
            img.setImageResource(R.drawable.blind_open);
        }

    };

    View.OnClickListener down_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            state.setText(R.string.blind_closed);
            img.setImageResource(R.drawable.blind_close);
        }

    };
}
