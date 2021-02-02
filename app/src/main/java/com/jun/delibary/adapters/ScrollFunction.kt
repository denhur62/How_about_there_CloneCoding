package com.jun.delibary.adapters

import android.os.Handler
import android.os.Looper
import androidx.viewpager2.widget.ViewPager2
import com.jun.delibary.databinding.SingleSlideBinding
import com.jun.delibary.model.MainSlide
import com.jun.delibary.model.MainSlideProduct

fun ViewPager2.infiniteScroll(mainSlide: ArrayList<MainSlideProduct>, itemBinding: SingleSlideBinding):Unit{
    registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageScrollStateChanged(state: Int) {
            super.onPageScrollStateChanged(state)
            if (state == ViewPager2.SCROLL_STATE_IDLE || state == ViewPager2.SCROLL_STATE_DRAGGING) {
                if (currentItem == 0) {
                    setCurrentItem(mainSlide.size -2, false)
                }
                else if (currentItem == mainSlide.size -1){
                    setCurrentItem(1, false)
                }

            }
        }
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            // fakescroll을 만들어 해당값일때 옮겨주기
            if(position==0)
                itemBinding.tvNum.text=(mainSlide.size -2).toString()
            else if(position==mainSlide.size -1)
                itemBinding.tvNum.text=1.toString()
            else
                itemBinding.tvNum.text=(position).toString()
            //자동스크롤 값 플러스
            HomeAdapter.scrollPosition = position + 1
        }
    })
}
fun ViewPager2.autoScroll(mainSlide: ArrayList<MainSlideProduct>):Unit{
    val handler = Handler(Looper.getMainLooper())
    //Runnable 객체 생성으로 자동 스크롤 구현
    val runnable = object : Runnable {
        override fun run() {
            val count = mainSlide.size
            setCurrentItem(HomeAdapter.scrollPosition++ % count, true)
            handler.postDelayed(this, 3000)
        }
    }
    handler.post(runnable)
}