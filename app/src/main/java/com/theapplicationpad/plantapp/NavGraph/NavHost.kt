package com.theapplicationpad.plantapp.NavGraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theapplicationpad.plantapp.Screens.BottomScreen
import com.theapplicationpad.plantapp.Screens.SplashScreen

@Composable
fun NavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    androidx.navigation.compose.NavHost(navController = navController, startDestination = NavGraph.Splash.route ){
        composable(NavGraph.Splash.route){
            SplashScreen(navController)
        }

        composable(NavGraph.Bottom.route){
            BottomScreen()
        }
    }
}