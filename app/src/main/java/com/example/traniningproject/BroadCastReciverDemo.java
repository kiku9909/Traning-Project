package com.example.traniningproject;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.traniningproject.Reciveres.Myreciver;

public class BroadCastReciverDemo extends AppCompatActivity {

    private Button chk_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_reciver_demo);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //register the reciver
        registerReceiver(new Myreciver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
//        registerReceiver(new Myreciver(), new IntentFilter("com.traniningProject.CUSTOME_INTENT"));
        chk_btn = (Button) findViewById(R.id.check_btn);
        chk_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadcast(new Intent().setAction("com.traniningProject.CUSTOME_INTENT"));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(new Myreciver());
    }
}
