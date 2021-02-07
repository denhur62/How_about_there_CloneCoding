package com.jun.delibary.model.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jun.delibary.databinding.SlideItemContainerBinding
import com.jun.delibary.model.data.MainSlideProduct
import java.util.ArrayList

class MainSliderAdapter(private val context: Context, private val MainSlides: ArrayList<MainSlideProduct>, private val itemClick:(MainSlideProduct, Int)->Unit)
    :RecyclerView.Adapter<MainSliderAdapter.MainSliderViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainSliderViewHolder {
        val itemBinding=SlideItemContainerBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return MainSliderViewHolder(itemBinding)
    }

    override fun getItemCount()= MainSlides.size

    override fun onBindViewHolder(holder: MainSliderViewHolder, position: Int) {
        val mainSlide: MainSlideProduct = MainSlides[position]
        holder.bind(mainSlide)
    }

    inner class MainSliderViewHolder(private val itemBinding: SlideItemContainerBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(mainSlide : MainSlideProduct){
            Glide.with(context).load(mainSlide.icon)
                .fitCenter()
                .into(itemBinding.imageSlideIcon)

            itemBinding.imageSlideIcon.setOnClickListener {
                itemClick(mainSlide,adapterPosition)
            }
        }
    }
}