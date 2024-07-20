package com.theapplicationpad.plantapp.Model

import com.theapplicationpad.plantapp.R

data class HomePlant(
    val img:Int,
    val name:String,
    val days:String
)



val HomePlantData = listOf(
    HomePlant(R.drawable.flower1,"Andrea Pink","10"),
    HomePlant(R.drawable.flower2,"Mix Rose","3"),
    HomePlant(R.drawable.flower3,"Blossom","5"),
    HomePlant(R.drawable.flower4,"Centaurea cyanus","11"),
    HomePlant(R.drawable.flower5,"Garbera leandrii","12"),
    HomePlant(R.drawable.flower6,"Anne Cotterill","10"),

    )