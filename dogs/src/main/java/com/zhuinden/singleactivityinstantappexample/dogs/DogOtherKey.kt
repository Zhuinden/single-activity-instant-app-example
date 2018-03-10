package com.zhuinden.singleactivityinstantappexample.dogs

import android.annotation.SuppressLint
import android.support.v4.app.Fragment
import com.zhuinden.singleactivityinstantappexample.base.BaseKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by Zhuinden on 2018.03.10..
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class DogOtherKey(val clazz: String) : BaseKey() {
    constructor() : this("DogOtherKey")

    override fun createFragment(): Fragment = DogOtherFragment()
}