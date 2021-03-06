package com.jun.delibary.model.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.jun.delibary.R
import com.jun.delibary.databinding.*
import com.jun.delibary.model.adapters.RecyclerViewType.BELIVE_TYPE
import com.jun.delibary.model.adapters.RecyclerViewType.BLACK_TYPE
import com.jun.delibary.model.adapters.RecyclerViewType.COUPON_THREE_TYPE
import com.jun.delibary.model.adapters.RecyclerViewType.COUPON_TYPE
import com.jun.delibary.model.adapters.RecyclerViewType.EXPLAIN_TYPE
import com.jun.delibary.model.adapters.RecyclerViewType.ICON_TYPE
import com.jun.delibary.model.adapters.RecyclerViewType.MAGAZINE_TYPE
import com.jun.delibary.model.adapters.RecyclerViewType.RECENTLY_PRODUCT_TYPE
import com.jun.delibary.model.adapters.RecyclerViewType.RECOMMEND_PRODUCT_TYPE
import com.jun.delibary.model.adapters.RecyclerViewType.SLIDE_TYPE
import com.jun.delibary.model.adapters.RecyclerViewType.SPECIAL_PRODUCT_TYPE
import com.jun.delibary.model.adapters.RecyclerViewType.TEXT_TYPE
import com.jun.delibary.model.data.*
import com.jun.delibary.view.EventActivity
import java.util.*


