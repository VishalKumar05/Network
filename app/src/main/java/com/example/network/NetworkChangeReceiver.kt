package com.example.network

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log

class NetworkChangeReceiver(listener: NetworkChangeListener) : BroadcastReceiver() {

    private lateinit var connectivityManager: ConnectivityManager
    private var mListener:NetworkChangeListener = listener

    companion object{
        private val TAG = NetworkChangeReceiver::class.java.simpleName
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("check","Action: ${intent?.action}")
        try {
            if (intent?.action.equals("android.net.conn.CONNECTIVITY_CHANGE")){
                if (mListener!=null){
                    val checkInternetAsyncTask = CheckInternetAsyncTask(context)
                    val value = checkInternetAsyncTask.execute()
                    Log.d("check","Value: ${value.get()}")
                    mListener.isNetworkAvailable(value.get())
                }
            }
        }catch (e:Exception){ e.printStackTrace() }
    }

    /*private fun checkNetwork(context: Context): Boolean? {
        val isNetworkAvailable: Boolean
        connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo  //Returns details about the currently active default data network
        isNetworkAvailable = networkInfo !=null && networkInfo.isConnected
        return isNetworkAvailable
    }
*/

}