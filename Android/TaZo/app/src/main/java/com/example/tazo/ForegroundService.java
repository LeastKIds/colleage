package com.example.tazo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class ForegroundService extends AppCompatActivity {

    private Button forgroundStartButton;
    private Button forgroundStopButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground_service);

        forgroundStartButton = (Button) findViewById(R.id.forgroundStartButton);
        forgroundStopButton = (Button) findViewById(R.id.forgroundStopButton);

        forgroundStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(), MusicService.class));
            }
        });

        forgroundStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(), MusicService.class));
            }
        });

//      현제 엑티비티 이름
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> info = manager.getRunningTasks(1);
        ComponentName componentName = info.get(0).topActivity;
        String topActivityName = componentName.getShortClassName().substring(1);

        Log.d("ActivityName",topActivityName);
    }
}