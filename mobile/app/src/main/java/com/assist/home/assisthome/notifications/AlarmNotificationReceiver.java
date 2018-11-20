package com.assist.home.assisthome.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.assist.home.assisthome.AppActivity;
import com.assist.home.assisthome.api.API;

public class AlarmNotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        Log.d("Shipu ALARM", "Received alarm! " + this.getClass().toString());
        API.getInstance().checkEvents();
    }
}
