package com.assist.home.assisthome;

import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ResourceCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;


public class Settings extends AppActivity   {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_devices_cards);
        super.setContent(R.layout.activity_settings,getString(R.string.settings));
        CheckedTextView language= (CheckedTextView) findViewById(R.id.language);

       String lang=Locale.getDefault().getLanguage();
       if(lang.equals("en"))
       {
           language.setText("English");
       }
       else {
           language.setText("Espanol");
       }

    }


    public void notificationStatus(View view) {

        // Is the button now checked?

        boolean checked = ((RadioButton) view).isChecked();

        // hacemos un case con lo que ocurre cada vez que pulsemos un botón

        switch (view.getId()) {
            case R.id.active_notifications:
                if (checked)
                    Toast.makeText(Settings.this, getString(R.string.notifications)+" "+getString(R.string.checkbox_active), Toast.LENGTH_SHORT).show();

                break;
            case R.id.inactive_notifications:
                if (checked) {
                    Toast.makeText(Settings.this, getString(R.string.notifications)+ " "+getString(R.string.checkbox_inactive), Toast.LENGTH_SHORT).show();

                }
        }
    }



}

