package com.example.traniningproject.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class Myservices extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"service created",Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Toast.makeText(this,"service Started",Toast.LENGTH_LONG).show();
        MyThread myThread = new MyThread();
        myThread.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"service Destroyed",Toast.LENGTH_LONG).show();
    }

    private class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            for (int i = 0; i<10;i++){
                try {
                    Thread.sleep(3000);
                    Log.e("Thread", "run: "+i);
                } catch (InterruptedException e) {
                    Log.e("Thread Error", "run: "+e.getMessage());
                }
            }
        }
    }
}
