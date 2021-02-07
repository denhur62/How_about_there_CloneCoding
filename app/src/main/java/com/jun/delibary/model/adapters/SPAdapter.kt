package com.jun.delibary.model.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jun.delibary.databinding.SpProductBinding
import com.jun.delibary.model.data.SPProduct
import java.util.ArrayList

class SPAdapter(private val context: Context, private val SPProducts: ArrayList<SPProduct>) :
    RecyclerView.Adapter<SPAdapter.SPProductViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SPProductViewHolder {
        val itemBinding=
            SpProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SPProductViewHolder(itemBinding)

    }

    override fun getItemCount()= SPProducts.size

    override fun onBindViewHolder(holder: SPProductViewHolder, position: Int) {
        val spProduct: SPProduct = SPProducts[position]
        holder.bind(spProduct)
    }

    inner class SPProductViewHolder(private val itemBinding: SpProductBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(spProduct: SPProduct){
            itemBinding.ivSpProduct.clipToOutline=true
            Glide.with(context)
                .load(spProduct.imageUrl)
                .into(itemBinding.ivSpProduct)

            itemBinding.tvName.text=spProduct.SPName
            itemBinding.tvLocation.text=spProduct.SPLocation
            itemBinding.tvGpa.text=spProduct.SPGPA
            itemBinding.tvGpaCount.text=spProduct.SPGPACount
            itemBinding.tvOriginPrice.text=spProduct.originPrice
            itemBinding.tvSalePrice.text=spProduct.salePrice
        }

    }

}