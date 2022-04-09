package com.asprog.featuredagger.ui.innerScreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.asprog.featuredagger.databinding.ActivityDaggerInnerBinding
import com.asprog.featuredagger.di.DaggerWrapper
import com.asprog.featuredagger.sample.MyHelper
import javax.inject.Inject


class DaggerInnerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDaggerInnerBinding

    @Inject
    lateinit var myHelper: MyHelper

    override fun onCreate(savedInstanceState: Bundle?) {

        DaggerWrapper.mComponent.inject(this)

        super.onCreate(savedInstanceState)
        binding = ActivityDaggerInnerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    override fun onResume() {
        super.onResume()
        myHelper.showLog()
        myHelper.showToast()
    }

}
