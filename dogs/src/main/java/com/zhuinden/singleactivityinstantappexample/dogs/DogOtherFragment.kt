package com.zhuinden.singleactivityinstantappexample.dogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhuinden.singleactivityinstantappexample.base.BaseFragment

/**
 * Created by Zhuinden on 2018.03.10..
 */
class DogOtherFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_dog_other, container, false)
}