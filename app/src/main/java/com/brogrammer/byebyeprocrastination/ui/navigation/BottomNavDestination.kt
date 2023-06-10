package com.brogrammer.byebyeprocrastination.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavDestination(
    val title: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int = 0
) {
    object TimerDestination : BottomNavDestination("Timer", "timer", Icons.Default.Alarm)
    object TaskListDestination : BottomNavDestination("Tasks", "task_list", Icons.Default.List)
    object SettingsDestination :
        BottomNavDestination("Settings", "settings", Icons.Default.Settings)
}
