package com.zhuinden.singleactivityinstantappexample.base

import android.os.Parcelable
import android.support.v4.app.Fragment

/**
 * Created by Zhuinden on 2018.03.10..
 */
interface Key : Parcelable {
    fun newFragment(): Fragment

    val fragmentTag: String
}