package com.zhuinden.singleactivityinstantappexample.cats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhuinden.singleactivityinstantappexample.base.BaseFragment

/**
 * Created by Zhuinden on 2018.03.10..
 */
class CatOtherFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_cat_other, container, false)
}