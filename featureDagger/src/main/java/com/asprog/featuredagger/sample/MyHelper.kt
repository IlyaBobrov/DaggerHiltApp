package com.asprog.featuredagger.sample

import android.content.Context
import android.util.Log
import android.widget.Toast
import javax.inject.Inject

interface MyHelper {
    fun showToast()
    fun showLog()
}

class MyHelperImpl @Inject constructor(private val context: Context) : MyHelper {
    override fun showToast() {
        Toast.makeText(context, "MyHelperImpl", Toast.LENGTH_SHORT).show()
        Log.e("TAG", "MyHelperImpl showToast")
    }

    override fun showLog() {
        Log.e("TAG", "MyHelperImpl")
    }
}