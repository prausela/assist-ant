package com.assist.home.assisthome.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmNotificationReceiver4 extends AlarmNotificationReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Shipu ALARM", "Received alarm! " + this.getClass().toString());
        NotificationChecker.checkIn20();
    }
}
