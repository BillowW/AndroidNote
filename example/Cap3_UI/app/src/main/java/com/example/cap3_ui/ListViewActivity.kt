package com.example.cap3_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        list_view_ex1.setOnClickListener {
            startActivity(Intent(this,ListViewExample1Activity::class.java))
        }

        list_view_ex2.setOnClickListener {
            startActivity(Intent(this, ListViewExample2Acitvity::class.java))
        }
    }
}