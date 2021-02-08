package com.jun.delibary.model.data

import kotlin.reflect.typeOf

class ReProduct(val imageUrl:Int,val name:String,val distance:String,val location:String,
                val GPA:String, val GPACount:String,val rendPrice:String,
                val accommodationPrice:String, val typeOfSpecialOffer:String){
    var originPrice:String?=null
    constructor(imageUrl:Int, name: String,distance: String,
                location: String,GPA:String,GPACount:String,rendPrice:String,accommodationPrice:String,
                typeOfSpecialOffer:String, originPrice:String,) :this(imageUrl,name,distance,
                location,GPA,GPACount,rendPrice,accommodationPrice, typeOfSpecialOffer){
                    this.originPrice=originPrice
                }


}