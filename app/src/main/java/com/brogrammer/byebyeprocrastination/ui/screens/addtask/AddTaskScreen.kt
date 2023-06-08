package com.brogrammer.byebyeprocrastination.ui.screens.addtask


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Timelapse
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AddTask(navController: NavController) {
    var taskName by remember {
        mutableStateOf("")
    }

    var minutesPerDay by remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            CloseIconComposable(onClick = { navController.popBackStack() })

            Text(
                text = "Add Task",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(start = 20.dp, top = 10.dp)
            )

            Spacer(modifier = Modifier.weight(1f))
            SaveIconComposable(onClick = { /* Handle The Click Event */ })


        }


//            Text(
//                text = "Add Task",
//                fontWeight = FontWeight.Bold,
//                fontSize = 25.sp,
//                textAlign = TextAlign.Start,
//                modifier = Modifier.padding(start = 10.dp, top = 10.dp)
//            )


        Text(
            text = "Task title : ",
            fontSize = 16.sp,
//            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(top = 32.dp, start = 35.dp)
                .align(Alignment.Start)
        )
        TextField(
            value = taskName,
            onValueChange = { newValue ->
                taskName = newValue
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, start = 32.dp, end = 32.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFFF5F5F5),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(15.dp),
            textStyle = LocalTextStyle.current.copy(
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal
            )
        )

        Text(
            text = "Minutes per day : ",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(top = 16.dp, start = 35.dp)
                .align(Alignment.Start)
        )
        TextField(
            value = minutesPerDay,
            onValueChange = { newValue ->
                minutesPerDay = newValue
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, start = 32.dp, end = 32.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFFF5F5F5),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(15.dp),
            textStyle = LocalTextStyle.current.copy(
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Text(
            text = "Icon : ",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(top = 30.dp, start = 35.dp)
                .align(Alignment.Start)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 30.dp, top = 8.dp)
                .fillMaxWidth()
        ) {
            SquareIconButton(onClick = { /*  Implement the onclick functions  */})

        }
    }

}


@Composable
fun SquareIconButton(onClick: () -> Unit) {

    val interactionSource = remember { MutableInteractionSource() }

    val selectedIcon = remember {
        mutableStateOf(Icons.Default.Timelapse)
    }

    Box(
        modifier = Modifier
            .size(65.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(Color(0xFFF5F5F5))
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(bounded = true),
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = selectedIcon.value,
            contentDescription = "Selected Icon",
            tint = Color.Black,
            modifier = Modifier.size(38.dp)
        )
    }
}


@Composable
fun CloseIconComposable(onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier.padding(start = 10.dp, top = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close Button",
            modifier = Modifier
                .size(30.dp)
                .clickable(
                    interactionSource = interactionSource,
                    indication = rememberRipple(bounded = false),
                    onClick = onClick
                )
        )
    }

}


//@Composable
//fun CloseIconComposable(onClick: () -> Unit) {
//    val interactionSource = remember { MutableInteractionSource() }
//
//    Box(
//        modifier = Modifier
//            .padding(start = 10.dp, top = 10.dp)
//            .clickable(
//                interactionSource = interactionSource,
//                indication = rememberRipple(bounded = false),
//                onClick = onClick
//            ),
//        contentAlignment = Alignment.Center
//    ) {
//        Icon(
//            imageVector = Icons.Default.Close,
//            contentDescription = "Check Circle",
//            modifier = Modifier.size(30.dp)
//        )
//    }
//}


//@Composable
//fun CloseIconComposable(onClick: () -> Unit) {
//    Box(
//        modifier = Modifier.padding(start = 10.dp, top = 10.dp),
//        contentAlignment = Alignment.Center
//    ) {
//        Icon(
//            imageVector = Icons.Default.Close,
//            contentDescription = "Check Circle",
//            modifier = Modifier.size(30.dp)
//                .clickable(onClick = onClick)
//        )
//    }
//
//}


@Composable
fun SaveIconComposable(onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier.padding(top = 10.dp, end = 10.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Icon(
            imageVector = Icons.Default.Save,
            contentDescription = "Check Circle",
            modifier = Modifier
                .size(30.dp)
                .clickable(
                    interactionSource = interactionSource,
                    indication = rememberRipple(bounded = false),
                    onClick = onClick
                )
        )
    }

}





