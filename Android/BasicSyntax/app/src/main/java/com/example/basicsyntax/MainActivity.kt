package com.example.basicsyntax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myName="홍길동"
        var myAage:Int
        myAage=27
        myAage=myAage+1
        Log.d("BasicSyntax","myName = $myName, myAage = $myAage")
    }
}