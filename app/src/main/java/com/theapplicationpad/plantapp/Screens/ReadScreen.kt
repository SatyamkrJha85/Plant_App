package com.theapplicationpad.plantapp.Screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.QrCodeScanner
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.theapplicationpad.plantapp.R
import com.theapplicationpad.plantapp.ui.theme.ButtonColor
import com.theapplicationpad.plantapp.ui.theme.LightWhite
import com.theapplicationpad.plantapp.ui.theme.LightWhite1
import com.theapplicationpad.plantapp.ui.theme.ReadBackground
import kotlinx.coroutines.delay

@Composable
fun ReadScreen(modifier: Modifier = Modifier) {

    var scale by remember { mutableStateOf(0.5f) }
    val animatedScale by animateFloatAsState(targetValue = scale)

    LaunchedEffect(Unit) {
        delay(300) // Optional: delay to start the animation
        scale = 1f
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = modifier
                .size(300.dp)
                .clip(CircleShape)
                .background(ReadBackground)
                .align(Alignment.TopCenter), contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.tree), contentDescription = null,
                modifier
                    .size(300.dp)
                    .scale(animatedScale)
            )
        }

        Box(
            modifier = modifier

                .width(150.dp)
                .padding(top = 160.dp, end = 10.dp)
                .height(60.dp)
                .clip(shape = RoundedCornerShape(14.dp))
                .background(LightWhite)
                .align(Alignment.TopEnd),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Text(
                    text = "Good growth", color = ButtonColor,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "24 days ago planted", color = Color.Gray, fontSize = 13.sp)
            }


        }


        Box(
            modifier = modifier
                .padding(top = 120.dp)
                .clip(RoundedCornerShape(topStart = 45.dp, topEnd = 45.dp))
                .fillMaxWidth()

                .wrapContentHeight()
                .background(ButtonColor)
                .align(Alignment.Center)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.QrCodeScanner,
                    contentDescription = null,
                    tint = Color.Black
                )
                Spacer(modifier = modifier.width(7.dp))
                Text(text = "Scan Your Plant", color = Color.Black)
            }

        }

        Box(
            modifier = modifier
                .clip(RoundedCornerShape(topStart = 45.dp, topEnd = 45.dp))
                .fillMaxWidth()
                .height(250.dp)
                .background(Color.White)
                .align(Alignment.BottomCenter)
        ) {

            Column(
                modifier.verticalScroll(rememberScrollState())
            ) {


                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Column(
                        modifier.padding(top = 10.dp, start = 20.dp)
                    ) {
                        Text(
                            text = "Artificial",
                            fontSize = 32.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Jade",
                            fontSize = 32.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Column(
                        modifier = modifier
                            .padding(end = 20.dp)
                    ) {
                        Box(
                            modifier = modifier
                                .size(60.dp)
                                .clip(shape = CircleShape)
                                .background(
                                    LightWhite1
                                ), contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                imageVector = Icons.Filled.FavoriteBorder,
                                contentDescription = null,
                                tint = Color.Gray,
                                modifier = modifier.size(35.dp)
                            )
                        }
                    }
                }

                Row {

                    Box(
                        modifier = modifier
                            .padding(end = 10.dp, top = 10.dp)
                            .clip(shape = RoundedCornerShape(25.dp))
                            .width(230.dp)
                            .height(130.dp)
                            .background(LightWhite1)
                    ) {

                        Column(
                            modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Green Plant",
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

                                    Text(
                                        text = "24°C",
                                        color = Color.Black,
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                        }
                    }

                    // light box

                    Box(
                        modifier = modifier
                            .padding(end = 5.dp, top = 10.dp,)
                            .clip(shape = RoundedCornerShape(25.dp))
                            .width(180.dp)
                            .height(150.dp)
                            .background(Color.White)
                    ) {

                        Column(
                            modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Box(
                                modifier = modifier
                                    .size(40.dp)
                                    .clip(shape = CircleShape)
                                    .background(
                                        ReadBackground
                                    ), contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.LightMode,
                                    contentDescription = null,
                                    tint = Color.Black
                                )
                            }

                            Column {
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(text = "Room Light",  color = Color.Black,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold)
                                 Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "60%",
                                    color = Color.Black,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.SemiBold
                                )

                            }

                        }

                    }

                }

                //







            }
        }


    }

}


@Preview(showSystemUi = true)
@Composable
private fun Homepreview12() {
    ReadScreen()
}
