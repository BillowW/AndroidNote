package com.example.cap3_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout_bu.setOnClickListener {
            startActivity(Intent(this, LayoutActivity::class.java))
        }

        custom_control_bu.setOnClickListener {
            startActivity(Intent(this, CustomControlActivity::class.java))
        }

        list_view_bu.setOnClickListener {
            startActivity(Intent(this, ListViewActivity::class.java))
        }

        recycler_view_bu.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
    }
}