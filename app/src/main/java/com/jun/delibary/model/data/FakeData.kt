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

     val reList=RecommendProduct(arrayListOf(
         ReProduct(R.drawable.r1,"간석 파이호텔","1km","남동구 간석동","9.5","(2,244)",
             "20,000원","35,000원","예약"),
         ReProduct(R.drawable.r2,"간석 호텔버스","985m","남동구 간석동","9.5","(432)",
             "20,000원","35,000원","예약특가","40,000"),
         ReProduct(R.drawable.r3,"구월동 구월호텔","2,2km","남동구 구월동","9.5","(3,993)",
             "25,000원","50,000원","예약"),
         ReProduct(R.drawable.r4,"동암 베네","2.2km","부평구 십정동","9.3","(2,760)",
             "18,000원","30,000원","예약"),
         ReProduct(R.drawable.r5,"간석 골든호텔","1.3km","남동구 간석동","9.4","(2,528)",
             "25,000원","50,000원","예약특가","60,000"),
     ))
     anyProducts.add(reList)

     val magazineList= MagazineProduct("여행 매거진",arrayListOf<MProduct>(
             MProduct(R.drawable.m1),
             MProduct(R.drawable.m2),
             MProduct(R.drawable.m3),
             MProduct(R.drawable.m4),
             MProduct(R.drawable.m5),
             MProduct(R.drawable.m6)
     ))
     anyProducts.add(magazineList)
     val blackList=BlackProduct(arrayListOf(
             BLProduct(R.drawable.black1),
             BLProduct(R.drawable.black1),
             BLProduct(R.drawable.black2),
             BLProduct(R.drawable.black3),
             BLProduct(R.drawable.black4)
     ))
     anyProducts.add(blackList)
    val beliveList=BeliveProduct(arrayListOf(
            BProduct(R.drawable.b1,"발렌타인데이엔 초콜릿 대신 호캉스","달달한 혜택까지!","HOT","BEST"),
            BProduct(R.drawable.b2,"둘이서 알콩달콤 발렌타인데이 보내기❤","전국 인기 추천모텔만 모았어요!","쿠폰 할인","BEST"),
            BProduct(R.drawable.b3,"다녀온 분들이 인정하는 찐 BEST!","지금 예약하면 특가에 7%할이까지!","HOT","강력추천"),
            BProduct(R.drawable.b4,"하얏트 설맞이 특가 20% 할인","프리미엄 호캉스를 합리적인 가격으로!","HOT","BEST"),
            BProduct(R.drawable.b5,"히든클리프 제주에서 찐-호캉스를!","#특가 #전망Up #풀파티 #연박조식 제공","HOT","쿠폰할인"),
            BProduct(R.drawable.b6,"특별한 날엔, 프리미엄 고급 펜션","청결, 부대시설, 룸컨디션 모두 최상급!","HOT","BEST"),
            BProduct(R.drawable.b7,"근교 데이트로 펜캉스 어때?","커플펜션 할인 받아 체크인!","추천게하","BEST"),
            BProduct(R.drawable.b8,"인기 펜션 특별할인 주간","이번 주만 무조건 10% 할인!","HOT","강력추천"),
            BProduct(R.drawable.b9,"이 달의 특가호텔 확인하기","#지금 할인중인 #전국 인기 호텔","HOT","BEST")
    ))

     anyProducts.add(beliveList)
    anyProducts.add(CompanyProduct(1))
     return anyProducts
}