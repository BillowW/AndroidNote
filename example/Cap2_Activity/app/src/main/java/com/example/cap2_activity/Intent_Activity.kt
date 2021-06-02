package com.example.cap2_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_intent.*

class Intent_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        intent_1.setOnClickListener {
            val intent = Intent(this, Intent_1Activity::class.java)
            startActivity(intent)
        }

//        隐式Intent的特点就是不指明启动哪个activity，通过action和category来推断启动哪个activity
        intent_2.setOnClickListener {
            val intent = Intent("ACTION_START")
            startActivity(intent)
        }

        intent_3.setOnClickListener {
            val intent = Intent(this, Intent_3::class.java)
            startActivity(intent)
        }

        intent_4.setOnClickListener {
            val intent = Intent(this, Intent_4Activity::class.java)
            startActivity(intent)
        }

    }

}