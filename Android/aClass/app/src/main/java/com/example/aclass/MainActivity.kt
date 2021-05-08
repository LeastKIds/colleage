package com.example.aclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Kotlin()

        KotlinTwo("안녕")

        var kotlin=KotlinThree()
        kotlin.printOne()
        kotlin.one="Hello"
        kotlin.printOne()

        KotlinFour.printOne()
        KotlinFour.one="Hello"
        KotlinFour.printOne()

        var dataUser=DataUser("Michael",21)
        var newUser=dataUser.copy()
        newUser.name="Jane"
        Log.d("Class","원본 dataUser는 ${dataUser.toString()}")
        Log.d("Class","복사된 newUser는 ${newUser.toString()}")
    }
}

class Kotlin()
{
    init
    {
        Log.d("Class","Kotlin 클래스 생성됨")
    }
}

class KotlinTwo
{
    constructor (value : String)
    {
        Log.d("Class","KotlinTwo : 피라미터 값은 ${value}입니다.")
    }
}

class KotlinThree
{
    var one : String = "None"
    fun printOne()
    {
        Log.d("Class","KotlinThree : one에 입력된 값은 ${one}입니다.")
    }
}

class KotlinFour {
    companion object {
        var one: String = "None"
        fun printOne() {
            Log.d("Class", "KotlinFour : one에 입력된 값은 ${one}입니다.")
        }
    }

}

data class DataUser(var name : String, var age : Int)