package com.jun.delibary.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jun.delibary.databinding.SingleChapterBinding
import com.jun.delibary.databinding.SlideItemContainerBinding
import com.jun.delibary.model.Chapter
import com.jun.delibary.model.MainSlide
import com.squareup.picasso.Picasso
import java.util.ArrayList

class MainSliderAdapter(private val context: Context, private val MainSlides: ArrayList<MainSlide>)
    :RecyclerView.Adapter<MainSliderAdapter.MainSliderViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainSliderViewHolder {
        val itemBinding=SlideItemContainerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainSliderViewHolder(itemBinding)
    }

    override fun getItemCount()= MainSlides.size

    override fun onBindViewHolder(holder: MainSliderViewHolder, position: Int) {
        val mainSlide: MainSlide = MainSlides[position]
        holder.bind(mainSlide)
    }

    inner class MainSliderViewHolder(private val itemBinding: SlideItemContainerBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(mainSlide : MainSlide){
            Picasso.get().load(mainSlide.icon).into(itemBinding.imageSlideIcon)
        }
    }
}