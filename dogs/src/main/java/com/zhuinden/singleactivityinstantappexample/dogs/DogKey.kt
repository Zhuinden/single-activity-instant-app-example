package com.zhuinden.singleactivityinstantappexample.dogs

import android.annotation.SuppressLint
import android.os.Parcelable
import android.support.v4.app.Fragment
import com.zhuinden.singleactivityinstantappexample.base.BaseKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by Zhuinden on 2018.03.10..
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class DogKey(val clazz: String) : BaseKey() {
    constructor() : this("DogKey")

    override fun createFragment(): Fragment = DogFragment()
}