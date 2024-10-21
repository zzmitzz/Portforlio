package com.example.portforlio.presentation.drivecontrol

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.portforlio.Constants
import com.example.portforlio.presentation.MainViewModel


@Composable

fun DriveControl(navController: NavController) {
    val viewModel: MainViewModel = viewModel()
    val context = LocalContext.current
    val exoPlayer = ExoPlayer.Builder(context).build()
    val resource = Constants.mediaResource
    LaunchedEffect(key1 = resource) {
        exoPlayer.setMediaItem(MediaItem.fromUri(resource))
        exoPlayer.prepare()
    }
    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    AndroidView(
        factory = { ctx ->
            PlayerView(ctx).apply {
                player = exoPlayer
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)   )
}