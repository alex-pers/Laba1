package com.test.laba1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_second)
        super.onCreate(savedInstanceState)

        Log.d("ACTIVITY_LOGS","onCreate SecondActivity")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ACTIVITY_LOGS","onPause SecondActivity")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ACTIVITY_LOGS","onResume SecondActivity")
    }
}