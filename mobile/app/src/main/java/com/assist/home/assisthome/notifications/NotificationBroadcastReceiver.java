package com.assist.home.assisthome.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;

import com.assist.home.assisthome.AppActivity;
import com.assist.home.assisthome.DeviceActivity;
import com.assist.home.assisthome.R;

public class NotificationBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        notify();
    }

    public void sendNotification(Context context, Intent intent, String title) {

        String chid = "mychannel";
        CharSequence name = "chname";
        String description = "chdesc";
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= 24) {
            int importance = NotificationManager.IMPORTANCE_LOW;
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel ch = new NotificationChannel(chid, name, importance);
                ch.setDescription(description);
                ch.enableLights(true);
                ch.setLightColor(Color.RED);
                ch.enableVibration(true);
                ch.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                nm.createNotificationChannel(ch);
            }
        }


        Intent notificationIntent = intent;
        TaskStackBuilder sb = TaskStackBuilder.create(context);
        Intent prevIntent = new Intent(context, DeviceActivity.class);
        sb.addParentStack(DeviceActivity.class);
        sb.addNextIntent(prevIntent);
        sb.addNextIntent(notificationIntent);
        final PendingIntent contentIntent = sb.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        int messageId = 1;
        Notification.Builder nb = new Notification.Builder(context)
                .setContentTitle(title)
                .setContentText("")
                .setSmallIcon(R.drawable.logo1)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.drawable.logo1))
                .setAutoCancel(true)
                .setContentIntent(contentIntent);
        if (Build.VERSION.SDK_INT >= 26){
            nb.setChannelId(chid);
        }
        Notification n = nb.build();
        nm.notify(messageId, n);
    }
}
