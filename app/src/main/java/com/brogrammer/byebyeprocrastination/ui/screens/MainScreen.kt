package com.brogrammer.byebyeprocrastination.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.brogrammer.byebyeprocrastination.ui.navigation.AppNavGraph
import com.brogrammer.byebyeprocrastination.ui.navigation.BottomNavDestination

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        it.calculateBottomPadding()
        AppNavGraph(navController)
    }
}

@Composable
fun BottomNavigationBar(
    navController: NavController,
) {
    val destinations = listOf(
        BottomNavDestination.TimerDestination,
        BottomNavDestination.TaskListDestination,
        BottomNavDestination.SettingsDestination
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation(
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {
        destinations.forEach {
            AddItem(
                screen = it,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: BottomNavDestination,
    currentDestination: NavDestination?,
    navController: NavController
) {
    val selected = currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true
    BottomNavigationItem(
        selectedContentColor = Color.Green,
        unselectedContentColor = Color.Gray,
        selected = selected,
        icon = {
            Column(horizontalAlignment = CenterHorizontally) {
                if (screen.badgeCount > 0) {
                    BadgedBox(
                        badge = {
                            Text(text = screen.badgeCount.toString())
                        }
                    ) {
                        Icon(
                            imageVector = screen.icon,
                            contentDescription = screen.title
                        )
                    }
                } else {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = screen.title
                    )
                }
                if (selected) {
                    Text(
                        text = screen.title,
                        textAlign = TextAlign.Center,
                        fontSize = 10.sp
                    )
                }
            }
        },
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = false
                }
                launchSingleTop = true
            }
        },
    )
}