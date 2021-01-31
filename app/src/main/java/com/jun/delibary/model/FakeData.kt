package com.jun.delibary.model

import com.jun.delibary.R
import java.util.ArrayList

 fun prepareData(): ArrayList<Any> {
    var anyProducts = ArrayList<Any>()

    val bannerName= BannerText("여기어때")
    anyProducts.add(bannerName)
    //fake slide
    val slideList=MainSlide(arrayListOf<MainSlideProduct>(MainSlideProduct(R.drawable.image5),
            MainSlideProduct(R.drawable.image1),
            MainSlideProduct(R.drawable.image2),
            MainSlideProduct(R.drawable.image3),
            MainSlideProduct(R.drawable.image4),
            MainSlideProduct(R.drawable.image5),
            MainSlideProduct(R.drawable.image1))
    )

    anyProducts.add(slideList)


    val chapterList1= ArrayList<RProduct>()
    val chapter1 = RProduct(1,"동암 베네","http://ashishkudale.com/images/phy/atoms.png")
    val chapter2 = RProduct(2,"동암 고추잠자리","http://ashishkudale.com/images/phy/sigma.png")
    val chapter3 = RProduct(3,"파주 오블라디 풀빌라","http://ashishkudale.com/images/phy/magnet.png")
    val chapter4 = RProduct(4,"세인트존스 호텔","http://ashishkudale.com/images/phy/caliper.png")
    val chapter5 = RProduct(5,"[특가] 호텔 JCS 여수","http://ashishkudale.com/images/phy/micrometer.png")
    chapterList1.add(chapter1)
    chapterList1.add(chapter2)
    chapterList1.add(chapter3)
    chapterList1.add(chapter4)
    chapterList1.add(chapter5)
    val physics = RecentlyProduct("최근 본 상품",chapterList1)


    anyProducts.add(physics)
    return anyProducts
}