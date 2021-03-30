package com.example.collectionset

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var set=mutableSetOf<String>()
        set.add("JAN")
        set.add("FEB")
        set.add("MAR")
        set.add("JAN")

        Log.d("Collection","Set 전체 출력 = ${set}")

        set.remove("FEB")
        Log.d("Collection","Set 전체 출력 = ${set}")
    }
}