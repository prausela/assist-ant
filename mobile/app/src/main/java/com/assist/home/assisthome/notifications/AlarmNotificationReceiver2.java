package com.assist.home.assisthome.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmNotificationReceiver2 extends AlarmNotificationReceiver {
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context,intent);
//        Log.d("Shipu ALARM", "Received alarm! " + this.getClass().toString());
        NotificationChecker.checkIn40();
    }
}
