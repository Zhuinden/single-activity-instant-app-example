package com.zhuinden.singleactivityinstantappexample.base

import android.os.Bundle
import android.support.v4.app.Fragment


/**
 * Created by Zhuinden on 2018.03.10..
 */
abstract class BaseKey : Key {
    override val fragmentTag: String
        get() = toString()

    override fun newFragment(): Fragment = createFragment().apply {
        arguments = (arguments ?: Bundle()).apply {
            putParcelable(BaseFragment.KEY_TAG, this@BaseKey)
        }
    }

    protected abstract fun createFragment(): Fragment
}