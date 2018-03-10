package com.zhuinden.singleactivityinstantappexample.base

import android.support.v4.app.FragmentManager
import com.zhuinden.simplestack.StateChange
import com.zhuinden.singleactivityinstantappexample.R


/**
 * Created by Zhuinden on 2018.03.10..
 */
class FragmentStateChanger(private val fragmentManager: FragmentManager, private val containerId: Int) {

    fun handleStateChange(stateChange: StateChange) {
        val fragmentTransaction = fragmentManager.beginTransaction().disallowAddToBackStack()
        if (stateChange.direction == StateChange.FORWARD) {
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_left)
        } else if (stateChange.direction == StateChange.BACKWARD) {
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_from_left, R.anim.slide_out_to_right)
        }

        val previousState = stateChange.getPreviousState<Key>()
        val newState = stateChange.getNewState<Key>()
        for (oldKey in previousState) {
            val fragment = fragmentManager.findFragmentByTag(oldKey.fragmentTag)
            if (fragment != null) {
                if (!newState.contains(oldKey)) {
                    fragmentTransaction.remove(fragment)
                } else if (!fragment.isDetached()) {
                    fragmentTransaction.detach(fragment)
                }
            }
        }
        for (newKey in newState) {
            var fragment = fragmentManager.findFragmentByTag(newKey.fragmentTag)
            if (newKey.equals(stateChange.topNewState<Any>())) {
                if (fragment != null) {
                    if (fragment.isDetached()) {
                        fragmentTransaction.attach(fragment)
                    }
                } else {
                    fragment = newKey.newFragment()
                    fragmentTransaction.add(containerId, fragment, newKey.fragmentTag)
                }
            } else {
                if (fragment != null && !fragment.isDetached()) {
                    fragmentTransaction.detach(fragment)
                }
            }
        }
        fragmentTransaction.commitNow()
    }
}