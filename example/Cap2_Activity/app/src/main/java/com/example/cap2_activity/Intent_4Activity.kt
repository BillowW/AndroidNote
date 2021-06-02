package com.example.cap2_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_intent4.*

class Intent_4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent4)

        downBu.setOnClickListener {
//            设置内容
            val data = "向下传递数据"
            val intent = Intent(this, Intent_5Activity::class.java)
//            通过putExtra传入数据，输入键值对
            intent.putExtra("extra_data", data)
            startActivity(intent)
        }

        upBu.setOnClickListener {
            val intent = Intent(this, Intent_5Activity::class.java)
            startActivityForResult(intent, 1)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        requestCode是请求码，判断是哪一个activity
//        resultCode是返回码，判断是否返回数据
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Toast.makeText(this, "returnedData", Toast.LENGTH_SHORT).show()
            }
        }
    }
}