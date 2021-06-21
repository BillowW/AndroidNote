package com.example.cap9_server

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class MyService : Service() {

    private val mBinder = DownloadBinder()
    class DownloadBinder : Binder() {
        fun startDownload() {
            Log.d("MyService", "startDownload executed")
        }
        fun getProgress(): Int {
            Log.d("MyService", "getProgress executed")
            return 0
        }
    }
    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this, "My Service Start", Toast.LENGTH_SHORT).show()
    }
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Toast.makeText(this, "My Service Stop", Toast.LENGTH_SHORT).show()
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "My Service Destroy", Toast.LENGTH_SHORT).show()
    }
}