package com.example.traniningproject.Reciveres;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


public class Myreciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("reciver", "onReceive: ");
        Toast.makeText(context, "Intent Detected", Toast.LENGTH_SHORT).show();
    }
}
