package com.zhuinden.singleactivityinstantappexample.dogs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zhuinden.singleactivityinstantappexample.base.MainActivity

class DogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivity.startWith(this, DogKey())
        Log.i("DogActivity", "Finishing Dog activity")
    }
}
