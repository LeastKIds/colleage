package com.example.androidchatting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
import java.util.concurrent.ExecutionException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button room;
    private Button roomCreate;
    private Socket mSocket;
    private Button session;
    private Button login;
    private String shard="file";

    private String record="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.chatting);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Chatting.class);
                startActivity(intent);
            }
        });

        room = (Button) findViewById(R.id.roomSocket);

        room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, chattingRoom.class);
                startActivity(intent);
            }
        });

        roomCreate = (Button) findViewById(R.id.roomCreate);
        roomCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        session = (Button) findViewById(R.id.session);
        session.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread sessionThread = new SessionThread();
                sessionThread.start();

            }
        });

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,login.class);
                startActivity(intent);
            }
        });
    }

    public class SessionThread extends Thread {
        @Override
        public void run() {


            String url = "https://tazoapp.site/auth/logout";
            try {
                OkHttpClient client = new OkHttpClient();

                SharedPreferences sharedPreferences = getSharedPreferences(shard,0);
                String setCookie = sharedPreferences.getString("cookie","");


                Request request = new Request.Builder()
                        .addHeader("cookie", setCookie)
                        .url(url)
                        .build();
                Response response = client.newCall(request)
                        .execute();

                String result = response.body().string();
                System.out.println(result);

            } catch(Exception e) {
                e.printStackTrace();
            }

        }
    }

}