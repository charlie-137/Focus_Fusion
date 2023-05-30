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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brogrammer.byebyeprocrastination.screens.*
import com.brogrammer.byebyeprocrastination.ui.theme.ByeByeProcrastinationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            App()
            PreviewNavBar()
//            AddTask()
        }
    }
}


//@Composable
//fun App() {
//    val navController = rememberNavController()
//
//    NavHost(navController, startDestination = "taskListScreen") {
//        composable("taskListScreen") {
//            TaskListScreen()
//        }
//        composable("addTaskScreen") {
//            AddTask()
//        }
//    }
//}


