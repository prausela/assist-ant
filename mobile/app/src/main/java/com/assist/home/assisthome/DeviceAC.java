package com.assist.home.assisthome;

import android.content.Intent;
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

import com.assist.home.assisthome.api.API;
import com.assist.home.assisthome.api.Device;

public class DeviceAC extends AppActivity{

    ImageButton ac_power;
    ImageButton ac_mode;
    ImageButton ac_fan_speed_low, ac_fan_speed_mid, ac_fan_speed_high, ac_fan_speed_auto;
    ImageButton ac_mode_heat, ac_mode_cold, ac_mode_auto;
    ImageButton ac_sh_45,ac_sh_90,ac_sh45,ac_sh90,ac_sh0,ac_shauto;
    ImageButton ac_svauto,ac_sv22,ac_sv45,ac_sv67,ac_sv90;
    TextView ac_temp;
    Button ac_temp_up, ac_temp_down;
    LinearLayout ac_modes,ac_temp_displ;
    Intent myIntent = getIntent();
    Device  d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d = API.devices.get(this.getIntent().getStringExtra("device"));
        super.setContent(R.layout.activity_device_ac, d.name);

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

        ac_sh_90=(ImageButton) findViewById(R.id.ac_sh_90);
        ac_sh_90.setOnClickListener(ac_sh_90_Handler);
        ac_sh_45=(ImageButton) findViewById(R.id.ac_sh_45);
        ac_sh_45.setOnClickListener(ac_sh_45_Handler);
        ac_sh0=(ImageButton) findViewById(R.id.ac_sh0);
        ac_sh0.setOnClickListener(ac_sh0_Handler);

        ac_sh45=(ImageButton) findViewById(R.id.ac_sh45);
        ac_sh45.setOnClickListener(ac_sh45_Handler);

        ac_sh90=(ImageButton) findViewById(R.id.ac_sh90);
        ac_sh90.setOnClickListener(ac_sh90_Handler);

        ac_shauto=(ImageButton) findViewById(R.id.ac_shauto);
        ac_shauto.setOnClickListener(ac_shauto_Handler);

        ac_svauto=(ImageButton) findViewById(R.id.ac_svauto);
        ac_svauto.setOnClickListener(ac_svauto_Handler);

        ac_sv22=(ImageButton) findViewById(R.id.ac_sv1);
        ac_sv22.setOnClickListener(ac_sv22_Handler);

        ac_sv45=(ImageButton) findViewById(R.id.ac_sv2);
        ac_sv45.setOnClickListener(ac_sv45_Handler);

        ac_sv67=(ImageButton) findViewById(R.id.ac_sv3);
        ac_sv67.setOnClickListener(ac_sv67_Handler);

