package com.assist.home.assisthome.notifications;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class NotificationChecker {
    private static AlarmManager am;
    private static PendingIntent alarmPendingIntent;
    private static final int INTERVAL = 5000;
    public final static String TAG = "ALARM";
    public static Context actx;


    public static void init(Context context) {
        actx = context;
        am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent int4 = new Intent(context, AlarmNotificationReceiver4.class);
        PendingIntent pi2 = PendingIntent.getBroadcast(context, 0,int4,0);

        am.cancel(pi2);
        Long minute = (long) 60000;
        am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 10000,minute, pi2);
        Log.d("Shipu", "Starting alarm...");
    }

    public static void checkIn20() {

        Intent intent = new Intent(actx, AlarmNotificationReceiver2.class);
        PendingIntent pi = PendingIntent.getBroadcast(actx, 0, intent, 0);
        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 20000, pi);
    }

    public static void checkIn40() {
        Intent intent = new Intent(actx, AlarmNotificationReceiver3.class);
        PendingIntent pi = PendingIntent.getBroadcast(actx, 0,intent,0);
        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 20000, pi);
    }
}
