package com.jun.delibary.model.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.jun.delibary.databinding.BlProductBinding
import com.jun.delibary.model.data.BLProduct
import java.util.ArrayList

class BlackAdapter(private val context: Context, private val BLProducts: ArrayList<BLProduct>) :
        RecyclerView.Adapter<BlackAdapter.BlackViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlackViewHolder {
        val itemBinding=
                BlProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BlackViewHolder(itemBinding)

    }

    override fun getItemCount()= BLProducts.size

    override fun onBindViewHolder(holder: BlackViewHolder, position: Int) {
        val blProduct: BLProduct = BLProducts[position]

        holder.bind(blProduct)
    }

    inner class BlackViewHolder(private val itemBinding: BlProductBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(blProduct: BLProduct){
            if( adapterPosition==0){
                itemBinding.ivIcon.alpha=0f
            }
            else{
                Glide.with(context)
                        .load(blProduct.imageUrl)
                        .apply(RequestOptions.bitmapTransform(RoundedCorners(20)))
                        .override(250,250)
                        .into(itemBinding.ivIcon)
            }
        }
    }

}