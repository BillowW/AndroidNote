package com.example.cap2_activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        设置按钮点击事件
        toTM.setOnClickListener{
            val intent = Intent(this, Toast_Menu_Activity::class.java)
            startActivity(intent)
        }
        toIntent.setOnClickListener {
            val intent = Intent(this, Intent_Activity::class.java)
            startActivity(intent)
        }
        toKill.setOnClickListener {
            val intent = Intent(this, Advanced_Kills_Activity::class.java)
            startActivity(intent)
        }
    }
}