package com.theapplicationpad.plantapp.NavGraph

sealed class NavGraph(val route:String){
    object Splash: NavGraph("Splash")
    object Bottom: NavGraph("Bottom")
    object Home: NavGraph("Home")
    object Shop: NavGraph("Shop")
    object Read: NavGraph("Read")
}