package com.brogrammer.byebyeprocrastination.ui.screens.timer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.brogrammer.byebyeprocrastination.ui.screens.tasklist.TaskListScreen

@Composable
fun TimerScreen() {
    Text(
        text = "Timer",
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        textAlign = TextAlign.Start,
        modifier = Modifier.padding(start = 10.dp, top = 10.dp)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            DailyTaskTrack()
            PreviewScreen()
        }
    }
}

@Composable
fun ListScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
//        contentAlignment = Alignment.Center
    ) {
        TaskListScreen(navController)
//        Text(text = "List Screen")
    }
}



