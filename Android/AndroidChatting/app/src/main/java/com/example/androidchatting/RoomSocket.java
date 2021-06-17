package com.example.androidchatting;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URISyntaxException;


public class RoomSocket extends Service {

    private Socket mSocket;
    private Context context;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("방","온크리에이트");
        
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("방","온스타트커맨드");
        if (intent == null) return Service.START_STICKY;

        if ("startRoomSocket".equals(intent.getAction())) {
            startForgroundService();
        }

        return super.onStartCommand(intent, flags, startId);


    }







    private void startForgroundService() {
        context=this;
        Log.d("방","스타트포그라운드서비스");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "default");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("채팅방 리스트");
        builder.setPriority(NotificationCompat.PRIORITY_MAX);
        builder.setDefaults(Notification.DEFAULT_VIBRATE);


        Intent notificationIntent = new Intent(this, chattingRoom.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        builder.setContentIntent(pendingIntent);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(new NotificationChannel("default", "socket", NotificationManager.IMPORTANCE_HIGH));
        }

//        Thread socketThread = new SocketThread();
//        socketThread.start();

        try {
            mSocket = IO.socket("https://tazoapp.site/ws-room");
            mSocket.connect();

            mSocket.on("hello", new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    String data = (String) args[0];
                    System.out.println("******* " + data + " **************");

                }
            });
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        startForeground(1, builder.build());


    }


    public class SocketThread extends Thread {
        @Override
        public void run() {




        }
    }






}
