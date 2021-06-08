package com.example.cap4_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.left_fragment1.*

class Fragment2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment2)

//        按钮点击更换布局
        button.setOnClickListener {
            replaceFragment(RightFragment2())
        }

//        默认布局
        replaceFragment(RightFragment1())
    }

    private fun replaceFragment(fragment: Fragment) {
//        1. 传入fragment实例
//        2. 创建fragmentManager实例
        val fragmentManager = supportFragmentManager
//        3. 开启事务
        val transaction = fragmentManager.beginTransaction()
//        4. 通过replace方法更换布局，传入待更换布局的id以及更换的布局(传入参数)
        transaction.replace(R.id.rightFrag, fragment)
//        加入返回栈
        transaction.addToBackStack(null)
//        5. 提交
        transaction.commit()
    }
}