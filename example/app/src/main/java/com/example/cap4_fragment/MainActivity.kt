package com.example.cap4_fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            startActivity(Intent(this, Fragment1::class.java))
        }

        button2.setOnClickListener {
            startActivity(Intent(this, Fragment2::class.java))
        }

        button3.setOnClickListener {
            startActivity(Intent(this, Fragment3::class.java))
        }
    }
}