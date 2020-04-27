package com.example.network

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AlertDialog

object Util {

    private lateinit var dialog: AlertDialog
    private lateinit var builder: AlertDialog.Builder

    fun showNetworkDialog(context: Context, msg: String) {
        Log.d("check","showNetworkDialog called")
        builder = AlertDialog.Builder(context)
        builder.setTitle("Error")
        builder.setMessage(msg)
        builder.setCancelable(true)
        dialog = builder.create()
        dialog.show()
    }

    fun dismissNetworkDialog(){
        Log.d("check","dismissNetworkDialog called")
        if (dialog.isShowing) dialog.dismiss()
    }

}