        ac_sv90=(ImageButton) findViewById(R.id.ac_sv4);
        ac_sv90.setOnClickListener(ac_sv90_Handler);



    }
    View.OnClickListener ac_sv90_Handler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                if ("ac_sv90_inactive".equals(ac_sv90.getTag())) {
                    ac_svauto.setBackgroundResource(R.drawable.ac_swingauto_inactive);
                    ac_svauto.setTag("ac_svauto_inactive");
                    ac_sv22.setBackgroundResource(R.drawable.ac_swing1_inactive);
                    ac_sv22.setTag("ac_sv22_inactive");
                    ac_sv45.setBackgroundResource(R.drawable.ac_swing2_inactive);
                    ac_sv45.setTag("ac_sv45_inactive");
                    ac_sv67.setBackgroundResource(R.drawable.ac_swing3_inactive);
                    ac_sv67.setTag("ac_sv67_inactive");
                    ac_sv90.setBackgroundResource(R.drawable.ac_swing4_active);
                    ac_sv90.setTag("ac_sv90_active");
                }
            }
        }
    };
    View.OnClickListener ac_sv67_Handler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                if ("ac_sv67_inactive".equals(ac_sv67.getTag())) {
                    ac_svauto.setBackgroundResource(R.drawable.ac_swingauto_inactive);
                    ac_svauto.setTag("ac_svauto_inactive");
                    ac_sv22.setBackgroundResource(R.drawable.ac_swing1_inactive);
                    ac_sv22.setTag("ac_sv22_inactive");
                    ac_sv45.setBackgroundResource(R.drawable.ac_swing2_inactive);
                    ac_sv45.setTag("ac_sv45_inactive");

                    ac_sv67.setBackgroundResource(R.drawable.ac_swing3_active);
                    ac_sv67.setTag("ac_sv67_active");
                    ac_sv90.setBackgroundResource(R.drawable.ac_swing4_inactive);
                    ac_sv90.setTag("ac_sv90_inactive");
                }
            }
        }
    };
    View.OnClickListener ac_sv45_Handler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                if ("ac_sv45_inactive".equals(ac_sv45.getTag())) {
                    ac_svauto.setBackgroundResource(R.drawable.ac_swingauto_inactive);
                    ac_svauto.setTag("ac_svauto_inactive");
                    ac_sv22.setBackgroundResource(R.drawable.ac_swing1_inactive);
                    ac_sv22.setTag("ac_sv22_inactive");
                    ac_sv45.setBackgroundResource(R.drawable.ac_swing2_active);
                    ac_sv45.setTag("ac_sv45_active");

                    ac_sv67.setBackgroundResource(R.drawable.ac_swing3_inactive);
                    ac_sv67.setTag("ac_sv67_inactive");
                    ac_sv90.setBackgroundResource(R.drawable.ac_swing4_inactive);
                    ac_sv90.setTag("ac_sv90_inactive");
                }
            }
        }
    };
    View.OnClickListener ac_sv22_Handler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                if ("ac_svauto_inactive".equals(ac_svauto.getTag())) {
                    ac_svauto.setBackgroundResource(R.drawable.ac_swingauto_inactive);
                    ac_svauto.setTag("ac_svauto_inactive");
                    ac_sv22.setBackgroundResource(R.drawable.ac_swing1_active);
                    ac_sv22.setTag("ac_sv22_active");
                    ac_sv45.setBackgroundResource(R.drawable.ac_swing2_inactive);
                    ac_sv45.setTag("ac_sv45_inactive");

                    ac_sv67.setBackgroundResource(R.drawable.ac_swing3_inactive);
                    ac_sv67.setTag("ac_sv67_inactive");
                    ac_sv90.setBackgroundResource(R.drawable.ac_swing4_inactive);
                    ac_sv90.setTag("ac_sv90_inactive");
                }
            }
        }
    };
    View.OnClickListener ac_svauto_Handler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                if ("ac_svauto_inactive".equals(ac_svauto.getTag())) {
                    ac_svauto.setBackgroundResource(R.drawable.ac_swingauto_active);
                    ac_svauto.setTag("ac_svauto_active");
                    ac_sv22.setBackgroundResource(R.drawable.ac_swing1_inactive);
                    ac_sv22.setTag("ac_sv22_inactive");
                    ac_sv45.setBackgroundResource(R.drawable.ac_swing2_inactive);
                    ac_sv45.setTag("ac_sv45_inactive");

                    ac_sv67.setBackgroundResource(R.drawable.ac_swing3_inactive);
                    ac_sv67.setTag("ac_sv67_inactive");
                    ac_sv90.setBackgroundResource(R.drawable.ac_swing4_inactive);
                    ac_sv90.setTag("ac_sv90_inactive");
                }
            }
        }
    };

    View.OnClickListener ac_shauto_Handler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                if ("ac_shauto_inactive".equals(ac_shauto.getTag())) {
                    ac_shauto.setBackgroundResource(R.drawable.ac_fan_auto_active);
                    ac_shauto.setTag("ac_shauto_active");
                    ac_sh_90.setBackgroundResource(R.drawable.ac_sh_90_inactive);
                    ac_sh_90.setTag("ac_sh_90_inactive");
                    ac_sh_45.setBackgroundResource(R.drawable.ac_sh_45_inactive);
                    ac_sh_45.setTag("ac_sh_45_inactive");
                    ac_sh0.setBackgroundResource(R.drawable.ac_sh0_inactive);
                    ac_sh0.setTag("ac_sh0_inactive");
                    ac_sh90.setBackgroundResource(R.drawable.ac_sh90_inactive);
                    ac_sh90.setTag("ac_sh90_inactive");
                    ac_sh45.setBackgroundResource(R.drawable.ac_sh45_inactive);
                    ac_sh45.setTag("ac_sh45_inactive");
                }
            }
        }
    };
    View.OnClickListener ac_sh_90_Handler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                if ("ac_sh_90_inactive".equals(ac_sh_90.getTag())) {
                    ac_shauto.setBackgroundResource(R.drawable.ac_fan_auto_inactive);
                    ac_shauto.setTag("ac_shauto_inactive");
                    ac_sh_90.setBackgroundResource(R.drawable.ac_sh_90_active);
                    ac_sh_90.setTag("ac_sh_90_active");
                    ac_sh_45.setBackgroundResource(R.drawable.ac_sh_45_inactive);
                    ac_sh_45.setTag("ac_sh_45_inactive");
                    ac_sh0.setBackgroundResource(R.drawable.ac_sh0_inactive);
                    ac_sh0.setTag("ac_sh0_inactive");
                    ac_sh90.setBackgroundResource(R.drawable.ac_sh90_inactive);
                    ac_sh90.setTag("ac_sh90_inactive");
                    ac_sh45.setBackgroundResource(R.drawable.ac_sh45_inactive);
                    ac_sh45.setTag("ac_sh45_inactive");
                }
            }
        }
    };
    View.OnClickListener ac_sh0_Handler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                if ("ac_sh0_inactive".equals(ac_sh0.getTag())) {
                    ac_shauto.setBackgroundResource(R.drawable.ac_fan_auto_inactive);
                    ac_shauto.setTag("ac_shauto_inactive");
                    ac_sh_90.setBackgroundResource(R.drawable.ac_sh_90_inactive);
                    ac_sh_90.setTag("ac_sh_90_inactive");
                    ac_sh_45.setBackgroundResource(R.drawable.ac_sh_45_inactive);
                    ac_sh_45.setTag("ac_sh_45_inactive");
                    ac_sh0.setBackgroundResource(R.drawable.ac_sh0_active);
                    ac_sh0.setTag("ac_sh0_active");
                    ac_sh90.setBackgroundResource(R.drawable.ac_sh90_inactive);
                    ac_sh90.setTag("ac_sh90_inactive");
                    ac_sh45.setBackgroundResource(R.drawable.ac_sh45_inactive);
                    ac_sh45.setTag("ac_sh45_inactive");
                }
            }
        }
    };
    View.OnClickListener ac_sh_45_Handler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                if ("ac_sh_45_inactive".equals(ac_sh_45.getTag())) {
                    ac_shauto.setBackgroundResource(R.drawable.ac_fan_auto_inactive);
                    ac_shauto.setTag("ac_shauto_inactive");
                    ac_sh_90.setBackgroundResource(R.drawable.ac_sh_90_inactive);
                    ac_sh_90.setTag("ac_sh_90_inactive");
                    ac_sh_45.setBackgroundResource(R.drawable.ac_sh_45_active);
                    ac_sh_45.setTag("ac_sh_45_active");
                    ac_sh0.setBackgroundResource(R.drawable.ac_sh0_inactive);
                    ac_sh0.setTag("ac_sh0_inactive");
                    ac_sh90.setBackgroundResource(R.drawable.ac_sh90_inactive);
                    ac_sh90.setTag("ac_sh90_inactive");
                    ac_sh45.setBackgroundResource(R.drawable.ac_sh45_inactive);
                    ac_sh45.setTag("ac_sh45_inactive");
                }
            }
        }
    };
    View.OnClickListener ac_sh45_Handler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                if ("ac_sh45_inactive".equals(ac_sh45.getTag())) {
                    ac_shauto.setBackgroundResource(R.drawable.ac_fan_auto_inactive);
                    ac_shauto.setTag("ac_shauto_inactive");
                    ac_sh_90.setBackgroundResource(R.drawable.ac_sh_90_inactive);
                    ac_sh_90.setTag("ac_sh_90_inactive");
                    ac_sh_45.setBackgroundResource(R.drawable.ac_sh_45_inactive);
                    ac_sh_45.setTag("ac_sh_45_inactive");
                    ac_sh0.setBackgroundResource(R.drawable.ac_sh0_inactive);
                    ac_sh0.setTag("ac_sh0_inactive");
                    ac_sh90.setBackgroundResource(R.drawable.ac_sh90_inactive);
                    ac_sh90.setTag("ac_sh90_inactive");
                    ac_sh45.setBackgroundResource(R.drawable.ac_sh45_active);
                    ac_sh45.setTag("ac_sh45_active");
                }
            }
        }
    };
    View.OnClickListener ac_sh90_Handler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                if ("ac_sh90_inactive".equals(ac_sh90.getTag())) {
                    ac_shauto.setBackgroundResource(R.drawable.ac_fan_auto_inactive);
                    ac_shauto.setTag("ac_shauto_inactive");
                    ac_sh_90.setBackgroundResource(R.drawable.ac_sh_90_inactive);
                    ac_sh_90.setTag("ac_sh_90_inactive");
                    ac_sh_45.setBackgroundResource(R.drawable.ac_sh_45_inactive);
                    ac_sh_45.setTag("ac_sh_45_inactive");
                    ac_sh0.setBackgroundResource(R.drawable.ac_sh0_inactive);
                    ac_sh0.setTag("ac_sh0_inactive");
                    ac_sh90.setBackgroundResource(R.drawable.ac_sh90_active);
                    ac_sh90.setTag("ac_sh90_active");
                    ac_sh45.setBackgroundResource(R.drawable.ac_sh45_inactive);
                    ac_sh45.setTag("ac_sh45_inactive");
                }
            }
        }
    };





    View.OnClickListener ac_temp_up_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if("ac_power_on".equals(ac_power.getTag())) {
                int temp = Integer.valueOf(ac_temp.getText().toString());
                if(temp<38) {
                    ac_temp.setText(Integer.toString(temp + 1));
                }
            }
        }
    };

    View.OnClickListener ac_temp_down_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ("ac_power_on".equals(ac_power.getTag())) {
                int temp = Integer.valueOf(ac_temp.getText().toString());
                if(temp>18) {
                    ac_temp.setText(Integer.toString(temp - 1));
                }
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
