package com.asprog.featurehilt.ui.innerScreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.asprog.featurehilt.databinding.ActivityHiltInnerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HiltInnerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHiltInnerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHiltInnerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}