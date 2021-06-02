package com.example.androidchatting;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

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

        Log.d("Boot1","SocketService.onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Boot1","SocketService.onStartCommand()");
        if(intent == null)  return Service.START_STICKY;
        else    Log.d("Boot1","SocketService.onStartCommand().else");

        if("startForground".equals(intent.getAction()))
        {
            Log.d("Boot2","start getAction");
            startForgroundService();
        }

        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d("Boot1","SocketService.onDestory()");
    }

    public class SocketThread extends Thread
    {
        @Override
        public void run()
        {
            try {
                Log.d("Boot2","Socket");
                Socket socket = new Socket("10.0.2.2", 7777);
                Log.d("Boot2","Socket start");

                BufferedReader readerIn = new BufferedReader(new InputStreamReader(System.in, "utf-8"));

                PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));

                // 제일 먼저 서버로 대화명을 송신합니다.
                // 맨 먼저 간 값이 닉네임이 되기 때문.

                JSONObject jsonName = new JSONObject();
                jsonName.put("nickname","백그라운드에서 돌아");
                JSONObject jsonName2=new JSONObject();
                jsonName2.put("User",jsonName);


                writer.println(jsonName2);
                writer.flush();


                Log.d("Boot2","BufferReader");
                BufferedReader readerOut = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));

                while (true) {

                    String str = readerOut.readLine();

                    JSONParser jsonParser = new JSONParser();
                    Object obj = jsonParser.parse(str);
                    JSONObject jsonStr = (JSONObject) obj;

                    String content = (String) jsonStr.get("content");
                    JSONObject jsonUser = (JSONObject) jsonStr.get("User");
                    String userName = (String) jsonUser.get("nickname");
                    String profileURL = (String) jsonUser.get("image");

                    Log.d("Boot2",userName);
                    if(content != null)
                        Log.d("Boot2",content);
                }

            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

        }
    }

    private void startForgroundService() {
        Log.d("Boot2","startForegroundService starting point");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "default");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("채팅 방 활성화...");
        builder.setContentText("채팅방 : ");

        Intent notificationIntent = new Intent(this, Chatting.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,    notificationIntent,0);
        builder.setContentIntent(pendingIntent);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.notify(1,);
            manager.createNotificationChannel(new NotificationChannel("default","socket",NotificationManager.IMPORTANCE_DEFAULT));
        }

        startForeground(1,builder.build());

        SocketThread socketThread = new SocketThread();
        socketThread.start();
    }
}
