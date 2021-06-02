package com.example.cap2_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_intent4.*

class Intent_5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent5)

//        接收传递过来的数据
        val extraData = intent.getStringExtra("extra_data")
        Toast.makeText(this, extraData, Toast.LENGTH_SHORT).show()

        upBu.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data_return", "asd")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}