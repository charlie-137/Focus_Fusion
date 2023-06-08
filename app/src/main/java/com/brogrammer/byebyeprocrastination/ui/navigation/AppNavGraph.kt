package com.brogrammer.byebyeprocrastination.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.brogrammer.byebyeprocrastination.ui.screens.addtask.AddTask
import com.brogrammer.byebyeprocrastination.ui.screens.settings.SettingsScreen
import com.brogrammer.byebyeprocrastination.ui.screens.tasklist.TaskListScreen
import com.brogrammer.byebyeprocrastination.ui.screens.timer.TimerScreen

@Composable
fun AppNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomNavDestination.TimerDestination.route
    ) {
        composable(route = BottomNavDestination.TimerDestination.route) {
            TimerScreen()
        }
        composable(route = BottomNavDestination.TaskListDestination.route) {
            TaskListScreen(navController = navHostController)
        }
        composable(route = BottomNavDestination.SettingsDestination.route) {
            SettingsScreen(navController = navHostController)
        }
        composable(route = NavDestination.AddTask.route) {
            AddTask(navController = navHostController)
        }
    }
}