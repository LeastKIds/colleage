package com.example.tazo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class SocketService extends Service {
    public SocketService() {}

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("Boot","SocketService.onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Boot","SocketService.onStartCommand()");
        if(intent == null)  return Service.START_STICKY;
        else    Log.d("Boot","SocketService.onStartCommand().else");


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d("Boot","SocketService.onDestory()");
    }
}
