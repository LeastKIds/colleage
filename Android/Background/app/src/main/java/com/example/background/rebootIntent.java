package com.example.background;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class rebootIntent extends Service {

    public rebootIntent() {}

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("Boot","rebottIntent.onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Boot","rebottIntent.onStartCommand()");
        if(intent == null)  return Service.START_STICKY;
        else    Log.d("Boot","rebottIntent.onStartCommand().else");


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d("Boot","rebottIntent.onDestory()");
    }
}
