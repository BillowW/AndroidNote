package com.example.cap6_sql

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_file.*
import java.io.*
import java.lang.StringBuilder

class File : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file)

//      调用方法，读取数据
        val inputText = load()
        if (inputText.isNotEmpty()) {
            showText.text = inputText
        }
    }

//    重写方法，保证activity在销毁时会保存数据
    override fun onDestroy() {
        super.onDestroy()
        val inputText = editText.text.toString()
        save(inputText)
    }

//    保存信息函数
    private fun save(inputText: String) {
//    异常检测
        try {
//          1. 获取一个FileOutputStream对象
            val output = openFileOutput("data", Context.MODE_PRIVATE)
//          2. 构建出BufferedWriter对象，然后通过该对象写入信息到文件中
            val writer = BufferedWriter(OutputStreamWriter(output))
//          3. use函数会自动关闭外层对象流，在这里用write写入文件信息
            writer.use {
                it.write(inputText)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

//    读取信息函数
    private fun load(): String {
        val content = StringBuilder()
        try {
//          1. 构建出FileInputStream对象
            val input = openFileInput("data")
//          2. 构建出BufferedReader对象读取文件信息
            val reader = BufferedReader(InputStreamReader(input))
//          3. 一行行读取文件，通过StringBuilder构件字符串
            reader.use {
                reader.forEachLine {
                    content.append(it)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
//      4. 返回字符串
        return content.toString()
    }
}