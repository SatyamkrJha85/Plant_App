package com.theapplicationpad.plantapp.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.theapplicationpad.plantapp.NavGraph.NavGraph
import com.theapplicationpad.plantapp.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController,modifier: Modifier = Modifier) {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.splash))

    LaunchedEffect(true){
        delay(2000)

        navController.navigate(NavGraph.Bottom.route){
            popUpTo(0)
            launchSingleTop=true
        }
    }


    Column {
        LottieAnimation(composition = composition, isPlaying = true, restartOnPlay = false, iterations = 4)
    }


}