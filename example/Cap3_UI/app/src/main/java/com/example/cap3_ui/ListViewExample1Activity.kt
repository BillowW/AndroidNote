package com.example.cap3_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view_example1.*

class ListViewExample1Activity : AppCompatActivity() {

//    第二步，准备数据
    private val data = listOf<String>("Apple", "Banana", "Orange", "Watermelon",
        "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango", "Apple", "Banana", "Orange", "Watermelon",
        "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_example1)

//        第三步，设置适配器，参数this，layout文件，数据
//        通过适配器将数据绑定到ListView中(适配器View)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
        listView1.adapter = adapter
        listView1.setOnItemClickListener { parent, view, position, id ->
            val name = data[position]
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
        }
    }
}