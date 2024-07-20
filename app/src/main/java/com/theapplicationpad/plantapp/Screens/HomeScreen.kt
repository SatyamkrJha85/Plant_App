package com.theapplicationpad.plantapp.Screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.MarkChatUnread
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.theapplicationpad.plantapp.Model.HomePlant
import com.theapplicationpad.plantapp.Model.HomePlantData
import com.theapplicationpad.plantapp.R
import com.theapplicationpad.plantapp.ui.theme.ButtonColor
import com.theapplicationpad.plantapp.ui.theme.LightGray
import com.theapplicationpad.plantapp.ui.theme.LightGreen
import com.theapplicationpad.plantapp.ui.theme.LightPurple
import com.theapplicationpad.plantapp.ui.theme.LightWhite
import com.theapplicationpad.plantapp.ui.theme.LightWhite1
import com.theapplicationpad.plantapp.ui.theme.PlantBGGreen
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxSize()) {
            Header()
            TextSection()
            PlantBox()
            TextRow()
            HomePlantGrid(modifier = Modifier.weight(1f))
        }
    }

}



@Composable
fun Header(modifier: Modifier = Modifier) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.logo), contentDescription = null,
                modifier
                    .size(50.dp)
                    .clip(
                        CircleShape
                    )
            )
        }

        Row(
            modifier = Modifier
                .background(LightGreen, CircleShape)
                .height(55.dp)
                .border(
                    2.dp, LightGray,
                    CircleShape
                )
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = modifier
                    .size(40.dp)
                    .background(Color.LightGray, CircleShape), contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.LightMode,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
            Spacer(modifier = Modifier.width(25.dp))
            Icon(
                imageVector = Icons.Filled.MarkChatUnread,
                contentDescription = null,
                tint = Color.Black
            )

        }
    }
}

@Composable
fun TextSection(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Manage Your",
            fontSize = 28.sp,
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Home Plants",
            fontSize = 26.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
    }
}


@Composable
fun PlantBox(modifier: Modifier = Modifier) {

    var scale by remember { mutableStateOf(0.5f) }
    val animatedScale by animateFloatAsState(targetValue = scale)

    LaunchedEffect(Unit) {
        delay(300) // Optional: delay to start the animation
        scale = 1f
    }

    Box(
        modifier = modifier
            .padding(start = 10.dp, end = 10.dp, bottom = 5.dp, top = 10.dp)
            .fillMaxWidth()
            .height(220.dp)
            .clip(shape = RoundedCornerShape(25.dp))
            .background(ButtonColor)
    ) {

        Image(
            painter = painterResource(id = R.drawable.succulenttree),
            contentDescription = null,
            modifier
                .align(
                    Alignment.CenterStart
                )
                .scale(animatedScale)
                .size(220.dp)
                .padding(end = 45.dp)
        )

        Box(
            modifier = modifier
                .align(Alignment.TopEnd)
                .padding(end = 10.dp, top = 10.dp)
                .clip(shape = RoundedCornerShape(25.dp))
                .width(230.dp)
                .height(120.dp)
                .background(Color.White)
        ) {

            Column(
                modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Succulent",
                    color = ButtonColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "12 days ago planted",
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Box(
                modifier = modifier
                    .padding(10.dp)
                    .clip(shape = RoundedCornerShape(25.dp))
                    .background(LightWhite)
                    .fillMaxWidth()
                    .height(60.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Row(
                    modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Row {
                        Box(
                            modifier = modifier
                                .size(40.dp)
                                .clip(shape = CircleShape)
                                .background(
                                    Color.White
                                ), contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Thermostat,
                                contentDescription = null,
                                tint = ButtonColor
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(40.dp))

                    Column {
                        Text(text = "Room temp", color = Color.Gray)
                       // Spacer(modifier = Modifier.height(5.dp))

                        Text(text = "24°C", color = Color.Black, fontSize = 22.sp , fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))


        Box(modifier = modifier
            .align(Alignment.BottomEnd)
            .padding(end = 10.dp, top = 10.dp, bottom = 10.dp)
            .clip(shape = RoundedCornerShape(25.dp))
            .width(220.dp)
            .height(70.dp)
            .background(PlantBGGreen)){

                Row(
                    modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Row {
                        Box(
                            modifier = modifier
                                .size(40.dp)
                                .clip(shape = CircleShape)
                                , contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Lightbulb,
                                contentDescription = null,
                                modifier.size(50.dp),
                                tint = Color.White
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text(text = "Room Light", color = Color.White)
                        // Spacer(modifier = Modifier.height(5.dp))

                        Text(text = "56%", color = Color.White, fontSize = 22.sp , fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }
    }

@Composable
fun TextRow(modifier: Modifier = Modifier) {
    Row (
        modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "New Plant", fontSize = 20.sp, color = PlantBGGreen, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.width(35.dp))
        Text(text = "Harvested", fontSize = 20.sp, color = Color.Gray, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(15.dp))

    }
}




@Composable
fun FlowerBox(homePlant: HomePlant,modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .padding(10.dp)
    ){
        Box(modifier = modifier

            .clip(shape = RoundedCornerShape(20.dp))
            .width(150.dp)
            .height(180.dp)
            .background(LightWhite1), contentAlignment = Alignment.Center){
            Image(painter = painterResource(id = homePlant.img), contentDescription =null )
        }
        Text(text = "${homePlant.name}",modifier.padding(start = 8.dp), color = Color.Black, fontWeight = FontWeight.SemiBold, fontSize = 18.sp,)
        Text(text = "${homePlant.days} days to harvest", modifier.padding(start = 8.dp),color = Color.Black, fontWeight = FontWeight.Normal, fontSize = 14.sp)

    }
}

@Composable
fun HomePlantGrid(modifier: Modifier = Modifier) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
        ) {
            items(HomePlantData) { homePlant ->
                FlowerBox(homePlant = homePlant)
            }
        }
}



@Preview(showSystemUi = true)
@Composable
private fun Homepreview() {
    HomeScreen()
}