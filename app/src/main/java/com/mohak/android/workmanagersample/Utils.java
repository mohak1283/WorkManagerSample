package com.mohak.android.workmanagersample;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import static android.content.Context.NOTIFICATION_SERVICE;

public class Utils {

    public static final int NOTIFICATION_ID = 22;
    private static final String CHANNEL_ID = "notify-tea";
    private static final String CHANNEL_NAME = "tea-reminder";


    static void sendNotification(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel1.enableVibration(true);
            channel1.enableLights(true);
            channel1.setLightColor(R.color.colorPrimary);
            channel1.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

            notificationManager.createNotificationChannel(channel1);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle("Test")
                .setContentText("WorkManager Started")
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher_foreground);

        notificationManager.notify(1, builder.build());
    }
}
