package com.asprog.featuredagger.ui.innerScreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.asprog.featuredagger.R
import com.asprog.featuredagger.databinding.ActivityDaggerInnerBinding
import com.asprog.featuredagger.di.deps.AppDependencyComponentViewModel
import com.asprog.featuredagger.sample.MyHelper
import javax.inject.Inject


class DaggerInnerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDaggerInnerBinding
    private lateinit var navController: NavController

    @Inject
    lateinit var myHelper: MyHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        ViewModelProvider(this)
            .get<AppDependencyComponentViewModel>()
            .newAppDependencyComponent
            .inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityDaggerInnerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onResume() {
        super.onResume()
        myHelper.showLog()
    }

}
