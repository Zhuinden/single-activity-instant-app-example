package com.zhuinden.singleactivityinstantappexample.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.zhuinden.simplestack.BackstackDelegate
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.StateChanger
import com.zhuinden.singleactivityinstantappexample.R

class MainActivity : AppCompatActivity(), StateChanger {
    companion object {
        const val KEYS = "KEYS"
        fun startWith(activity: Activity, vararg keys: Key) {
            activity.startActivity<MainActivity>() {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                putParcelableArrayListExtra(KEYS, ArrayList<Key>().apply {
                    addAll(keys)
                })
            }
            activity.finish()
        }
    }

    private lateinit var backstackDelegate: BackstackDelegate
    private lateinit var fragmentStateChanger: FragmentStateChanger

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("MainActivity", "Starting main activity.")
        backstackDelegate = BackstackDelegate()
        backstackDelegate.onCreate(savedInstanceState, lastCustomNonConfigurationInstance,
            History.from(intent.getParcelableArrayListExtra<Key>(KEYS)))
        backstackDelegate.registerForLifecycleCallbacks(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentStateChanger = FragmentStateChanger(supportFragmentManager, R.id.fragmentContainer)
        backstackDelegate.setStateChanger(this)
    }

    override fun onRetainCustomNonConfigurationInstance(): Any =
        backstackDelegate.onRetainCustomNonConfigurationInstance()

    override fun onBackPressed() {
        if (!backstackDelegate.onBackPressed()) {
            super.onBackPressed()
        }
    }

    override fun handleStateChange(stateChange: StateChange, completionCallback: StateChanger.Callback) {
        if (stateChange.topNewState<Any>() == stateChange.topPreviousState<Any?>()) {
            completionCallback.stateChangeComplete()
            return
        }
        fragmentStateChanger.handleStateChange(stateChange)
        completionCallback.stateChangeComplete()
    }

    fun goTo(key: Key) {
        backstackDelegate.backstack.goTo(key)
    }
}
