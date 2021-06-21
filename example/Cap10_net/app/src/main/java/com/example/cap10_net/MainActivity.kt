package com.example.cap10_net

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            startActivity(Intent(this, WebActivity::class.java))
        }

        http.setOnClickListener {
            startActivity(Intent(this, HttpActivity::class.java))
        }

        button3.setOnClickListener {
            startActivity(Intent(this, XMLActivity::class.java))
        }

        button4.setOnClickListener {
            startActivity(Intent(this, JSONActivity::class.java))
        }

        button5.setOnClickListener {
            startActivity(Intent(this, CallBackActivity::class.java))
        }

        button6.setOnClickListener {
            startActivity(Intent(this, RetrofitActivity::class.java))
        }
    }
}