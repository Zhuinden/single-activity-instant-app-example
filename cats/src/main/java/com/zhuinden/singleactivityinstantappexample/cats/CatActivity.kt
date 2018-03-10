package com.zhuinden.singleactivityinstantappexample.cats

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zhuinden.singleactivityinstantappexample.base.MainActivity

class CatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivity.startWith(this, CatKey())
        Log.i("CatActivity", "Finishing Cat activity")
    }
}
