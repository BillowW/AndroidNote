package com.example.cap6_sql

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sqllite.*

class SQLLite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqllite)

//      2. 创建实例，传入名字和版本号，通过writableDatabase方法写入
        val dbHelper = MyDatabaseHelper(this, "BookStore.db", 1)
        createDatabase.setOnClickListener {
            dbHelper.writableDatabase
        }

        val dbHelper2 = MyDatabaseHelper(this, "BookStore.db", 2)
        upgradeDatabase.setOnClickListener {
            dbHelper2.writableDatabase
        }

        addData.setOnClickListener {
//          1.0 使用助手
            val db = dbHelper.writableDatabase
//          1.1 创建ContentValues实例，通过apply方法加入值
            val values1 = ContentValues().apply {
                put("name", "The Da Vinci Code")
                put("author", "Dan Brown")
                put("pages", 454)
                put("price", 16.96)
            }
//          1.3 通过insert方法插入值
            db.insert("Book", null, values1)

//          2. 使用传统sql语句
            db.execSQL("insert into Book (name, author, pages, price) values(?, ?, ?, ?)",
                arrayOf("The Lost Symbol", "Dan Brown", "510", "19.95"))
        }

    }
}