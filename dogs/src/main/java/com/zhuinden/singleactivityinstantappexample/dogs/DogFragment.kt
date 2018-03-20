package com.zhuinden.singleactivityinstantappexample.dogs

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhuinden.singleactivityinstantappexample.base.BaseFragment
import com.zhuinden.singleactivityinstantappexample.base.MainActivity
import kotlinx.android.synthetic.main.fragment_dog.*
import org.jetbrains.anko.sdk15.listeners.onClick

/**
 * Created by Zhuinden on 2018.03.10..
 */
class DogFragment: BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_dog, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonDogGoToNext.onClick {
            (activity as MainActivity).goTo(DogOtherKey())
        }
    }
}
