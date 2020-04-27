package com.example.network

import android.content.Context
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.util.Log
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class CheckInternetAsyncTask(private val context: Context?) : AsyncTask<Void, Int, Boolean>() {

    override fun doInBackground(vararg params: Void?): Boolean? {
        val cm = (context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
        val activeNetwork = cm.activeNetworkInfo
        val isConnected = activeNetwork != null && activeNetwork.isConnected

        if (isConnected){
            try {
                val url = URL("http://clients3.google.com/generate_204").openConnection() as HttpURLConnection
                url.setRequestProperty("User-Agent", "Android")
                url.setRequestProperty("Connection", "close")
                url.connectTimeout = 1500
                url.connect()
                Log.d("check","Inside try block")
                if (url.responseCode == 204 && url.contentLength == 0)
                    return true
            } catch (e: IOException) {
                Log.e("check", "Inside catch block: $e")
                Log.e("check", "Error checking internet connection $e")
                return false
            }
        } else {
            Log.d("check", "No network available!")
            return false
        }
        return null
    }

    override fun onPostExecute(result: Boolean?) {
        super.onPostExecute(result)
        Log.d("check","Result: $result")
    }

}