package com.assist.home.assisthome;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DeviceBlind extends AppActivity {
    TextView state;
    Button up, down;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_blind);

        up = (Button) findViewById(R.id.blind_up);
        down=(Button) findViewById(R.id.blind_down);
        state = (TextView) findViewById(R.id.blind_state);
        img=(ImageView) findViewById(R.id.blind_img);

        up.setOnClickListener(up_Handler);
        down.setOnClickListener(down_Handler);
    }

    View.OnClickListener up_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            state.setText("Abierto");
            img.setImageResource(R.drawable.blind_open);
        }

    };

    View.OnClickListener down_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            state.setText("Cerrado");
            img.setImageResource(R.drawable.blind_close);
        }

    };
}
