package com.theapplicationpad.plantapp.Model

import com.theapplicationpad.plantapp.R


data class ShopPlant(
    val img:Int,
    val name:String,
    val days:String
)



val ShopPlantData = listOf(
    ShopPlant(R.drawable.flower1,"Andrea Pink","$23 - $25"),
    ShopPlant(R.drawable.flower2,"Mix Rose","$34 -$40"),
    ShopPlant(R.drawable.flower3,"Blossom","$24 - $35"),
    ShopPlant(R.drawable.flower4,"Centaurea cyanus","$13 - $15"),
    ShopPlant(R.drawable.flower5,"Garbera leandrii","$24 - $42"),
    ShopPlant(R.drawable.flower6,"Anne Cotterill","$23 - $25"),

    )