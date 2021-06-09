package com.example.cap5_broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    第二步，实例化内部类
    lateinit var timeChangeReceiver: TimeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
//            第三步，设置点击按钮，发送广播
//            传入广播名，然后setPackagename，然后使用sendBrocast方法
            val intent = Intent("com.example.cap5_broadcast.MY_BROADCAST")
            intent.setPackage(packageName)
            sendBroadcast(intent)
//            sendOrderedBroadcast(intent, null)
        }

//      创建IntentFilter实例
        val intentFilter = IntentFilter()
//      创建监听动作
        intentFilter.addAction("android.intent.action.TIME_TICK")
//        创建实例
        timeChangeReceiver = TimeChangeReceiver()
//        传入动作和实例
        registerReceiver(timeChangeReceiver, intentFilter)
    }

//    手动取消注册
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }

//    第一步，创建一个内部类，继承自BroadCast，重写它的方法
    inner class TimeChangeReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "Time has changed", Toast.LENGTH_SHORT).show()
        }
    }
}