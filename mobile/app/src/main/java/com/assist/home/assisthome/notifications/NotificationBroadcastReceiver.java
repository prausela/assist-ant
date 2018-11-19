package com.assist.home.assisthome.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;

import com.assist.home.assisthome.R;

public class NotificationBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        notify();
    }

    public void sendNotification(Context context, Intent intent) {


        int messageId = 4;
        Notification n = new Notification.Builder(context)
                .setContentTitle("Hola")
                .setContentText("Chau")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher))
                .setAutoCancel(true)
                .build();
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(messageId, n);
    }
}
