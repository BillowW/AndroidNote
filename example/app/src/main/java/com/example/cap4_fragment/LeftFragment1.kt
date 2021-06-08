package com.example.cap4_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

//第二步，设置Fragment类，加载Fragment视图
class LeftFragment1: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        通过inflate方法动态加载fragment的layout
        return inflater.inflate(R.layout.left_fragment1, container, false)
    }
}