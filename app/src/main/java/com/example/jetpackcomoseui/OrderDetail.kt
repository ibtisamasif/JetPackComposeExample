package com.example.jetpackcomoseui

import androidx.annotation.DrawableRes

data class OrderDetail(
    @DrawableRes val detailIconId: Int,
    @DrawableRes val statusIconId: Int ,
    val title : String,
    val trackingNo : String,
    val status : String,
    val from : String,
    val to : String,
    val price : Double,
)
