package com.example.cap6_sql

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferences : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        saveButton.setOnClickListener {
//          第一步，获取sharedPreferences对象，
//            并调用edit方法获取editor对象
            val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
//          第二步，在里面通过put方法添加键值对数据
            editor.putString("name", "Tom")
            editor.putInt("age", 28)
            editor.putBoolean("married", false)
//          第三步，通过apply方法提交数据完成存储数据
            editor.apply()
        }

        restoreButton.setOnClickListener {
//          第一步，通过getSharedPreferences方法获取对象
            val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
//          第二步，通过get方法获取数据
            val name = prefs.getString("name", "")
            val age = prefs.getInt("age", 0)
            val married = prefs.getBoolean("married", false)

            showData.text = "name is $name, age is $age and married is $married"
        }

        val prefs = getPreferences(Context.MODE_PRIVATE)
        val isRemember = prefs.getBoolean("remember_password", false)
        if (isRemember) {
            val account = prefs.getString("account", "")
            val password = prefs.getString("password", "")
            accountEdit.setText(account)
            passwordEdit.setText(password)
            rememberPass.isChecked = true
        }

        login.setOnClickListener {
            val account = accountEdit.text.toString()
            val password = passwordEdit.text.toString()
            if (account == "admin" && password == "123456") {
                val editor = prefs.edit()
                if (rememberPass.isChecked) {
                    editor.putBoolean("remember_password", true)
                    editor.putString("account", account)
                    editor.putString("password", password)
                } else {
                    editor.clear()
                }
                editor.apply()
                Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show()
            }
        }
    }
}