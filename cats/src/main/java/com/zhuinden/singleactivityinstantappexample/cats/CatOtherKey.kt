package com.zhuinden.singleactivityinstantappexample.cats

import android.annotation.SuppressLint
import android.support.v4.app.Fragment
import com.zhuinden.singleactivityinstantappexample.base.BaseKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by Zhuinden on 2018.03.10..
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class CatOtherKey(val clazz: String): BaseKey() {
    constructor() : this("CatOtherKey")

    override fun createFragment(): Fragment = CatOtherFragment()
}