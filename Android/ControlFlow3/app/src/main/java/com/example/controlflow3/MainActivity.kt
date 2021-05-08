package com.example.controlflow3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var now=10
        when(now){
            8 ->{
                Log.d("when","현재 시간은 8시입니다.")
            }
            9 ->{
                Log.d("when","현재 시간은 9시입니다.")
            }
            else ->{
                Log.d("when","현재 시간은 9시가 아닙니다.")
            }
        }

        var ageOfMichael=19
        when(ageOfMichael){
            in 10..19 ->{
                Log.d("when_2","마이클은 10대 입니다.")
            }
            !in 10..19 ->{
                Log.d("when_2","마이클은 10대가 아닙니다.")
            }
            else ->{
                Log.d("when_2","마이클의 나이를 알 수 없습니다.")
            }
        }

        var currentTime=6
        when{
            currentTime==5 ->{
                Log.d("when_3","현재 시간은 5시 입니다.")
            }
            currentTime >5 ->{
                Log.d("when_3","현재 시간은 5시가 넘었습니다.")
            }
            else ->{
                Log.d("when_3","현재 시간은 5시 이전입니다.")
            }
        }
    }
}