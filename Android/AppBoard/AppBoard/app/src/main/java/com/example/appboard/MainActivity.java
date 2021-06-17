package com.example.appboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        // Adapter 생성
        adapter = new ListViewAdapter();

        // 리스트뷰 객체 생성 및 Adapter 설정
        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);

        // 리스트 뷰 아이템 추가.
        adapter.addItem();
        adapter.addItem();
        adapter.addItem();
    }

}
