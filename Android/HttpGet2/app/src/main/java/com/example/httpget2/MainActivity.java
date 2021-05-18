package com.example.httpget2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.nio.channels.AsynchronousChannelGroup;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new HttpAsyncTask().execute("https://jsonplaceholder.typicode.com/posts");
    }

    private static class HttpAsyncTask extends AsyncTask<String, Void, String>{

        OkHttpClient client = new OkHttpClient();
        @Override
        protected String doInBackground(String... params) {
            String result = null;
            String strUrl = params[0];

            try {
                Request request = new Request.Builder().url(strUrl).build();
                Response response = client.newCall(request).execute();
                Log.d(TAG, "doInBackground:" + response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

//        @Override
//        protected void onPostExecute(String s)
//        {
//            super.onPostExecute(s);
//            if(s !=null)
//                Log.d(TAG,s);
//        }
    }
}