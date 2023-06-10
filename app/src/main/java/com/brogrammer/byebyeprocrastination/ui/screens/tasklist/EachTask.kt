package com.brogrammer.byebyeprocrastination.ui.screens.tasklist


import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private const val EXPAND_ANIMATION_DURATION = 300
private const val FADE_IN_ANIMATION_DURATION = 350
private const val FADE_OUT_ANIMATION_DURATION = 200
private const val COLLAPSE_ANIMATION_DURATION = 300

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun EachTask(
//    card: ExpandableCardModel, data class to define card
    onCardArrowClick: () -> Unit = {},
    expanded: Boolean = true,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val transitionState = remember {
        MutableTransitionState(expanded).apply {
            targetState = !expanded
        }
    }

    val originalColor = Color(0xFFF3F3F3)
    val darkerColor = lerp(originalColor, Color.Black, 0.02f)


    val transition = updateTransition(transitionState, label = "transition")
    val arrowRotationDegree by transition.animateFloat({
        tween(durationMillis = EXPAND_ANIMATION_DURATION)
    }, label = "rotationDegreeTransition") {
        if (expanded) 0f else 180f
    }

    Card(

        modifier = Modifier
            .padding(16.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(bounded = true),
                onClick = onClick
            ),
        backgroundColor = darkerColor,
        elevation = 8.dp
//        shape = Shapes.medium,
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(
//                horizontal = 8.dp,
//                vertical = 8.dp
//            )
    ) {


        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Timelapse,
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier
                    .size(75.dp)
                    .padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Programming ",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 5.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Timer,
                        contentDescription = "",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(25.dp)
                    )
                    Text(
                        text = "0/2 min",
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }

            }


//            Icon(
//                imageVector = Icons.Default.PlayCircleOutline,
//                contentDescription = "",
//                tint = Color.Black,
//                modifier = Modifier
//                    .size(65.dp)
//                    .padding(top = 10.dp, bottom = 10.dp, end = 10.dp)
//            )

            PlayIconComposable(onClick = {/* Handle The Event */ })

        }


//        Row() {
//            Icon(
//                imageVector = Icons.Default.Timelapse, contentDescription = "",
//                tint = Color.Black,
//                modifier = Modifier
//                    .size(75.dp)
//                    .padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
//            )
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
//                    .fillMaxWidth()
//            ) {
//                    Text(
//                        text = "Daily goal : ",
//                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier.padding(start = 0.dp)
//                    )
//                    Text(
//                        text = "Completed : ",
//                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier.padding(start = 0.dp, bottom = 0.dp)
//                    )
//
//            }
//        }


        Column {
            Box {
                CardArrow(
                    degrees = arrowRotationDegree,
                    onClick = onCardArrowClick
                )
            }
            ExpandableContent(visible = expanded)
        }
    }
}

@Composable
fun CardArrow(
    degrees: Float,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        content = {
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = "Expandable Arrow",
                modifier = Modifier.rotate(degrees),
            )
        }
    )
}

@Composable
fun CardHeader(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        textAlign = TextAlign.Center,
    )
}


@Composable
fun ExpandableContent(
    visible: Boolean = true,
) {
    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = FADE_IN_ANIMATION_DURATION,
                easing = FastOutLinearInEasing
            )
        )
    }
    val enterExpand = remember {
        expandVertically(animationSpec = tween(EXPAND_ANIMATION_DURATION))
    }
    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = FADE_OUT_ANIMATION_DURATION,
                easing = LinearOutSlowInEasing
            )
        )
    }
    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(COLLAPSE_ANIMATION_DURATION))
    }
    AnimatedVisibility(
        visible = visible,
        enter = enterExpand + enterFadeIn,
        exit = exitCollapse + exitFadeOut
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Spacer(modifier = Modifier.heightIn(25.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.End
            ) {


                EditIconComposable(onClick = { /* Handle The Click Event */ } )
                DeleteIconComposable(onClick = { /* Handle The Click Event */ } )


//                Icon(
//                    imageVector = Icons.Default.Edit,
//                    contentDescription = "",
//                    tint = Color.Black,
//                    modifier = Modifier.size(27.dp)
//                )
//                Icon(
//                    imageVector = Icons.Default.Delete,
//                    contentDescription = "",
//                    tint = Color.Black,
//                    modifier = Modifier
//                        .padding(start = 25.dp, end = 5.dp)
//                        .size(27.dp)
//                )
            }
        }
    }

}


@Preview
@Composable
fun PreviewCard() {
    var expandedState by remember { mutableStateOf(false) }
    EachTask(
        expanded = expandedState,
        onCardArrowClick = {
            expandedState = !expandedState
        },
        onClick = {
            expandedState = !expandedState
            /* Handle Click Event */
        }
    )
}


@Composable
fun PlayIconComposable(onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .padding(top = 10.dp, bottom = 10.dp, end = 10.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Icon(
            imageVector = Icons.Default.PlayCircleOutline,
            contentDescription = "Play Button",
            modifier = Modifier
                .size(45.dp)
                .clickable(
                    interactionSource = interactionSource,
                    indication = rememberRipple(bounded = false),
                    onClick = onClick
                )
        )
    }

}


@Composable
fun EditIconComposable(onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }


    Box(
        modifier = Modifier
            .padding(start = 50.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Icon(
            imageVector = Icons.Default.Edit,
            contentDescription = "Edit Button",
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

@Composable
fun DeleteIconComposable(onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .padding(start = 20.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "Edit Button",
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


//Icon(
//imageVector = Icons.Default.Edit,
//contentDescription = "",
//tint = Color.Black,
//modifier = Modifier.size(27.dp)
//)


//Icon(
//imageVector = Icons.Default.PlayCircleOutline,
//contentDescription = "",
//tint = Color.Black,
//modifier = Modifier
//.size(65.dp)
//.padding(top = 10.dp, bottom = 10.dp, end = 10.dp)
//)