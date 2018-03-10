package com.zhuinden.singleactivityinstantappexample.base

import android.os.Bundle
import com.zhuinden.simplestack.KeyContextWrapper
import android.view.LayoutInflater
import android.view.ViewGroup
import android.R.menu
import android.support.v4.app.Fragment
import android.view.MenuInflater



/**
 * Created by Zhuinden on 2018.03.10..
 */
abstract class BaseFragment: Fragment() {
    fun <K : Key> getKey(): K = arguments!!.getParcelable(KEY_TAG) as K

    companion object {
        const val KEY_TAG = "KEY"
    }
}