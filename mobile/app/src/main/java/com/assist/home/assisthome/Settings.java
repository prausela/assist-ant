package com.assist.home.assisthome;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Settings extends AppActivity implements AdapterView.OnItemSelectedListener  {
    CheckBox active,inactive;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_devices_cards);
        super.setContent(R.layout.activity_settings,getString(R.string.settings));

        Spinner spinner=findViewById(R.id.spinner_language);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.languageOp,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void notificationStatus(View view) {

        // Is the button now checked?

        boolean checked = ((RadioButton) view).isChecked();

        // hacemos un case con lo que ocurre cada vez que pulsemos un botón

        switch (view.getId()) {
            case R.id.active_notifications:
                if (checked)
                    Toast.makeText(Settings.this, getString(R.string.checkbox_active), Toast.LENGTH_SHORT).show();

                break;
            case R.id.inactive_notifications:
                if (checked) {
                    Toast.makeText(Settings.this, getString(R.string.checkbox_inactive), Toast.LENGTH_SHORT).show();

                }
        }
    }

}

