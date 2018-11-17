package com.assist.home.assisthome;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewStubCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DeviceAC extends AppActivity {

    ImageButton ac_power;
    ImageButton ac_mode;
    ImageButton ac_fan_speed_low, ac_fan_speed_mid, ac_fan_speed_high, ac_fan_speed_auto;
    ImageButton ac_mode_heat, ac_mode_cold, ac_mode_auto;
    TextView ac_temp;
    Button ac_temp_up, ac_temp_down;
    LinearLayout ac_modes,ac_temp_displ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContent(R.layout.activity_device_ac,"AC");

        //android.support.v7.widget.GridLayout mainGrid = (android.support.v7.widget.GridLayout) findViewById(R.id.mainGrid);
        ac_power = (ImageButton) findViewById(R.id.ac_power);
        ac_power.setOnClickListener(ac_power_Handler);
        ac_modes=(LinearLayout) findViewById(R.id.ac_modes);
        ac_temp_displ=(LinearLayout) findViewById(R.id.ac_temp_displ);



        ac_temp_up = (Button) findViewById(R.id.ac_temp_up);
        ac_temp_down = (Button) findViewById(R.id.ac_temp_down);
        ac_temp = (TextView) findViewById(R.id.ac_temp);

        ac_temp_up.setOnClickListener(ac_temp_up_Handler);
        ac_temp_down.setOnClickListener(ac_temp_down_Handler);

        ac_fan_speed_low = (ImageButton) findViewById(R.id.ac_fan_speed_low);
        ac_fan_speed_mid = (ImageButton) findViewById(R.id.ac_fan_speed_mid);
        ac_fan_speed_high = (ImageButton) findViewById(R.id.ac_fan_speed_high);
        ac_fan_speed_auto = (ImageButton) findViewById(R.id.ac_fan_speed_auto);

        ac_fan_speed_low.setOnClickListener(ac_fan_speed_low_Handler);
        ac_fan_speed_mid.setOnClickListener(ac_fan_speed_mid_Handler);
        ac_fan_speed_high.setOnClickListener(ac_fan_speed_high_Handler);
        ac_fan_speed_auto.setOnClickListener(ac_fan_speed_auto_Handler);

        ac_mode_heat = (ImageButton) findViewById(R.id.ac_mode_heat);
        ac_mode_cold = (ImageButton) findViewById(R.id.ac_mode_cold);
        ac_mode_auto = (ImageButton) findViewById(R.id.ac_mode_auto);

        ac_mode_heat.setOnClickListener(ac_mode_heat_Handler);
        ac_mode_cold.setOnClickListener(ac_mode_cold_Handler);
        ac_mode_auto.setOnClickListener(ac_mode_auto_Handler);

    }

    View.OnClickListener ac_temp_up_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                int temp = Integer.valueOf(ac_temp.getText().toString());
                ac_temp.setText(Integer.toString(temp + 1));
            }
        }
    };

    View.OnClickListener ac_temp_down_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ("ac_power_on".equals(ac_power.getTag())) {
                int temp = Integer.valueOf(ac_temp.getText().toString());
                ac_temp.setText(Integer.toString(temp - 1));
            }
        }
    };

    View.OnClickListener ac_mode_auto_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                if ("ac_mode_auto_inactive".equals(ac_mode_auto.getTag())) {
                    ac_mode_auto.setBackgroundResource(R.drawable.ac_fan_auto_active);
                    ac_mode_auto.setTag("ac_mode_auto_active");
                    ac_mode_heat.setBackgroundResource(R.drawable.ac_heat_mode_inactive);
                    ac_mode_heat.setTag("ac_mode_heat_inactive");
                    ac_mode_cold.setBackgroundResource(R.drawable.ac_cool_mode_inactive);
                    ac_mode_cold.setTag("ac_mode_cold_inactive");
                }
            }
        }
    };

    View.OnClickListener ac_mode_cold_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                if ("ac_mode_cold_inactive".equals(ac_mode_cold.getTag())) {
                    ac_mode_cold.setBackgroundResource(R.drawable.ac_cool_mode_active);
                    ac_mode_cold.setTag("ac_mode_cold_active");
                    ac_mode_heat.setBackgroundResource(R.drawable.ac_heat_mode_inactive);
                    ac_mode_heat.setTag("ac_mode_heat_inactive");
                    ac_mode_auto.setBackgroundResource(R.drawable.ac_fan_auto_inactive);
                    ac_mode_auto.setTag("ac_mode_auto_inactive");
                }
            }
        }
    };

    View.OnClickListener ac_mode_heat_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                if ("ac_mode_heat_inactive".equals(ac_mode_heat.getTag())) {
                    ac_mode_heat.setBackgroundResource(R.drawable.ac_heat_mode_active);
                    ac_mode_heat.setTag("ac_mode_heat_active");
                    ac_mode_cold.setBackgroundResource(R.drawable.ac_cool_mode_inactive);
                    ac_mode_cold.setTag("ac_mode_cold_inactive");
                    ac_mode_auto.setBackgroundResource(R.drawable.ac_fan_auto_inactive);
                    ac_mode_auto.setTag("ac_mode_auto_inactive");
                }
            }
        }
    };

    View.OnClickListener ac_fan_speed_low_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                if ("ac_fan_speed_low_inactive".equals(ac_fan_speed_low.getTag())) {
                    ac_fan_speed_low.setBackgroundResource(R.drawable.ac_fan_low_active);
                    ac_fan_speed_low.setTag("ac_fan_speed_low_active");
                    ac_fan_speed_mid.setBackgroundResource(R.drawable.ac_fan_mid_inactive);
                    ac_fan_speed_mid.setTag("ac_fan_speed_mid_inactive");
                    ac_fan_speed_high.setBackgroundResource(R.drawable.ac_fan_high_inactive);
                    ac_fan_speed_high.setTag("ac_fan_speed_high_inactive");
                    ac_fan_speed_auto.setBackgroundResource(R.drawable.ac_fan_auto_inactive);
                    ac_fan_speed_auto.setTag("ac_fan_speed_auto_inactive");
                }
            }
        }
    };
    View.OnClickListener ac_fan_speed_mid_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                if ("ac_fan_speed_mid_inactive".equals(ac_fan_speed_mid.getTag())) {
                    ac_fan_speed_mid.setBackgroundResource(R.drawable.ac_fan_mid_active);
                    ac_fan_speed_mid.setTag("ac_fan_speed_mid_active");
                    ac_fan_speed_low.setBackgroundResource(R.drawable.ac_fan_low_inactive);
                    ac_fan_speed_low.setTag("ac_fan_speed_low_inactive");
                    ac_fan_speed_high.setBackgroundResource(R.drawable.ac_fan_high_inactive);
                    ac_fan_speed_high.setTag("ac_fan_speed_high_inactive");
                    ac_fan_speed_auto.setBackgroundResource(R.drawable.ac_fan_auto_inactive);
                    ac_fan_speed_auto.setTag("ac_fan_speed_auto_inactive");

                }
            }
        }
    };
    View.OnClickListener ac_fan_speed_high_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                if ("ac_fan_speed_high_inactive".equals(ac_fan_speed_high.getTag())) {
                    ac_fan_speed_high.setBackgroundResource(R.drawable.ac_fan_high_active);
                    ac_fan_speed_high.setTag("ac_fan_speed_high_active");
                    ac_fan_speed_mid.setBackgroundResource(R.drawable.ac_fan_mid_inactive);
                    ac_fan_speed_mid.setTag("ac_fan_speed_mid_inactive");
                    ac_fan_speed_low.setBackgroundResource(R.drawable.ac_fan_low_inactive);
                    ac_fan_speed_low.setTag("ac_fan_speed_low_inactive");
                    ac_fan_speed_auto.setBackgroundResource(R.drawable.ac_fan_auto_inactive);
                    ac_fan_speed_auto.setTag("ac_fan_speed_auto_inactive");

                }
            }
        }
    };
    View.OnClickListener ac_fan_speed_auto_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ("ac_power_on".equals(ac_power.getTag())) {
                if ("ac_fan_speed_auto_inactive".equals(ac_fan_speed_auto.getTag())) {
                    ac_fan_speed_auto.setBackgroundResource(R.drawable.ac_fan_auto_active);
                    ac_fan_speed_auto.setTag("ac_fan_speed_auto_active");
                    ac_fan_speed_mid.setBackgroundResource(R.drawable.ac_fan_mid_inactive);
                    ac_fan_speed_mid.setTag("ac_fan_speed_mid_inactive");
                    ac_fan_speed_low.setBackgroundResource(R.drawable.ac_fan_low_inactive);
                    ac_fan_speed_low.setTag("ac_fan_speed_low_inactive");
                    ac_fan_speed_high.setBackgroundResource(R.drawable.ac_fan_high_inactive);
                    ac_fan_speed_high.setTag("ac_fan_speed_high_inactive");

                }
            }
        }
    };

    View.OnClickListener ac_power_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ("ac_power_on".equals(ac_power.getTag())) {
                ac_power.setBackgroundResource(R.drawable.ac_power_off);
                ac_power.setTag("ac_power_off");
                ac_temp_displ.setVisibility(View.INVISIBLE);
                ac_modes.setVisibility(View.INVISIBLE);

            } else {
                ac_power.setBackgroundResource(R.drawable.ac_power_on);
                ac_power.setTag("ac_power_on");
                ac_modes.setVisibility(View.VISIBLE);
                ac_temp_displ.setVisibility(View.VISIBLE);

            }
        }
    };


}
