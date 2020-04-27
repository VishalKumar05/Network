package com.example.network

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val networkActivity = NetworkActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mNetworkStatus = networkActivity.checkNetwork(this)
        //val isNetworkAvailable = networkActivity.isInternetAvailable()
        //Log.d("info","MainActivity isNetworkAvailable: $isNetworkAvailable")
        if (mNetworkStatus) {
            //supportFragmentManager.beginTransaction().replace(R.id.frameLayout,MainFragment()).commit()
            val intent = Intent(this,TestActivity::class.java)
            startActivity(intent)
        }
        else Util.showNetworkDialog(this,"No Internet Connection Available")
    }
}