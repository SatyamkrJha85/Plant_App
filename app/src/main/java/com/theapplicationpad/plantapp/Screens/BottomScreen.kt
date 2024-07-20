package com.theapplicationpad.plantapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.theapplicationpad.plantapp.NavGraph.NavGraph
import com.theapplicationpad.plantapp.R
import com.theapplicationpad.plantapp.ui.theme.ButtonColor
import com.theapplicationpad.plantapp.ui.theme.LightGreen

@Composable
fun BottomScreen(modifier: Modifier = Modifier) {



    val navController = rememberNavController()

    Scaffold(
        containerColor = Color.White,
        bottomBar = { MyBottomBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavGraph.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable( NavGraph.Home.route) {
                HomeScreen()
            }
            composable( NavGraph.Shop.route) {
                ShopScreen()
            }
            composable( NavGraph.Read.route) {
                ReadScreen()
            }
        }
    }
}




@Composable
fun MyBottomBar(navController: NavHostController) {

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    val (selectedRoute, setSelectedRoute) = remember { mutableStateOf(NavGraph.Home.route) }

    // Define navigation items
    val homeItem = BottomNavItem("Home", NavGraph.Home.route, Icons.Rounded.Home)
    val ShopItem = BottomNavItem("Shop", NavGraph.Shop.route, Icons.Rounded.Add)
    val Readitem = BottomNavItem("Read", NavGraph.Read.route, Icons.Rounded.Check)

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp, bottom = 10.dp)
            .padding(10.dp)
           // .background(Color.White)
            //.height(56.dp)

                ,
        shape = CircleShape,
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.elevatedCardElevation(10.dp)
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth().padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Left side IconButton
            IconButton(
                onClick = {
                    if (currentRoute != homeItem.route) {
                        navController.navigate(homeItem.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                        }
                        setSelectedRoute(homeItem.route)
                    }
                },

                // modifier = Modifier.padding(start = 16.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = homeItem.title,
                    tint = if (selectedRoute == homeItem.route) ButtonColor else Color.Gray,
                    modifier = Modifier.background(if (selectedRoute == homeItem.route) LightGreen else Color.White , CircleShape).padding(5.dp).size(34.dp)
                )


            }

            // Middle side IconButton
            IconButton(
                onClick = {
                    if (currentRoute != ShopItem.route) {
                        navController.navigate(ShopItem.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                        }
                        setSelectedRoute(ShopItem.route)
                    }
                },
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.shop),
                    contentDescription = homeItem.title,
                    tint = if (selectedRoute == ShopItem.route) ButtonColor else Color.Gray,
                    modifier = Modifier.background(if (selectedRoute == ShopItem.route) LightGreen else Color.White , CircleShape).padding(5.dp).size(34.dp)
                )
            }

            // Spacer for right side alignment
            //  Spacer(modifier = Modifier.weight(1f))

            // Right side IconButton
            IconButton(
                onClick = {
                    if (currentRoute != Readitem.route) {
                        navController.navigate(Readitem.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                        }
                        setSelectedRoute(Readitem.route)
                    }
                },
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.read),
                    contentDescription = homeItem.title,
                    tint = if (selectedRoute == Readitem.route) ButtonColor else Color.Gray,
                    modifier = Modifier.background(if (selectedRoute == Readitem.route) LightGreen else Color.White , CircleShape).padding(5.dp).size(34.dp)
                )
            }
        }
    }
}

data class BottomNavItem(
    val title: String,
    val route: String,
    val icon: ImageVector,
    val secondicon:Int=0
)


@Preview(showSystemUi = true)
@Composable
private fun nav() {
    MyBottomBar(navController = rememberNavController())
}