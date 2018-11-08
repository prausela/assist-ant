package com.assist.home.assisthome;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class DeviceAC extends AppCompatActivity {

    ImageButton ac_power;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_ac);
        ac_power = (ImageButton) findViewById(R.id.ac_power);
        ac_power.setOnClickListener(ac_power_Handler);
    }
    View.OnClickListener ac_power_Handler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ("ac_power_on".equals(ac_power.getTag())) {
                ac_power.setBackgroundResource(R.drawable.ac_power_off);
                ac_power.setTag("ac_power_off");
            }
            else {
                ac_power.setBackgroundResource(R.drawable.ac_power_on);
                ac_power.setTag("ac_power_on");
            }
        }
    };

}
