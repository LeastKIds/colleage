package com.example.androidchatting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class login extends AppCompatActivity {

    private Button send;
    private TextView email;
    private TextView pwd;
    private String shard = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        email = (TextView) findViewById(R.id.email);
        pwd = (TextView) findViewById(R.id.pwd);
        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                RequestBody requestBody = new FormBody.Builder()
                        .add("email",email.getText().toString())
                        .add("password",pwd.getText().toString())
                        .build();

                Request request = new Request.Builder()
                        .url("https://tazoapp.site/auth/login")
                        .post(requestBody)
                        .build();

                OkHttpClient client = new OkHttpClient();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e)
                    {
                        System.out.println("연결 실패");
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException
                    {
                        System.out.println("연결 성공");
                        System.out.println(response);
                        System.out.println("******************************");
                        System.out.println(response.header("set-cookie"));
                        System.out.println("******************************");
                        SharedPreferences sharedPreferences = getSharedPreferences(shard,0);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("cookie",response.header("set-cookie"));
                        editor.commit();

                    }
                });
            }
        });
    }
}