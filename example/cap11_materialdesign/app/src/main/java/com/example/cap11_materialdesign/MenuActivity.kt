package com.example.cap11_materialdesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        drawerLayout.setOnClickListener {
            startActivity(Intent(this, DrawerActivity::class.java))
        }
        navigationView.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java))
        }
    }
}