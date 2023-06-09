package com.brogrammer.byebyeprocrastination.ui.screens.tasklist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.brogrammer.byebyeprocrastination.ui.navigation.NavDestination


@Composable
fun TaskListScreen(navController: NavController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box() {
            Text(
                text = "Task List",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(start = 20.dp, top = 10.dp)
                    .align(Alignment.TopStart)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        AddIconComposable(onClick = {
            navController.navigate(NavDestination.AddTask.route)
        /* Handle the click event */ })
    }


}


@Composable
fun AddIconComposable(onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier.padding(top = 10.dp, end = 10.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add Tasks",
            modifier = Modifier
                .size(35.dp)
                .clickable(
                    interactionSource = interactionSource,
                    indication = rememberRipple(bounded = false),
                    onClick = onClick
                )
        )
    }

}