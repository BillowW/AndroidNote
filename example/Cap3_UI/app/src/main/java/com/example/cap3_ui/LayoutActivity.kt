package com.example.cap3_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_layout.*

class LayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)

        linear_layout_bu.setOnClickListener {
            startActivity(Intent(this, LinearLayoutActivity::class.java))
        }
        
        relative_layout_bu.setOnClickListener {
            startActivity(Intent(this, RelativeLayoutActivity::class.java))
        }

        frame_layout_bu.setOnClickListener {
            startActivity(Intent(this, FrameLayoutActivity::class.java))
        }
    }
}