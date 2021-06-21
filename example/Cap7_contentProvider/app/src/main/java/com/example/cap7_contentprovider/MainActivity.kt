package com.example.cap7_contentprovider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        permissionButton.setOnClickListener {
            startActivity(Intent(this, PermissionActivity::class.java))
        }
        button1.setOnClickListener {
            startActivity(Intent(this, ResolverActivity::class.java))
        }
        button2.setOnClickListener {
            startActivity(Intent(this, ContentProviderActivity::class.java))
        }
    }
}