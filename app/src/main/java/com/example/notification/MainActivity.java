package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
private static final String CHANNEL_ID="my channel";
private static final int NOTIFY_ID=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification=new Notification.Builder(this)
                    .setSmallIcon(R.drawable.s)
                    .setContentText("Welcome..!!!!")
                    .setSubText("Thank You for installing app")
                    .setChannelId(CHANNEL_ID)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"New channel",NotificationManager.IMPORTANCE_HIGH));
        }
        else{
            notification=new Notification.Builder(this)
                    .setSmallIcon(R.drawable.s)
                    .setContentText("Welcome..!!!!")
                    .setSubText("Thank You for installing app")
                    .build();
        }
        nm.notify(NOTIFY_ID,notification);
    }
}