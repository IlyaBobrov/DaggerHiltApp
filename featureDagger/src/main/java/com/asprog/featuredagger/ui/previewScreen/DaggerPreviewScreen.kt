package com.asprog.featuredagger.ui.previewScreen

import android.content.Intent
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.asprog.featuredagger.ui.innerScreen.DaggerInnerActivity
import com.baseapp.base_ui_kit.scaffold.BaseTopBar


@ExperimentalAnimationApi
@Composable
fun DaggerPreviewScreen() {
    val context = LocalContext.current

    val i = Intent(context, DaggerInnerActivity::class.java)
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {
        Log.e("TAG", "${it.resultCode}")
    }

    Scaffold(topBar = { BaseTopBar(titleString = "Hilt preview screen") }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { launcher.launch(i) }) {
                Text(text = "Открыть активити")
            }
        }
    }
}