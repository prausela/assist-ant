package com.assist.home.assisthome.notifications;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;

import com.assist.home.assisthome.AppActivity;
import com.assist.home.assisthome.DeviceActivity;
import com.assist.home.assisthome.R;
import com.assist.home.assisthome.api.API;

public class AlarmNotificationReceiver extends BroadcastReceiver {
    //Snackbar connecting;
    @Override
    public void onReceive(Context context, Intent intent) {
//        Log.d("Shipu ALARM", "Received alarm! " + this.getClass().toString());

        //DrawerLayout drawerLayout = (DrawerLayout) ((AppActivity)context).getWindow().findViewById(R.id.drawer_layout);
        API.getInstance().checkEvents();
    }
}
