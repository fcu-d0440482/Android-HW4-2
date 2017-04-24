package com.example.user.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    static int id = 70000;
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("KEY_MSG");

        Intent newintent = new Intent();
        newintent.setClass(context, MainActivity.class);
        newintent.putExtra("KEY_MSG", msg);

        PendingIntent pi = PendingIntent.getActivity(context, 0, newintent, 0);

        Notification.Builder builder = new Notification.Builder(context);

        builder.setContentTitle("HELLO");
        builder.setContentText(msg);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pi);
        builder.setTicker(msg);
        builder.setWhen(System.currentTimeMillis());
        Notification notify = builder.build();

        NotificationManager notificationManager = (NotificationManager) context.
                getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(id++, notify);

    }

}
