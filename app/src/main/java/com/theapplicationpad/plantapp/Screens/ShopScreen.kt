package com.theapplicationpad.plantapp.Screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lightbulb
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
import com.theapplicationpad.plantapp.Model.ShopPlant
import com.theapplicationpad.plantapp.Model.ShopPlantData
import com.theapplicationpad.plantapp.R
import com.theapplicationpad.plantapp.ui.theme.ButtonColor
import com.theapplicationpad.plantapp.ui.theme.LightWhite
import com.theapplicationpad.plantapp.ui.theme.LightWhite1
import com.theapplicationpad.plantapp.ui.theme.PlantBGGreen
import kotlinx.coroutines.delay

@Composable
fun ShopScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Header()
            TextSection1()
            ShopBox()
            ShopTextRow()
            ShopPlantGrid(modifier = Modifier.weight(1f))
        }
    }
}


@Composable
fun TextSection1(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Plants",
            fontSize = 28.sp,
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = "Market",
            fontSize = 26.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )

    }

}


@Composable
fun ShopBox(modifier: Modifier = Modifier) {

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
            .height(180.dp)
            .clip(shape = RoundedCornerShape(30.dp))
            .background(ButtonColor)
    ) {

        Column(
            modifier
                .align(
                    Alignment.CenterStart
                )
                .padding(start = 10.dp)
        ) {

            Text(text = "Plant Home", color = Color.White)
            Text(text = "New",color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
            Text(text = "Collection",color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
            Text(text = "789+ New Plant added ",color = Color.White, fontWeight = FontWeight.Normal)

        }

        Image(
            painter = painterResource(id = R.drawable.succulenttree1),
            contentDescription = null,
            modifier
                .align(
                    Alignment.TopEnd
                )
                .scale(animatedScale)

        )



        Spacer(modifier = Modifier.height(10.dp))


    }
}


@Composable
fun ShopTextRow(modifier: Modifier = Modifier) {
    Row(
        modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Plant",
            fontSize = 20.sp,
            color = PlantBGGreen,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.width(35.dp))
        Text(
            text = "Accessories",
            fontSize = 20.sp,
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(15.dp))

    }
}


    @Composable
    fun FlowerBoxShop(shopPlant: ShopPlant, modifier: Modifier = Modifier) {
        Column (
            modifier = modifier
                .padding(10.dp)
        ){
            Box(modifier = modifier

                .clip(shape = RoundedCornerShape(20.dp))
                .width(150.dp)
                .height(180.dp)
                .background(LightWhite1), contentAlignment = Alignment.Center){
                Image(painter = painterResource(id = shopPlant.img), contentDescription =null )
            }
            Text(text = "${shopPlant.name}",modifier.padding(start = 8.dp), color = Color.Black, fontWeight = FontWeight.SemiBold, fontSize = 18.sp,)

            Text(text = "${shopPlant.days}", modifier.padding(start = 8.dp),color = Color.Black, fontWeight = FontWeight.Normal, fontSize = 14.sp)

        }
    }


@Composable
fun ShopPlantGrid(modifier: Modifier = Modifier) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(ShopPlantData) { Shopplant ->
            FlowerBoxShop(shopPlant = Shopplant)
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun Homepreview1() {
    ShopScreen()
}
