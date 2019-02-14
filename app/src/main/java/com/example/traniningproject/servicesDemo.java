package com.example.traniningproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.traniningproject.Services.Myservices;

public class servicesDemo extends AppCompatActivity implements View.OnClickListener {
    Button start,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_demo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //button initialization
        start = (Button) findViewById(R.id.start_btn);
        stop = (Button) findViewById(R.id.stop_btn);

        //button click linstener
        start.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.start_btn){
            //strat the service
            startService(new Intent(servicesDemo.this,Myservices.class));
        }else if (v.getId() == R.id.stop_btn){
            //stop the service
            stopService(new Intent(servicesDemo.this,Myservices.class));
        }
    }
}
