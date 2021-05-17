package com.example.navertest;

import androidx.appcompat.app.AppCompatActivity;
import com.naver.maps.map.MapView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private MapView mapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapView=findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
    }
}