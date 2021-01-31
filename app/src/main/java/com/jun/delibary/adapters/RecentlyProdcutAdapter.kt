package com.jun.delibary.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jun.delibary.adapters.RecyclerViewType.RECENTLY_PRODUCT_TYPE
import com.jun.delibary.adapters.RecyclerViewType.SLIDE_TYPE
import com.jun.delibary.adapters.RecyclerViewType.TEXT_TYPE
import com.jun.delibary.databinding.*
import com.jun.delibary.model.BannerText
import com.jun.delibary.model.MainSlide
import com.jun.delibary.model.RecentlyProduct
import java.util.*

class RecentlyProductAdapter(private val itemList: ArrayList<Any>, private val context: Context) :
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
            else -> throw RuntimeException("Bind Error")
        }
    }
    override fun getItemViewType(position: Int): Int {

        Log.d("response","${itemList[position]}")
        return when(itemList[position]){
            is RecentlyProduct -> RECENTLY_PRODUCT_TYPE
            is MainSlide -> SLIDE_TYPE
            is BannerText -> TEXT_TYPE
            else-> throw RuntimeException("getItemViewType")
        }
    }
    inner class SingleViewHolder(private val itemBinding: SingleRecentlyProductBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(recentlyProduct:RecentlyProduct){
            //아이템이 변경하지 않을것을 명시하여 성능하락 방지 == setHasFixedSize
            itemBinding.rvChapters.run{
                setHasFixedSize(true)
                adapter = recentlyProduct.RProducts.let { RProductAdapter(context, it) }
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
                Toast.makeText(context, "전체보기", Toast.LENGTH_SHORT).show()
                }

            itemBinding.mainViewPager.run{
                autoScroll(mainSlide.list)
                infiniteScroll(mainSlide.list,itemBinding)
                // 기본값
                setCurrentItem(1, false)
                orientation=this.orientation

                adapter = mainSlide.list.let { MainSliderAdapter(context, it){
                    MainSlideProduct,position->
                    Toast.makeText(context, "${MainSlideProduct},${position}", Toast.LENGTH_SHORT).show()
                } }
            }
        }
    }

    inner class BannerNameViewHolder(private val itemBinding: MainBennerBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(bannerText: BannerText){
            itemBinding.toolbarText.text=bannerText.name
        }
    }
    companion object{
        var scrollPosition = 0
    }
}

