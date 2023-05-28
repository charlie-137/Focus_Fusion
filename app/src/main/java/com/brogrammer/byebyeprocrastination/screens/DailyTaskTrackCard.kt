package com.brogrammer.byebyeprocrastination.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize

@Composable
fun DailyTaskTrack() {
    Box(contentAlignment = Alignment.Center) {
        MyItemCard {
            Column() {
                DropDownMenu()
                Text(
                    text = "Daily Goal : ",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 25.dp)
                )
                Text(
                    text = "Completed : ",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 25.dp, bottom = 25.dp)
                )
            }


        }
    }


}

@Composable
fun MyItemCard(content: @Composable () -> Unit) {
    val originalColor = Color(0xFFF3F3F3)
    val darkerColor = lerp(originalColor, Color.Black, 0.02f)
    Card(
        modifier = Modifier.padding(16.dp),
        backgroundColor = darkerColor,
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp
    ) {
        content()
    }

}


@Composable
fun DropDownMenu() {

    var expanded by remember { mutableStateOf(false) }
    val list = listOf("Exercise", "Read Books", "Coding", "Watching Anime")
    var selectedItem by remember { mutableStateOf("") }

    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    Column(modifier = Modifier.padding(20.dp)) {
        val customTextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color.White
        )

        var selectedItem by remember { mutableStateOf("") }






//        OutlinedTextField(
//            value = selectedItem,
//            onValueChange = { selectedItem = it },
//            modifier = Modifier
//                .fillMaxWidth()
//                .onGloballyPositioned { coordinates ->
//                    textFieldSize = coordinates.size.toSize()
//                }
//                .clickable {
//                    expanded = !expanded
//                    // Perform click action here
//                    // For example, show a toast message
//
//                },
//            enabled = false,
//            label = if (selectedItem.isEmpty()) {
//                {
//                    Text(
//                        text = "Select Task",
//                        fontWeight = FontWeight.Bold,
//                        color = Color.Black,
//                        modifier = Modifier.align(Alignment.CenterHorizontally)
//                    )
//                }
//            } else {
//                { Text(text = "") }
//            },
//            textStyle = LocalTextStyle.current.copy(
//                color = Color.Black,
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Bold,
//                textAlign = TextAlign.Center,
//            ),
//            shape = RoundedCornerShape(16.dp),
//            colors = customTextFieldColors,
//            trailingIcon = {
//                Icon(icon, "", Modifier.clickable { expanded = !expanded })
//            }
//        )





        OutlinedTextField(
            value = selectedItem,
            onValueChange = { selectedItem = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            enabled = false,
            label = if (selectedItem.isEmpty()) {
                {
                    Text(
                        text = "Select Task",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            } else {
                { Text(text = "") }
            },
            textStyle = LocalTextStyle.current.copy(
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            ),
            shape = RoundedCornerShape(16.dp),
            colors = customTextFieldColors,
            trailingIcon = {
                Icon(icon, "", Modifier.clickable { expanded = !expanded })
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
        ) {

            list.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedItem = label
                    expanded = false
                }) {
                    Text(text = label)
                }
            }

        }

    }
}