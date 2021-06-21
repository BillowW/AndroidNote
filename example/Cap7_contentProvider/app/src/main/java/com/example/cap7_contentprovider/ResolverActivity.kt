package com.example.cap7_contentprovider

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_resolver2.*

private val contactsList = ArrayList<String>()
private lateinit var adapter: ArrayAdapter<String>

class ResolverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resolver2)

//      1. 通过Adapter传入信息给ListView
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactsList)
        contactsView.adapter = adapter

//      2. 判断是否已授权
        if (
            ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_CONTACTS),
                1
            )
        } else {
            readContacts()
        }
    }

//  3. 重写授权结果返回方法
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (
                    grantResults.isNotEmpty()
                    && grantResults[0]
                    == PackageManager.PERMISSION_GRANTED
                ) {
                    readContacts()
                } else {
                    Toast.makeText(
                        this,
                        "You denied the permission",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

//  4. 功能函数
    private fun readContacts() {
//      查询联系人数据
        contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null, null, null, null
        )?.apply {
//          逐行读取信息
            while (moveToNext()) {
//              获取联系人姓名
                val displayName = getString(
                    getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                )
//              获取联系人手机号
                val number = getString(
                    getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                )
//              加入数据
                contactsList.add("$displayName\n$number")
            }
//          更新adapter中数据
            adapter.notifyDataSetChanged()
            close()
        }
    }
}