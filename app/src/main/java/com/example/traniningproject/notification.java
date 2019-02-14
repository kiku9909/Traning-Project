package com.example.traniningproject;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class notification extends AppCompatActivity implements View.OnClickListener {

    private Button pushBtn;
    private String CHANNEL_ID = "channel_01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pushBtn = (Button) findViewById(R.id.push_btn);
        pushBtn.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void makeNotificatio(){
        Intent notificationIntent = new Intent(notification.this,notification.class);
        PendingIntent intent = PendingIntent.getActivity(notification.this,0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        createChanel();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(notification.this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Custome Notofication")
                .setContentText("Notification Message")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(intent)
                .setAutoCancel(true);

        NotificationManager manager = (NotificationManager)getSystemService(notification.this.NOTIFICATION_SERVICE);
        manager.notify(1,builder.build());
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChanel(){
        CharSequence name = getString(R.string.channel_name);
        String description = getString(R.string.channel_description);
        int importance = NotificationManager.IMPORTANCE_DEFAULT;

        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
        channel.setDescription(description);

        // Register the channel with the system; you can't change the importance
        // or other notification behaviors after this
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        makeNotificatio();
    }
}

