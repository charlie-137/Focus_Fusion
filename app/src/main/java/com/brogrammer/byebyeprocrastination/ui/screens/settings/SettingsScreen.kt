package com.brogrammer.byebyeprocrastination.ui.screens.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.brogrammer.byebyeprocrastination.ui.screens.tasklist.PreviewCard


@Composable
fun SettingsScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        PreviewCard()
//        Text(text = "Settings Screen")
    }
}
