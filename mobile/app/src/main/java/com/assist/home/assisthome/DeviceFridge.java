package com.assist.home.assisthome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.assist.home.assisthome.api.API;
import com.assist.home.assisthome.api.Device;

public class DeviceFridge extends AppActivity {
    ImageButton def, party, trip;
    TextView f_temp, r_temp;
    Button f_temp_up, f_temp_down, r_temp_up, r_temp_down;
    Intent myIntent = getIntent();
    Device d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d = API.devices.get(this.getIntent().getStringExtra("device"));

        super.setContent(R.layout.activity_device_fridge,d.name);

        f_temp_up = (Button) findViewById(R.id.fridge_temp_up);
        f_temp_down = (Button) findViewById(R.id.fridge_temp_down);
        f_temp = (TextView) findViewById(R.id.fridge_temp);
        r_temp_up = (Button) findViewById(R.id.refri_temp_up);
        r_temp_down = (Button) findViewById(R.id.refri_temp_down);
        r_temp = (TextView) findViewById(R.id.refri_temp);

        f_temp_up.setOnClickListener(f_temp_up_Handler);
        f_temp_down.setOnClickListener(f_temp_down_Handler);
        r_temp_up.setOnClickListener(r_temp_up_Handler);
        r_temp_down.setOnClickListener(r_temp_down_Handler);

        def = (ImageButton) findViewById(R.id.fridge_def);
        party = (ImageButton) findViewById(R.id.fridge_party);
        trip = (ImageButton) findViewById(R.id.fridge_trip);

        def.setOnClickListener(def_Handler);
        party.setOnClickListener(party_Handler);
        trip.setOnClickListener(trip_Handler);

    }

    View.OnClickListener def_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if ("fridge_def_inactive".equals(def.getTag())) {
                def.setBackgroundResource(R.drawable.fridge_def_active);
                def.setTag("fridge_def_active");
                party.setBackgroundResource(R.drawable.fridge_party_inactive);
                party.setTag("fridge_party_inactive");
                trip.setBackgroundResource(R.drawable.fridge_trip_inactive);
                trip.setTag("fridge_trip_inactive");
            }
        }

    };

    View.OnClickListener party_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if ("fridge_party_inactive".equals(party.getTag())) {
                party.setBackgroundResource(R.drawable.fridge_party_active);
                party.setTag("fridge_def_active");
                def.setBackgroundResource(R.drawable.fridge_def_inactive);
                def.setTag("fridge_def_inactive");
                trip.setBackgroundResource(R.drawable.fridge_trip_inactive);
                trip.setTag("fridge_trip_inactive");
            }
        }

    };
    View.OnClickListener trip_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if ("fridge_trip_inactive".equals(trip.getTag())) {
                trip.setBackgroundResource(R.drawable.fridge_trip_active);
                trip.setTag("fridge_trip_active");
                party.setBackgroundResource(R.drawable.fridge_party_inactive);
                party.setTag("fridge_party_inactive");
                def.setBackgroundResource(R.drawable.fridge_def_inactive);
                def.setTag("fridge_def_inactive");
            }
        }

    };

    View.OnClickListener f_temp_up_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int tempF = Integer.valueOf(f_temp.getText().toString());
            if(tempF<-8) {
                f_temp.setText(Integer.toString(tempF + 1));
            }
        }
    };

    View.OnClickListener f_temp_down_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int tempF = Integer.valueOf(f_temp.getText().toString());
            if(tempF>-20) {
                f_temp.setText(Integer.toString(tempF - 1));
            }
        }
    };

    View.OnClickListener r_temp_down_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int tempR = Integer.valueOf(r_temp.getText().toString());
            if(tempR>2) {
                r_temp.setText(Integer.toString(tempR - 1));
            }
        }
    };
    View.OnClickListener r_temp_up_Handler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int tempR = Integer.valueOf(r_temp.getText().toString());
            if(tempR<8) {
                r_temp.setText(Integer.toString(tempR + 1));
            }
        }
    };


}
