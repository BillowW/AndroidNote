package com.example.cap3_ui

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.fruit_item.view.*

//第三步，新建适配器类型，泛型指定为Fruit类
//适配器继承自ArrayAdapter,传入activity,listview子项布局ID和数据
class FruitAdapter(activity: Activity, val resourceId: Int, data: List<Fruit>) :
    ArrayAdapter<Fruit>(activity, resourceId, data) {
//    重写getView方法
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View
//        优化ListView的效率
        if (convertView == null) {
            //      通过LayoutInflater方法传入布局
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
        } else {
//          倘若已存在则调用缓存
            view = convertView
        }


//      获取Fruit实例
        val fruit = getItem(position)
        if (fruit != null) {

//            修改数据
            view.fruitImage.setImageResource(fruit.imageId)
            view.fruitName.text = fruit.name
        }
        return view
    }
}