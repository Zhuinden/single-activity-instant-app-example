package com.zhuinden.singleactivityinstantappexample.cats

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhuinden.singleactivityinstantappexample.base.BaseFragment
import com.zhuinden.singleactivityinstantappexample.base.MainActivity
import kotlinx.android.synthetic.main.fragment_cat.*
import org.jetbrains.anko.sdk25.listeners.onClick

/**
 * Created by Zhuinden on 2018.03.10..
 */
class CatFragment: BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_cat, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonCatGoToNext.onClick {
            (activity as MainActivity).goTo(CatOtherKey())
        }
    }
}