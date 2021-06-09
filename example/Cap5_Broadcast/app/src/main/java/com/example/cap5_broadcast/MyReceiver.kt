package com.example.cap5_broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

//第一步，创建一个Broadcast类
class MyReceiver : BroadcastReceiver() {

//    重写方法
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "received in MyBroadcastReceiver",
            Toast.LENGTH_SHORT).show()

//    截取广播
        abortBroadcast()
    }
}