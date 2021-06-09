package com.example.cap5_broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver2 : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "received in BroadcastReceiver 2", Toast.LENGTH_SHORT).show()
    }
}