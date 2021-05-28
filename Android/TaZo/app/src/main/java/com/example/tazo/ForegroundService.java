package com.example.tazo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    }
}