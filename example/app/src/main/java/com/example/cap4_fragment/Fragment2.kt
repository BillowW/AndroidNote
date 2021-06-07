package com.example.cap4_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.left_fragment1.*

class Fragment2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment2)

        button.setOnClickListener {
            replaceFragment(RightFragment2())
        }
        replaceFragment(RightFragment1())
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.rightFrag, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}