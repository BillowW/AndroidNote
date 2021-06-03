package com.example.cap3_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recycler_view_ex1.setOnClickListener {
            startActivity(Intent(this, RecyclerViewExample1::class.java))
        }

        recycler_view_ex2.setOnClickListener {
            startActivity(Intent(this, RecyclerViewExample2::class.java))
        }

        recycler_view_ex3.setOnClickListener {
            startActivity(Intent(this, RecyclerViewExample3::class.java))
        }
    }
}