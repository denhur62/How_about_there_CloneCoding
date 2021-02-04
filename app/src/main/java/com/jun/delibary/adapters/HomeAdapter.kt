package com.jun.delibary.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.jun.delibary.EventActivity
import com.jun.delibary.R
import com.jun.delibary.adapters.RecyclerViewType.COUPON_TYPE
import com.jun.delibary.adapters.RecyclerViewType.EXPLAIN_TYPE
import com.jun.delibary.adapters.RecyclerViewType.ICON_TYPE
import com.jun.delibary.adapters.RecyclerViewType.RECENTLY_PRODUCT_TYPE
import com.jun.delibary.adapters.RecyclerViewType.SLIDE_TYPE
import com.jun.delibary.adapters.RecyclerViewType.TEXT_TYPE
import com.jun.delibary.databinding.*
import com.jun.delibary.model.*
import java.util.*

class HomeAdapter(private val itemList: ArrayList<Any>, private val context: Context,private val recyclerView:RecyclerView) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            RECENTLY_PRODUCT_TYPE-> {
                val itemBinding=SingleRecentlyProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                SingleViewHolder(itemBinding)
            }
            SLIDE_TYPE-> {
                val itemBinding= SingleSlideBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                 MainSliderViewHolder(itemBinding)
            }
            TEXT_TYPE-> {
                val itemBinding= MainBennerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                BannerNameViewHolder(itemBinding)
            }
            ICON_TYPE-> {
                val itemBinding= SingleIconProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                IconViewHodler(itemBinding)
            }
            COUPON_TYPE-> {
                val itemBinding= SingleCouponProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                CouponViewHodler(itemBinding)
            }
            EXPLAIN_TYPE-> {
                val itemBinding= CompanyExplainBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                CompanyViewHolder(itemBinding)
            }
            else -> throw RuntimeException("View Error")
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val obj = itemList[position]
        when (obj) {
            is RecentlyProduct -> (holder as SingleViewHolder).bind(obj as RecentlyProduct)
            is MainSlide -> {
                (holder as MainSliderViewHolder).bind(obj as MainSlide)
            }
            is BannerText->{
                (holder as BannerNameViewHolder).bind(obj as BannerText)
            }
            is IconProduct ->{
                (holder as IconViewHodler).bind(obj as IconProduct)
            }
            is CouponProduct ->{
                (holder as CouponViewHodler).bind(obj as CouponProduct)
            }
            is CompanyProduct ->{
                (holder as CompanyViewHolder).bind(obj as CompanyProduct)
            }
            else -> throw RuntimeException("Bind Error")
        }
    }
    override fun getItemViewType(position: Int): Int {

        return when(itemList[position]){
            is RecentlyProduct -> RECENTLY_PRODUCT_TYPE
            is MainSlide -> SLIDE_TYPE
            is BannerText -> TEXT_TYPE
            is IconProduct -> ICON_TYPE
            is CouponProduct -> COUPON_TYPE
            is CompanyProduct -> EXPLAIN_TYPE
            else-> throw RuntimeException("getItemViewType")
        }
    }
    inner class SingleViewHolder(private val itemBinding: SingleRecentlyProductBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(recentlyProduct:RecentlyProduct){
            //아이템이 변경하지 않을것을 명시하여 성능하락 방지 == setHasFixedSize
            itemBinding.rvChapters.run{
                setHasFixedSize(true)
                adapter = recentlyProduct.RProducts.let { RProductAdapter(context, it){
                        RProduct->
                    val intent = Intent(context, EventActivity::class.java)
                    intent.putExtra("recentlyEvent","${RProduct.imageUrl}")
                    context.startActivity(intent)
                } }
                layoutManager = LinearLayoutManager(
                        context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                )
            }
            itemBinding.tvSubjectName.text = recentlyProduct.subjectName
        }
    }
    inner class MainSliderViewHolder(private val itemBinding: SingleSlideBinding): RecyclerView.ViewHolder(itemBinding.root){

        fun bind(mainSlide: MainSlide){
            itemBinding.tvAll.setOnClickListener{
                val intent = Intent(context, EventActivity::class.java)
                intent.putExtra("eventAll","전체보기")
                context.startActivity(intent)
                }

            itemBinding.mainViewPager.run{
                autoScroll(mainSlide.list)
                infiniteScroll(mainSlide.list,itemBinding)
                // 기본값
                setCurrentItem(1, false)
                orientation=this.orientation

                adapter = mainSlide.list.let { MainSliderAdapter(context, it){
                    MainSlideProduct,position->
                    val intent = Intent(context, EventActivity::class.java)
                    intent.putExtra("slideEvent","$position")
                    context.startActivity(intent)
                } }
            }
        }
    }

    inner class BannerNameViewHolder(private val itemBinding: MainBennerBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(bannerText: BannerText){
            itemBinding.toolbarText.text=bannerText.name
        }
    }
    inner class IconViewHodler(private val itemBinding: SingleIconProductBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(iconProduct: IconProduct){
            itemBinding.rvIcon.run{
                setHasFixedSize(true)
                adapter = iconProduct.IProducts.let { IProductAdapter(context, it) }
                layoutManager = GridLayoutManager(context,4)
                   
            }
        }
    }
    inner class CouponViewHodler(private val itemBinding: SingleCouponProductBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(couponProduct: CouponProduct){
            itemBinding.ivCoupon.clipToOutline=true
            Glide.with(context).load(couponProduct.imageUrl)
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
                    .into(itemBinding.ivCoupon)
            }
        }
    inner class CompanyViewHolder(private val itemBinding: CompanyExplainBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(companyProduct: CompanyProduct) {
            itemBinding.ivArrow.setOnClickListener {
                if (itemBinding.llDetail.visibility == View.GONE) {
                    itemBinding.llDetail.expand(recyclerView)
                    itemBinding.tvSeeDetail.text = "닫기"
                    itemBinding.ivArrow.setImageResource(R.drawable.arrow_up)
                } else { //VISIBLE
                    itemBinding.llDetail.collapse()
                    itemBinding.tvSeeDetail.text = "자세히보기"
                    itemBinding.ivArrow.setImageResource(R.drawable.arrow_down)
                }
            }
        }
    }
    companion object{
        var scrollPosition = 0
    }
}

