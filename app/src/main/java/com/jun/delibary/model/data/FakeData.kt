package com.jun.delibary.model.data

import com.jun.delibary.R
import java.util.ArrayList

 fun prepareData(): ArrayList<Any> {
    var anyProducts = ArrayList<Any>()

    val bannerName= BannerText("여기어때")
    anyProducts.add(bannerName)
    //fake slide
    val slideList= MainSlide(arrayListOf<MainSlideProduct>(
        MainSlideProduct(R.drawable.image5),
            MainSlideProduct(R.drawable.image1),
            MainSlideProduct(R.drawable.image2),
            MainSlideProduct(R.drawable.image3),
            MainSlideProduct(R.drawable.image4),
            MainSlideProduct(R.drawable.image5),
            MainSlideProduct(R.drawable.image1)
    )
    )

    anyProducts.add(slideList)

     val iconList= IconProduct(arrayListOf(
         IProduct(R.drawable.a,"블랙"),
         IProduct(R.drawable.b,"모텔"), IProduct(R.drawable.c,"호텔"),
         IProduct(R.drawable.d,"리조트"), IProduct(R.drawable.e,"펜션 풀빌라"),
         IProduct(R.drawable.f,"캠핑 글램핑"), IProduct(R.drawable.g,"게하 한옥"),
         IProduct(R.drawable.h,"엑티비티"), IProduct(R.drawable.i,"테마 모텔"),
         IProduct(R.drawable.j,"겨울호캉스"), IProduct(R.drawable.k,"숙박대상"),
         IProduct(R.drawable.l,"망고플레이트")
     ))

     anyProducts.add(iconList)

     val couponProduct= CouponProduct(R.drawable.coupon)
     val threeCouponProduct=ThreeCouponProduct(1)
     anyProducts.add(couponProduct)
     anyProducts.add(threeCouponProduct)

     val chapterList= RecentlyProduct("최근 본 상품",arrayListOf<RProduct>(
        RProduct("숙소","동암 베네",R.drawable.c1),
        RProduct("숙소","동암 고추잠자리",R.drawable.c2),
        RProduct("숙소","파주 오블라디 풀빌라",R.drawable.c3),
        RProduct("숙소","세인트존스 호텔",R.drawable.c4),
        RProduct("숙소","[특가] 호텔 JCS 여수",R.drawable.c5),
        RProduct("숙소","간석 호텔버스",R.drawable.c6)
    ))
     anyProducts.add(chapterList)

     val couponProduct2= CouponProduct(R.drawable.coupon2)
     anyProducts.add(couponProduct2)

     val spList=SpecialPriceProduct(arrayListOf(
         SPProduct(R.drawable.sp1,"호텔 리베라","청담역 도보 5분","9.1","(1731)","251,000","74,000원"),
         SPProduct(R.drawable.sp2,"이비스 스타일 앰배서더 명동","명동역 도보 2분","8.9","(353)","150,000","53,000원"),
         SPProduct(R.drawable.sp3,"호텔 피제이 명동","을지로4가역 5분","9.4","(947)","235,000","57,400원"),
         SPProduct(R.drawable.sp4,"경주 황남관 한옥호텔","경주역 차량 6분","8.3","(254)","150,000","87,000원"),
         SPProduct(R.drawable.sp5,"하이오션 경포","경포해변 도보 3분","9.2","(119)","330,000","63,900원"),
     ))

     anyProducts.add(spList)

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