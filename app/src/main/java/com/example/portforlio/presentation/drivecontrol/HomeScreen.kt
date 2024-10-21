package com.example.portforlio.presentation.drivecontrol

import android.graphics.Paint.Align
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
fun ControllerResult(modifier: Modifier, textDirection: String, imageView: Int) {
    val text = "Left/200"
    val image = R.drawable.keyboard_double_arrow_left_24dp_e8eaed_fill0_wght400_grad0_opsz24
    Column(modifier = modifier) {
        if(image != 0){
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
                ,
                painter = painterResource(image),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.Blue)
            )
            Text(text = text, modifier = Modifier.align(Alignment.CenterHorizontally), color = Color.Black, fontSize = 24.sp, fontFamily = FontFamily.Monospace)
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier, navController: NavController) {
    val imageDirection by remember { mutableIntStateOf(0) }
    val textDirection by remember { mutableStateOf("") }
    // Currently for portrait only
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
//        DriveControl(navController = navController)
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.Black))
        Spacer(
            modifier = Modifier.height(50.dp)
        )

        Box(modifier = Modifier
            .size(249.dp, 249.dp)
            .align(Alignment.CenterHorizontally)) {
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
                        .clickable {

                        }
                )
                Row(

                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    // LEFT
                    Box(modifier = Modifier
                        .size(83.dp)
                        .clickable{

                    })
                    // RIGHT
                    Box(modifier = Modifier
                        .size(83.dp)
                        .clickable {

                        })
                }
                // DOWN
                Box(
                    modifier = Modifier
                        .size(83.dp)
                        .align(Alignment.CenterHorizontally)
                        .clickable {

                        }
                )
            }
        }
        Spacer(
            modifier = Modifier.height(50.dp)
        )
        Row(modifier = Modifier.fillMaxWidth()){
            ControllerResult(modifier = Modifier.weight(1f), textDirection = textDirection, imageView = imageDirection)
            Column(modifier = Modifier.weight(1f).align(Alignment.CenterVertically)){
                LinearProgressIndicator(
                    progress = { 0.5f },
                    color = Color.Blue,
                    modifier = Modifier.width(180.dp).height(20.dp).rotate(-90f).align(Alignment.CenterHorizontally)
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