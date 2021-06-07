package com.example.cap3_ui

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.title.view.*

//新建类继承自LinearLayout
class TitleLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

//    初始化函数,对标题栏动态加载
    init {
//    对标题栏动态加载使用.from方法构造出一个LayoutInflater对象,调用inflate方法加载布局文件
        LayoutInflater.from(context).inflate(R.layout.title, this)

//    设置点击事件
        titleBack.setOnClickListener {
//            强制转换context为activity
            val activity = context as Activity
            activity.finish()
        }

        titleEdit.setOnClickListener {
            Toast.makeText(context, "you clicked edit button", Toast.LENGTH_SHORT).show()
        }
    }



}