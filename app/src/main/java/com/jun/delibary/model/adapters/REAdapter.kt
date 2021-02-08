package com.jun.delibary.model.adapters


import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.jun.delibary.databinding.ReProductBinding
import com.jun.delibary.databinding.SpProductBinding
import com.jun.delibary.model.data.ReProduct
import com.jun.delibary.model.data.SPProduct
import java.util.ArrayList

class REAdapter(private val context: Context, private val REProducts: ArrayList<ReProduct>) :
        RecyclerView.Adapter<REAdapter.REProductViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): REProductViewHolder {
        val itemBinding=
                ReProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return REProductViewHolder(itemBinding)

    }

    override fun getItemCount()= REProducts.size

    override fun onBindViewHolder(holder: REProductViewHolder, position: Int) {
        val reProduct: ReProduct = REProducts[position]
        holder.bind(reProduct)
    }

    inner class REProductViewHolder(private val itemBinding: ReProductBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(reProduct: ReProduct){
            Glide.with(context)
                    .load(reProduct.imageUrl)
                    .centerCrop()
                    .into(itemBinding.ivReProduct)
            itemBinding.clReProduct.outlineProvider = ViewOutlineProvider.BACKGROUND
            itemBinding.clReProduct.clipToOutline = true

            itemBinding.tvName.text=reProduct.name
            itemBinding.tvDistance.text=reProduct.distance
            itemBinding.tvLocation.text=reProduct.location
            itemBinding.tvGpa.text=reProduct.GPA
            itemBinding.tvGpaCount.text=reProduct.GPACount
            itemBinding.tvRentPrice.text=reProduct.rendPrice
            itemBinding.tvSalePrice.text=reProduct.accommodationPrice
            itemBinding.tvTypeOfSpecialOffer.text=reProduct.typeOfSpecialOffer
            if(reProduct.originPrice==null){
                itemBinding.tvOriginPrice.visibility=View.GONE
            }else{
                itemBinding.tvOriginPrice.text=reProduct.originPrice
                itemBinding.tvSalePrice.setTextColor(Color.parseColor("#F7323F"))
                itemBinding.tvOriginPrice.paintFlags = itemBinding.tvOriginPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            }

        }

    }

}