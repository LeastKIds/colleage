package com.example.androidchatting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class chattingRoom extends AppCompatActivity {


    private Intent socketServiceIntent;

    private ArrayList<RoomData> arrayList;
    private RoomAdapter roomAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RoomData roomData;

    private Message msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting_room);

        Log.d("방","버튼 눌렀어요");
        String className = SocketService.class.getName();
        if(!isServiceRunning(className))
        {
            socketServiceIntent = new Intent(this,RoomSocket.class);
            socketServiceIntent.setAction("startRoomSocket");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                startForegroundService(socketServiceIntent);
                Log.d("방","룸 리스트 들어갑니다.");
            } else {
                startService(socketServiceIntent);
            }
        }


        recyclerView = (RecyclerView) findViewById(R.id.RoomList);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        roomAdapter = new RoomAdapter(arrayList);
        recyclerView.setAdapter(roomAdapter);

//        System.out.println(setRoomList());
        setRoom(setRoomList());
    }

    public Boolean isServiceRunning(String class_name)
    {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for(ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE))
        {
            if(class_name.equals(service.service.getClassName()))
                return true;
        }

        return false;
    }

    public String setRoomList()
    {
        String record = "";
        Chatting.HttpAsyncTask httpAsyncTask = new Chatting.HttpAsyncTask(record);
        try {
            System.out.println("error");
            record =httpAsyncTask.execute("https://tazoapp.site/rooms").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return record;
    }

    private static class HttpAsyncTask extends AsyncTask<String, Void, String> {

        OkHttpClient client = new OkHttpClient();
        String result;

        public HttpAsyncTask(String result)
        {
            this.result=result;
        }

        @Override
        protected String doInBackground(String... params) {

            String strUrl = params[0];

            try {
                Request request = new Request.Builder().url(strUrl).build();
                Response response = client.newCall(request).execute();
                result = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return result;
        }



    }

    public void setRoom(String json)
    {
        try{
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(json);
            JSONArray jsonArray = (JSONArray) obj;

            System.out.println(jsonArray);

            for(int i=0; i<jsonArray.size(); i++)
            {
                msg = handler.obtainMessage();
//                msg.what=1;
                msg.obj=jsonArray.get(i);
                handler.sendMessage(msg);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg){

            JSONObject jsonStr = (JSONObject) msg.obj;

            String name = (String) jsonStr.get("name");
            String userLimit = jsonStr.get("userLimit") + "";
            String originLat = (String) jsonStr.get("originLat");
            String originLng = (String) jsonStr.get("originLng");
            String destinationLat = (String) jsonStr.get("destinationLat");
            String destinationLng = (String) jsonStr.get("destinationLng");
            String startAt = (String) jsonStr.get("startAt");
            String gender = (String) jsonStr.get("gender");

            roomData = new RoomData(name, userLimit,gender,startAt,originLat,originLng,destinationLat,destinationLng);
            arrayList.add(roomData);
            roomAdapter.notifyDataSetChanged();
            System.out.println("실행은됨");
        }
    };
}