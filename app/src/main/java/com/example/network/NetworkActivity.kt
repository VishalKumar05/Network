package com.example.network

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log

class NetworkActivity {

    private lateinit var connectivityManager: ConnectivityManager

    companion object{
        private val TAG = NetworkActivity::class.java.simpleName
    }

    fun checkNetwork(context: Context):Boolean {
        var isNetworkAvailable:Boolean = false
        connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo //Returns details about the currently active default data network

        try {
            isNetworkAvailable = networkInfo !=null && networkInfo.isConnected
        }catch (e:Exception){
            Log.d(TAG,"Exception: $e")
        }
        return isNetworkAvailable
    }

}


