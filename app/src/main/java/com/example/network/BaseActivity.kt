package com.example.network

import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity:AppCompatActivity() {

    private var mNetworkChangeListener:NetworkChangeListener? = null
    private lateinit var mNetworkChangeReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        Log.d("check","Inside BaseActivity onStart()")
        mNetworkChangeReceiver = NetworkChangeReceiver(mNetworkChangeListener!!)
        registerReceiver(mNetworkChangeReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    open fun setNetworkChangeListener(mListener: NetworkChangeListener) {
        mNetworkChangeListener = mListener
    }

    override fun onStop() {
        super.onStop()
        Log.d("check","Inside BaseActivity onStop()")
        unregisterReceiver(mNetworkChangeReceiver)
    }

}