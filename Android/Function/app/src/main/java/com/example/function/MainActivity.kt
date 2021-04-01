package com.example.function

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//
//
//        newFunction("hello")

        var squareResult = square(30)
        Log.d("Fun","30 square : ${squareResult}")

        printSum(3,5)

        val PI=getPi()
        Log.d("Fun","PI : ${PI}")

        newFunction("Hello")

        newFunction("Michael",weight = 67.5)

    }

    fun square(x : Int) : Int
    {
        return x*x
    }

    fun printSum(x : Int, y : Int) : Int
    {
        return x+y
    }

    fun getPi() : Double
    {
        return 3.14
    }

    fun newFunction(name: String, age: Int = 29, weight: Double = 65.5)
    {
        Log.d("Fun","name : ${name}")
        Log.d("Fun","age : ${age}")
        Log.d("Fun","weight : ${weight}")
    }


}