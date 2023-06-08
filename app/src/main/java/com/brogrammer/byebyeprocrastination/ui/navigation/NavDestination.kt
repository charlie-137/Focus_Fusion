package com.brogrammer.byebyeprocrastination.ui.navigation

sealed class NavDestination(val route: String) {
    object AddTask : NavDestination("add_task")
}