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

     val iconList=IconProduct(arrayListOf(IProduct(R.drawable.a,"블랙"),
         IProduct(R.drawable.b,"모텔"),IProduct(R.drawable.c,"호텔"),
         IProduct(R.drawable.d,"리조트"),IProduct(R.drawable.e,"펜션 풀빌라"),
         IProduct(R.drawable.f,"캠핑 글램핑"),IProduct(R.drawable.g,"게하 한옥"),
         IProduct(R.drawable.h,"엑티비티"),IProduct(R.drawable.i,"테마 모텔"),
         IProduct(R.drawable.j,"겨울호캉스"),IProduct(R.drawable.k,"숙박대상"),
         IProduct(R.drawable.l,"망고플레이트")))

     anyProducts.add(iconList)
     val couponProduct=CouponProduct(R.drawable.coupon)
     anyProducts.add(couponProduct)

    val chapterList= RecentlyProduct("최근 본 상품",arrayListOf<RProduct>(
        RProduct("숙소","동암 베네",R.drawable.c1),
        RProduct("숙소","동암 고추잠자리",R.drawable.c2),
        RProduct("숙소","파주 오블라디 풀빌라",R.drawable.c3),
        RProduct("숙소","세인트존스 호텔",R.drawable.c4),
        RProduct("숙소","[특가] 호텔 JCS 여수",R.drawable.c5),
        RProduct("숙소","간석 호텔버스",R.drawable.c6)
    ))
     anyProducts.add(chapterList)

     val magazineList= MagazineProduct("여행 매거진",arrayListOf<MProduct>(
             MProduct(R.drawable.m1),
             MProduct(R.drawable.m2),
             MProduct(R.drawable.m3),
             MProduct(R.drawable.m4),
             MProduct(R.drawable.m5),
             MProduct(R.drawable.m6)
     ))
     anyProducts.add(magazineList)

    anyProducts.add(CompanyProduct(1))
     return anyProducts
}