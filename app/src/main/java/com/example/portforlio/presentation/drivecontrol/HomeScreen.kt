package com.example.portforlio.presentation.drivecontrol

import android.graphics.Paint.Align
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.provider.FontsContractCompat.Columns
import androidx.navigation.NavController
import com.example.portforlio.R


@Composable
fun ControllerResult(modifier: Modifier, textDirection: String, imageView: Int, progress: Float) {
    val velocity =  progress * 255
    Column(modifier = modifier) {
        if (imageView != 0 && progress != 0f) {
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(imageView),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.Blue)
            )
            Text(
                text = "$textDirection/$velocity",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.Black,
                fontSize = 24.sp,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier, navController: NavController) {
    var imageDirection by remember { mutableIntStateOf(0) }
    var textDirection by remember { mutableStateOf("") }
    val progress = remember { mutableFloatStateOf(0.5f) }
    // Currently for portrait only
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        DriveControl(navController = navController)
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//                .background(Color.Black)
//        )
        Spacer(
            modifier = Modifier.height(50.dp)
        )

        Box(
            modifier = Modifier
                .size(249.dp, 249.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(R.drawable._37380_200),
                contentDescription = "test",
                modifier = Modifier.fillMaxSize()
            )
            Column(modifier = Modifier.fillMaxSize()) {
                // UP
                Box(
                    modifier = Modifier
                        .size(83.dp)
                        .align(Alignment.CenterHorizontally)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                // Detect press
                                onLongPress = {
                                    textDirection = "UP"
                                    imageDirection =
                                        R.drawable.keyboard_double_arrow_up_24dp_e8eaed_fill0_wght400_grad0_opsz24
                                },
                                onPress = {
                                    tryAwaitRelease()
                                    textDirection = ""
                                    imageDirection = 0
                                }
                            )
                        }
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    // LEFT
                    Box(modifier = Modifier
                        .size(83.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                // Detect press
                                onLongPress = {
                                    textDirection = "LEFT"
                                    imageDirection =
                                        R.drawable.keyboard_double_arrow_left_24dp_e8eaed_fill0_wght400_grad0_opsz24
                                },
                                onPress = {
                                    tryAwaitRelease()
                                    textDirection = ""
                                    imageDirection = 0
                                }
                            )
                        }
                    )
                    // RIGHT
                    Box(modifier = Modifier
                        .size(83.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                // Detect press
                                onLongPress = {
                                    textDirection = "RIGHT"
                                    imageDirection =
                                        R.drawable.keyboard_double_arrow_right_24dp_e8eaed_fill0_wght400_grad0_opsz24
                                },
                                onPress = {
                                    tryAwaitRelease()
                                    textDirection = ""
                                    imageDirection = 0
                                }
                            )
                        }
                    )
                }
                // DOWN
                Box(
                    modifier = Modifier
                        .size(83.dp)
                        .align(Alignment.CenterHorizontally)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                // Detect press
                                onLongPress = {
                                    textDirection = "DOWN"
                                    imageDirection =
                                        R.drawable.keyboard_double_arrow_down_24dp_e8eaed_fill0_wght400_grad0_opsz24
                                },
                                onPress = {
                                    tryAwaitRelease()
                                    textDirection = ""
                                    imageDirection = 0
                                }
                            )
                        }
                )
            }
        }
        Spacer(
            modifier = Modifier.height(80.dp)
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)) {
            ControllerResult(
                modifier = Modifier.weight(1f),
                textDirection = textDirection,
                imageView = imageDirection,
                progress = progress.value
            )
            Column(modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)) {

                Slider(
                    modifier = Modifier
                        .width(180.dp)
                        .height(20.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(end = 8.dp),
                    value = progress.value,
                    colors = SliderColors(
                        thumbColor = Color.Gray,
                        activeTrackColor = Color.Blue,
                        inactiveTrackColor = Color.Gray,
                        disabledActiveTrackColor = Color.Gray,
                        disabledInactiveTrackColor = Color.Gray,
                        disabledThumbColor = Color.Gray,
                        disabledActiveTickColor = Color.Gray,
                        disabledInactiveTickColor = Color.Gray,
                        activeTickColor = Color.Blue,
                        inactiveTickColor = Color.Blue
                    ),
                    onValueChange = { newValue ->
                        progress.floatValue = newValue // Update the progress
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(modifier = Modifier, navController = NavController(LocalContext.current))
}