class HomeAdapter(private val itemList: ArrayList<Any>, private val context: Context, private val recyclerView: RecyclerView) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            RECENTLY_PRODUCT_TYPE -> {
                val itemBinding = SingleRecentlyProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                RecentViewHolder(itemBinding)
            }
            SLIDE_TYPE -> {
                val itemBinding = SingleSlideBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MainSliderViewHolder(itemBinding)
            }
            TEXT_TYPE -> {
                val itemBinding = MainBennerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BannerNameViewHolder(itemBinding)
            }
            ICON_TYPE -> {
                val itemBinding = SingleIconProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                IconViewHodler(itemBinding)
            }
            COUPON_TYPE -> {
                val itemBinding = SingleCouponProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                CouponViewHodler(itemBinding)
            }
            COUPON_THREE_TYPE -> {
                val itemBinding = ThreeCouponProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ThreeCouponViewHodler(itemBinding)
            }
            SPECIAL_PRODUCT_TYPE -> {
                val itemBinding = SpecialPriceProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                SpecialPriceViewHolder(itemBinding)
            }
            MAGAZINE_TYPE -> {
                val itemBinding = SingleMagazineProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MagazineViewHolder(itemBinding)
            }
            EXPLAIN_TYPE -> {
                val itemBinding = CompanyExplainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                CompanyViewHolder(itemBinding)
            }
            RECOMMEND_PRODUCT_TYPE -> {
                val itemBinding = RecommendProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                RecommendViewHolder(itemBinding)
            }
            BELIVE_TYPE -> {
                val itemBinding = BeliveProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BeliveViewHolder(itemBinding)
            }
            BLACK_TYPE -> {
                val itemBinding = BlackProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BlackProductViewHolder(itemBinding)
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
            is RecentlyProduct -> (holder as RecentViewHolder).bind(obj as RecentlyProduct)
            is MainSlide -> {
                (holder as MainSliderViewHolder).bind(obj as MainSlide)
            }
            is BannerText -> {
                (holder as BannerNameViewHolder).bind(obj as BannerText)
            }
            is IconProduct -> {
                (holder as IconViewHodler).bind(obj as IconProduct)
            }
            is CouponProduct -> {
                (holder as CouponViewHodler).bind(obj as CouponProduct)
            }
            is CompanyProduct -> {
                (holder as CompanyViewHolder).bind(obj as CompanyProduct)
            }
            is MagazineProduct -> {
                (holder as MagazineViewHolder).bind(obj as MagazineProduct)
            }
            is ThreeCouponProduct -> {
                (holder as ThreeCouponViewHodler).bind()
            }
            is SpecialPriceProduct -> {
                (holder as SpecialPriceViewHolder).bind(obj as SpecialPriceProduct)
            }
            is RecommendProduct -> {
                (holder as RecommendViewHolder).bind(obj as RecommendProduct)
            }
            is BeliveProduct -> {
                (holder as BeliveViewHolder).bind(obj as BeliveProduct)
            }
            is BlackProduct -> {
                (holder as BlackProductViewHolder).bind(obj as BlackProduct)
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
            is MagazineProduct -> MAGAZINE_TYPE
            is ThreeCouponProduct -> COUPON_THREE_TYPE
            is SpecialPriceProduct -> SPECIAL_PRODUCT_TYPE
            is RecommendProduct -> RECOMMEND_PRODUCT_TYPE
            is BeliveProduct -> BELIVE_TYPE
            is BlackProduct -> BLACK_TYPE
            else-> throw RuntimeException("getItemViewType")
        }
    }
    inner class RecentViewHolder(private val itemBinding: SingleRecentlyProductBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(recentlyProduct: RecentlyProduct){
            //아이템이 변경하지 않을것을 명시하여 성능하락 방지 == setHasFixedSize
            itemBinding.rvChapters.run{
                setHasFixedSize(true)
                adapter = RProductAdapter(context, recentlyProduct.RProducts){ RProduct->
                    val intent = Intent(context, EventActivity::class.java)
                    intent.putExtra("recentlyEvent", "${RProduct.imageUrl}")
                    context.startActivity(intent)
                }
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
        private var flag=true
        fun bind(mainSlide: MainSlide){
            itemBinding.tvAll.setOnClickListener{
                val intent = Intent(context, EventActivity::class.java)
                intent.putExtra("eventAll", "전체보기")
                context.startActivity(intent)
                }
            itemBinding.mainViewPager.run{
                // if문을 사용하거나 Activity에서 설정
                if(flag){
                    flag=false
                    autoScroll(mainSlide.list)
                    infiniteScroll(mainSlide.list, itemBinding)
                    // 기본값\
                    setCurrentItem(1, false)
                    orientation=this.orientation

                    adapter = mainSlide.list.let { MainSliderAdapter(context, it){ MainSlideProduct, position->
                        val intent = Intent(context, EventActivity::class.java)
                        intent.putExtra("slideEvent", "$position")
                        context.startActivity(intent)
                    } }

                }

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
                adapter = IProductAdapter(context, iconProduct.IProducts)
                layoutManager = GridLayoutManager(context, 4)
                   
            }
        }
    }
    inner class CouponViewHodler(private val itemBinding: SingleCouponProductBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(couponProduct: CouponProduct){
            Glide.with(context).load(couponProduct.imageUrl)
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
                    .into(itemBinding.ivCoupon)
            }
        }
    inner class ThreeCouponViewHodler(private val itemBinding: ThreeCouponProductBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(){
            itemBinding.tc1.clipToOutline=true
            itemBinding.tc2.clipToOutline=true
            itemBinding.tc3.clipToOutline=true
        }
    }

    inner class SpecialPriceViewHolder(private val itemBinding: SpecialPriceProductBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(spproduct: SpecialPriceProduct){
            itemBinding.rvSpProduct.run{
                setHasFixedSize(true)
                adapter = SPAdapter(context, spproduct.SPProducts)
                layoutManager = LinearLayoutManager(
                        context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                )
            }
        }
    }
    inner class RecommendViewHolder(private val itemBinding: RecommendProductBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(reProduct: RecommendProduct){
            itemBinding.rvReProduct.run{
                setHasFixedSize(true)
                adapter = REAdapter(context, reProduct.ReProducts)
                layoutManager = LinearLayoutManager(
                        context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                )
            }
        }
    }
    inner class BeliveViewHolder(private val itemBinding: BeliveProductBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(beliveProduct: BeliveProduct){
            itemBinding.bProduct.run{
                setHasFixedSize(true)
                adapter = BeliveAdapter(context, beliveProduct.bproducts)
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
        }
    }
    inner class MagazineViewHolder(private val itemBinding: SingleMagazineProductBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(magazineProduct: MagazineProduct){
            itemBinding.rvIcon.run{
                setHasFixedSize(true)
                adapter = MagazineAdapter(context, magazineProduct.MProducts)
                layoutManager = LinearLayoutManager(
                        context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                )
            }
            itemBinding.tvSubjectName.text = magazineProduct.subjectName
        }
    }
    inner class BlackProductViewHolder(private val itemBinding: BlackProductBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(blackProduct: BlackProduct){
            itemBinding.rvBlack.run{
                setHasFixedSize(true)
                adapter = BlackAdapter(context, blackProduct.BlProducts)
                layoutManager = LinearLayoutManager(
                        context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                )

                addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    var overallXScroll: Float = 100f
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)
                        //use this value to determine left or right scroll
                        overallXScroll += (dx*2)
                        itemBinding.tvBlack1.alpha = (100 / overallXScroll)
                        itemBinding.tvBlack2.alpha = (100 / overallXScroll)
                        itemBinding.tvBlack3.alpha = (100 / overallXScroll)
                        itemBinding.ivBlack.alpha = (100 / overallXScroll)
                    }
                })

            }
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

