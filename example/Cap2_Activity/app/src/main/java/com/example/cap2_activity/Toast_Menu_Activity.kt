package com.example.cap2_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class Toast_Menu_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast_menu)
    }

//     重写menu方法
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

//    这里是kotlin的语法糖，很方便，不过我认为对练习者并不友好，因此我觉得有必要说清楚
//    事实上menuInflater是调用了父类的get方法，获取到了这样的一个对象，然后才能调用inflate方法
//    inflate方法给当前的Activity设置菜单，传入两个参数，一个是菜单的布局，返回true表示允许菜单显示
        menuInflater.inflate(R.menu.toast_menu, menu)
        return true
    }

    //    重写菜单选择响应行为
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

//        这里也是一样的item实际上调用了get方法
        when (item.itemId) {
            R.id.show_menu -> Toast.makeText(this, "You clicked Menu",
                Toast.LENGTH_SHORT).show()
            R.id.show_toast -> Toast.makeText(this, "You clicked Toast",
                Toast.LENGTH_SHORT).show()
        }
        return true
    }
}