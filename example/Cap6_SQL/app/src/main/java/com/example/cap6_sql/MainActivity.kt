package com.example.cap6_sql

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        file.setOnClickListener {
            startActivity(Intent(this, File::class.java))
        }
        sharedPre.setOnClickListener {
            startActivity(Intent(this, SharedPreferences::class.java))
        }
        SQLlite.setOnClickListener {
            startActivity(Intent(this, SQLLite::class.java))
        }
    }
}