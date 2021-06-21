package com.example.cap7_contentprovider

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_permission.*
import java.util.jar.Manifest

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        makeCall.setOnClickListener {
//          1. 判断是否已授权
            if (
//              通过该方法判断是否已授权，传入context和权限名
//              其返回值与PackManager.PERMISSION_GRANTED比较
                ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
//              2. 调用requestPermissions方法获取权限
//              返回结果都会传到onRequestPermissionResult方法中
//              参数窜入activity实例，权限名数组和请求码(用于辨识请求)
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
//              已授权则调用拨号功能
                call()
            }
        }
    }

//  3. 重写onRequestPermissionResult方法
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
//          辨识请求码
            1 -> {
//              4. 判断是否同意权限，同意则调用拨号函数
                if (grantResults.isNotEmpty() &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {
                    call()
                } else {
//                  否则返回失败
                    Toast.makeText(
                        this,
                        "You denied the permission",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

//  5. 拨号函数
    private fun call() {
        try {
//          设置Intent，传入调用功能名
            val intent = Intent(Intent.ACTION_CALL)
//          传入数据
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }
}