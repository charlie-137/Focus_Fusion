package com.brogrammer.byebyeprocrastination

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.brogrammer.byebyeprocrastination.screens.PreviewNavBar
import com.brogrammer.byebyeprocrastination.screens.PreviewScreen
import com.brogrammer.byebyeprocrastination.screens.Timer
import com.brogrammer.byebyeprocrastination.ui.theme.ByeByeProcrastinationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewNavBar()
        }
    }
}

