package com.jun.delibary.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jun.delibary.databinding.SingleRproductBinding
import com.jun.delibary.model.RProduct
import java.util.*

class RProductAdapter(private val context: Context, private val RProducts: ArrayList<RProduct>) :
    RecyclerView.Adapter<RProductAdapter.CustomViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemBinding=SingleRproductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CustomViewHolder(itemBinding)

    }

    override fun getItemCount()= RProducts.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val RProduct: RProduct = RProducts[position]
        holder.bind(RProduct)
    }

    inner class CustomViewHolder(private val itemBinding: SingleRproductBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(RProduct: RProduct){
            itemBinding.tvChapterName.text = RProduct.chapterName
            Glide.with(context).load(RProduct.imageUrl).into(itemBinding.ivChapter)
        }

    }

}