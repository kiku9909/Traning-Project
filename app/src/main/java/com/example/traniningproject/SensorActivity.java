package com.example.traniningproject;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SensorActivity extends AppCompatActivity {

    private TextView sen_tv;
    private SensorManager SensMng;
    private List<Sensor> sensList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sen_tv = (TextView) findViewById(R.id.sensor_tv);
        SensMng = (SensorManager)this.getSystemService(SENSOR_SERVICE);

        sensList = SensMng.getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor: sensList){

            sen_tv.append("\n"+sensor.getName()+" : "+sensor.getVendor()+" , version : "+sensor.getVersion()+"\n");
        }
    }
}
