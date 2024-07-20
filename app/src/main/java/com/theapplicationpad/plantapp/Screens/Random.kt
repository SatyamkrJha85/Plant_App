package com.theapplicationpad.plantapp.Screens

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlin.math.cos
import kotlin.math.sin

@Preview(showSystemUi = true)
@Composable
fun AnalogClock() {
    val calendar = Calendar.getInstance()
    val hours = calendar.get(Calendar.HOUR)
    val minutes = calendar.get(Calendar.MINUTE)
    val seconds = calendar.get(Calendar.SECOND)
    calendar.get(Calendar.MILLISECOND)
    calendar.time

    Box (contentAlignment = Alignment.Center, modifier = Modifier
        .fillMaxWidth()
        .background(Color.Black)){

        Canvas(modifier = Modifier.size(150.dp)) {
            val clockRadius = size.minDimension / 2
           // drawCircle(color = Color.Red, radius = clockRadius, style = Stroke(1.dp.toPx()))

            val centerX = size.width / 2
            val centerY = size.height / 2

            val secondHandLength = clockRadius * 0.9f
            val secondAngle = Math.toRadians((seconds * 6 - 90).toDouble())
            drawLine(
                color = Color.Yellow,
                start = center,
                end = Offset(
                    centerX + secondHandLength * cos(secondAngle).toFloat(),
                    centerY + secondHandLength * sin(secondAngle).toFloat()
                ),
                strokeWidth = 1.dp.toPx()
            )

            val minuteHandLength = clockRadius * 0.7f
            val minuteAngle = Math.toRadians((minutes * 6 - 90).toDouble())
            drawLine(
                color = Color.Blue,
                start = center,
                end = Offset(
                    centerX + minuteHandLength * cos(minuteAngle).toFloat(),
                    centerY + minuteHandLength * sin(minuteAngle).toFloat()
                ),
                strokeWidth = 1.dp.toPx()
            )

            val hourHandLength = clockRadius * 0.5f
            val hourAngle = Math.toRadians((hours * 30 + minutes * 0.5 - 90))
            drawLine(
                color = Color.Red,
                start = center,
                end = Offset(
                    centerX + hourHandLength * cos(hourAngle).toFloat(),
                    centerY + hourHandLength * sin(hourAngle).toFloat()
                ),
                strokeWidth = 1.dp.toPx()
            )
        }
    }}




@Preview(showSystemUi = true)
@Composable
fun AnimatedWaves() {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val rotateAnimation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 200f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
    val gradientColors = listOf(
        Color(0xFFFF0000),
        Color(0xFFFFFF00),
        Color(0xFF00FFFF),
        Color(0xFF0000FF),
        Color(0xFFFF00FF),
        Color(0xFFFF0000)
    )

    val brush = remember {
        Brush.sweepGradient(
            colors = gradientColors
        )
    }

    Box(contentAlignment = Alignment.Center, modifier = Modifier
        .fillMaxWidth()
        .size(500.dp)
        .background(Color.Black)) {

        Canvas(modifier = Modifier.size(250.dp)) {
            drawCircle(
                brush = brush,
                radius = 100.dp.toPx() + rotateAnimation,
                style = Stroke(2.dp.toPx())
            )
        }

        Box(modifier = Modifier){
            AnalogClock()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DayDateUI() {
    val currentDate = SimpleDateFormat("EEEE d", Locale.getDefault()).format(Date())

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        androidx.compose.material3.Text(
            text = currentDate,
            color = Color.Magenta,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun SongDetailsUI() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BasicText(
            text = "That Cool Song",
            style = MaterialTheme.typography.bodyLarge.copy(color = Color.Magenta, fontSize = 18.sp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 72.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = { /* Previous */ }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Previous", tint = Color.Magenta)
            }
            IconButton(onClick = { /* Play */ }) {
                Icon(Icons.Filled.PlayArrow, contentDescription = "Play", tint = Color.Magenta)
            }
            IconButton(onClick = { /* Next */ }) {
                Icon(Icons.Filled.ArrowForward, contentDescription = "Next", tint = Color.Magenta)
            }
        }
    }
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            BasicText(
                text = "It's Artist",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Magenta)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp),
            contentAlignment = Alignment.Center
        ) {
            BasicText(
                text = "34%",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Magenta)
            )
        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun UniteCompose(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.background(Color.Black).fillMaxSize().fillMaxWidth().fillMaxHeight()
    ){
        DayDateUI()
        AnimatedWaves()
        SongDetailsUI()
    }
    
}