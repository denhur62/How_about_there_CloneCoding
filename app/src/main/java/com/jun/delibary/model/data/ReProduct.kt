package com.jun.delibary.model.data

import kotlin.reflect.typeOf

class ReProduct(val imageUrl:Int,val name:String,val distance:String,val location:String,
                val GPA:String, val GPACount:String,val rendRoom:String,
                val salePrice:String, val typeOfSpecialOffer:String){
    var originPrice:String?=null
    constructor(imageUrl:Int, name: String,distance: String,
                location: String,GPA:String,GPACount:String,rendRoom:String,salePrice:String,
                typeOfSpecialOffer:String, originPrice:String,) :this(imageUrl,name,distance,
                location,GPA,GPACount,rendRoom,salePrice, typeOfSpecialOffer){
                    this.originPrice=originPrice
                }


}