package com.example.androidchatting;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

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


        SocketThread socketThread = new SocketThread();
        socketThread.start();
//        try {
//            Log.d("Boot1","socket");
//            Socket socket = new Socket("10.0.2.2", 7777);
//            Log.d("Boot1","socket start...");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



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
                Log.d("Boot1","Socket");
                Socket socket = new Socket("10.0.2.2", 7777);
                Log.d("Boot1","Socket start");

//                BufferedReader readerIn = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
//
//                PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
//
//                // 제일 먼저 서버로 대화명을 송신합니다.
//                // 맨 먼저 간 값이 닉네임이 되기 때문.
//
//                JSONObject jsonName = new JSONObject();
//                jsonName.put("nickname","백그라운드에서 돌아");
//                JSONObject jsonName2=new JSONObject();
//                jsonName2.put("User",jsonName);
//
//
//                writer.println(jsonName2);
//                writer.flush();

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

                    Log.d("Boot1",userName);
                    Log.d("Boot1",content);
                }

            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

        }
    }
}
