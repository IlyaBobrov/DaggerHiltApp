package com.asprog.featuredagger.sample

import android.content.Context
import android.util.Log
import android.widget.Toast
import javax.inject.Inject

interface MyHelper {
    fun showToast(msg: String = "MyHelperImpl")
    fun showLog(msg: String = "MyHelperImpl")
}

class MyHelperImpl @Inject constructor(private val context: Context) : MyHelper {
    override fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        Log.e("TAG", "MyHelperImpl showToast")
    }

    override fun showLog(msg: String) {
        Log.e("TAG", msg)
    }
}