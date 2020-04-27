package com.example.network

import android.os.Bundle
import android.util.Log

class TestActivity:BaseActivity(),NetworkChangeListener {

    private var isNetworkDialogVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        setNetworkChangeListener(this)
    }

    override fun isNetworkAvailable(isAvailable: Boolean) {
        Log.d("check","Inside TestActivity isNetworkAvailable(): $isAvailable")
        if (!isAvailable) {
            isNetworkDialogVisible = true
            Util.showNetworkDialog(this, "No network available")
        } else {
            if (isNetworkDialogVisible) {
                Util.dismissNetworkDialog()
                isNetworkDialogVisible = false
            }
        }
    }


}