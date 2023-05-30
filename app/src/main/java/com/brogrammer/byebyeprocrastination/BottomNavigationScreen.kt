package com.brogrammer.byebyeprocrastination

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationScreens(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object TaskListScreen : BottomNavigationScreens("taskList", "TaskList", Icons.Default.Add)
    object AddTask : BottomNavigationScreens("addTask", "addTask", Icons.Default.Add)

}
