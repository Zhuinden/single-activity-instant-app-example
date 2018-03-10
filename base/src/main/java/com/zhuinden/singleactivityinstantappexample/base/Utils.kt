package com.zhuinden.singleactivityinstantappexample.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle

/**
 * Created by Zhuinden on 2018.03.10..
 */
inline fun <reified T: Activity> Activity.startActivity(intentBuilder: Intent.() -> Unit = {}) {
    startActivity(Intent(this, T::class.java).apply(intentBuilder))
}