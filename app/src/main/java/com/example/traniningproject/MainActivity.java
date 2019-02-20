package com.example.traniningproject;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.traniningproject.Reciveres.Myreciver;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView service_card, broadcast_card,camera_card,sensor_card,notification_card,MediaPlayer_card,VideomediaPlayer_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //card intialization
        service_card = (CardView) findViewById(R.id.service_activity);
        service_card.setOnClickListener(this);

        broadcast_card = (CardView) findViewById(R.id.BroadCast_activity);
        broadcast_card.setOnClickListener(this);

        camera_card = (CardView) findViewById(R.id.Camera_activity);
        camera_card.setOnClickListener(this);

        sensor_card = (CardView) findViewById(R.id.Sensor_activity);
        sensor_card.setOnClickListener(this);

        notification_card = (CardView) findViewById(R.id.Notification_activity);
        notification_card.setOnClickListener(this);

        MediaPlayer_card = (CardView) findViewById(R.id.MediaPlayer_activity);
        MediaPlayer_card.setOnClickListener(this);

        VideomediaPlayer_card = (CardView) findViewById(R.id.VedioMediaPlayer_activity);
        VideomediaPlayer_card.setOnClickListener(this);
    }

    //redirecting to specific activity
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            //services activity
            case R.id.service_activity:
                startActivity(new Intent(MainActivity.this, servicesDemo.class));
                break;

            //broadcast reciver Activity
            case R.id.BroadCast_activity:
                startActivity(new Intent(MainActivity.this,BroadCastReciverDemo.class));
                break;
            //camera activity
            case R.id.Camera_activity:
                startActivity(new Intent(MainActivity.this,CameraDemo.class));
                break;

            //sensor activity
            case R.id.Sensor_activity:
                startActivity(new Intent(MainActivity.this,SensorActivity.class));
                break;

            //Notification activity
            case R.id.Notification_activity:
                startActivity(new Intent(MainActivity.this,notification.class));
                break;

            //Media player activity
            case R.id.MediaPlayer_activity:
                startActivity(new Intent(MainActivity.this,MediaPlayer.class));
                break;

            //video Media player activity
            case R.id.VedioMediaPlayer_activity:
                startActivity(new Intent(MainActivity.this,VideoPlayer.class));
                break;
        }
    }
}
