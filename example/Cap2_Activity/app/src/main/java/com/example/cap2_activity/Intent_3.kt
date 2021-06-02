package com.example.cap2_activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intent3.*

class Intent_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent3)

        new_web.setOnClickListener {

//            设置Intent的动作
            val intent = Intent(Intent.ACTION_VIEW)
//            设置数据，这里实际上是调用了set方法
            intent.data = Uri.parse("https://www.baidu.com")
            startActivity(intent)
        }
    }
}