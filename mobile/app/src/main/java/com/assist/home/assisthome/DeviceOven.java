package com.assist.home.assisthome;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DeviceOven extends AppActivity {
    ImageButton h_up, h_down, h_both, g_def, g_eco, g_off, c_auto, c_eco, c_off;
    ImageButton power;
    Button oven_temp_up, oven_temp_down;
    TextView oven_temp;
    LinearLayout oven_modes,oven_temp_disp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContent(R.layout.activity_device_oven,"Horno");

        power = (ImageButton) findViewById(R.id.power);
        power.setOnClickListener(power_Handler);
        oven_temp_up = (Button) findViewById(R.id.oven_temp_up);
        oven_temp_down = (Button) findViewById(R.id.oven_temp_down);
        oven_temp = (TextView) findViewById(R.id.oven_temp);
        oven_modes = (LinearLayout) findViewById(R.id.oven_modes);
        oven_temp_disp = (LinearLayout) findViewById(R.id.oven_temp_displ);


        oven_temp_up.setOnClickListener(oven_temp_up_Handler);
        oven_temp_down.setOnClickListener(oven_temp_down_Handler);

        h_up = (ImageButton) findViewById(R.id.oven_heat_up);
        h_down = (ImageButton) findViewById(R.id.oven_heat_down);
        h_both = (ImageButton) findViewById(R.id.oven_heat_both);

        g_def = (ImageButton) findViewById(R.id.oven_grill_def);
        g_eco = (ImageButton) findViewById(R.id.oven_grill_eco);
        g_off = (ImageButton) findViewById(R.id.oven_grill_off);

        c_auto = (ImageButton) findViewById(R.id.oven_conv_auto);
        c_eco = (ImageButton) findViewById(R.id.oven_conv_eco);
        c_off = (ImageButton) findViewById(R.id.oven_conv_off);

        h_up.setOnClickListener(h_up_Handler);
        h_down.setOnClickListener(h_down_Handler);
        h_both.setOnClickListener(h_both_Handler);
        g_def.setOnClickListener(g_def_Handler);
        g_eco.setOnClickListener(g_eco_Handler);
        g_off.setOnClickListener(g_off_Handler);
        c_auto.setOnClickListener(c_auto_Handler);
        c_eco.setOnClickListener(c_eco_Handler);
        c_off.setOnClickListener(c_off_Handler);

    }

    View.OnClickListener c_off_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ("power_on".equals(power.getTag())) {
                if ("conv_off_inactive".equals(c_off.getTag())) {
                    c_off.setBackgroundResource(R.drawable.oven_grill_off_active);
                    c_off.setTag("conv_off_active");
                    c_auto.setBackgroundResource(R.drawable.ac_fan_auto_inactive);
                    c_auto.setTag("conv_auto_inactive");
                    c_eco.setBackgroundResource(R.drawable.oven_grill_eco_inactive);
                    c_eco.setTag("conv_eco_inactive");
                }
            }
        }
    };

    View.OnClickListener oven_temp_up_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("power_on".equals(power.getTag())) {
                int temp = Integer.valueOf(oven_temp.getText().toString());
                oven_temp.setText(Integer.toString(temp + 1));
            }
        }
    };

    View.OnClickListener oven_temp_down_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ("power_on".equals(power.getTag())) {
                int temp = Integer.valueOf(oven_temp.getText().toString());
                oven_temp.setText(Integer.toString(temp - 1));
            }
        }
    };

    View.OnClickListener c_eco_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ("power_on".equals(power.getTag())) {
                if ("conv_eco_inactive".equals(c_eco.getTag())) {
                    c_eco.setBackgroundResource(R.drawable.oven_grill_eco_active);
                    c_eco.setTag("conv_eco_active");
                    c_auto.setBackgroundResource(R.drawable.ac_fan_auto_inactive);
                    c_auto.setTag("conv_auto_inactive");
                    c_off.setBackgroundResource(R.drawable.oven_grill_off_inactive);
                    c_off.setTag("conv_off_inactive");
                }
            }
        }
    };

    View.OnClickListener c_auto_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ("power_on".equals(power.getTag())) {
                if ("conv_auto_inactive".equals(c_auto.getTag())) {
                    c_auto.setBackgroundResource(R.drawable.ac_fan_auto_active);
                    c_auto.setTag("conv_auto_active");
                    c_eco.setBackgroundResource(R.drawable.oven_grill_eco_inactive);
                    c_eco.setTag("conv_eco_inactive");
                    c_off.setBackgroundResource(R.drawable.oven_grill_off_inactive);
                    c_off.setTag("conv_off_inactive");
                }
            }
        }
    };

    View.OnClickListener g_off_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ("power_on".equals(power.getTag())) {
                if ("grill_off_inactive".equals(g_off.getTag())) {
                    g_off.setBackgroundResource(R.drawable.oven_grill_off_active);
                    g_off.setTag("grill_off_active");
                    g_def.setBackgroundResource(R.drawable.oven_grill_def_inactive);
                    g_def.setTag("grill_def_inactive");
                    g_eco.setBackgroundResource(R.drawable.oven_grill_eco_inactive);
                    g_eco.setTag("grill_eco_inactive");
                }
            }
        }
    };
    View.OnClickListener g_eco_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ("power_on".equals(power.getTag())) {
                if ("grill_eco_inactive".equals(g_eco.getTag())) {
                    g_eco.setBackgroundResource(R.drawable.oven_grill_eco_active);
                    g_eco.setTag("grill_eco_active");
                    g_def.setBackgroundResource(R.drawable.oven_grill_def_inactive);
                    g_def.setTag("grill_def_inactive");
                    g_off.setBackgroundResource(R.drawable.oven_grill_off_inactive);
                    g_off.setTag("grill_off_inactive");
                }
            }
        }
    };
    View.OnClickListener g_def_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ("power_on".equals(power.getTag())) {
                if ("grill_def_inactive".equals(g_def.getTag())) {
                    g_def.setBackgroundResource(R.drawable.oven_grill_def_active);
                    g_def.setTag("grill_def_active");
                    g_eco.setBackgroundResource(R.drawable.oven_grill_eco_inactive);
                    g_eco.setTag("grill_eco_inactive");
                    g_off.setBackgroundResource(R.drawable.oven_grill_off_inactive);
                    g_off.setTag("grill_off_inactive");
                }
            }
        }
    };

    View.OnClickListener h_both_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ("power_on".equals(power.getTag())) {
                if ("heat_both_inactive".equals(h_both.getTag())) {
                    h_both.setBackgroundResource(R.drawable.oven_heat_both_active);
                    h_both.setTag("heat_both_active");
                    h_up.setBackgroundResource(R.drawable.oven_heat_up);
                    h_up.setTag("heat_up_inactive");
                    h_down.setBackgroundResource(R.drawable.oven_heat_down);
                    h_down.setTag("heat_down_inactive");
                }
            }
        }
    };
    View.OnClickListener h_down_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ("power_on".equals(power.getTag())) {
                if ("heat_down_inactive".equals(h_down.getTag())) {
                    h_down.setBackgroundResource(R.drawable.oven_heat_down_active);
                    h_down.setTag("heat_down_active");
                    h_up.setBackgroundResource(R.drawable.oven_heat_up);
                    h_up.setTag("heat_up_inactive");
                    h_both.setBackgroundResource(R.drawable.oven_heat_both);
                    h_both.setTag("heat_both_inactive");
                }
            }
        }
    };

    View.OnClickListener h_up_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ("power_on".equals(power.getTag())) {
                if ("heat_up_inactive".equals(h_up.getTag())) {
                    h_up.setBackgroundResource(R.drawable.oven_heat_up_active);
                    h_up.setTag("heat_up_active");
                    h_down.setBackgroundResource(R.drawable.oven_heat_down);
                    h_down.setTag("heat_down_inactive");
                    h_both.setBackgroundResource(R.drawable.oven_heat_both);
                    h_both.setTag("heat_both_inactive");
                }
            }
        }
    };

    View.OnClickListener power_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ("power_on".equals(power.getTag())) {
                power.setBackgroundResource(R.drawable.ac_power_off);
                power.setTag("power_off");
                oven_modes.setVisibility(View.INVISIBLE);
                oven_temp_disp.setVisibility(View.INVISIBLE);

            } else {
                power.setBackgroundResource(R.drawable.ac_power_on);
                power.setTag("power_on");
                oven_modes.setVisibility(View.VISIBLE);
                oven_temp_disp.setVisibility(View.VISIBLE);
            }
        }
    };


}
