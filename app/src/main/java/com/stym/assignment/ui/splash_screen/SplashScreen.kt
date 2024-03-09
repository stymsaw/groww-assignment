package com.stym.assignment.ui.splash_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.stym.assignment.R
import com.stym.assignment.navigation.Pages
import com.stym.assignment.viewmodel.SplashScreenVM
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavHostController?) {
    val viewModel = viewModel<SplashScreenVM>()
    LaunchedEffect(true) {
        delay(2000)
        navController?.navigate(Pages.HOME.name)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(viewModel.backgroundColor)
            .padding(100.dp)
    ) {


        Image(
            painter = painterResource(id = R.drawable.spotify_icon),
            contentDescription = "app icon"
        )


    }
}


@Preview
@Composable
fun PreviewSplash() {
    SplashScreen(null)
}
