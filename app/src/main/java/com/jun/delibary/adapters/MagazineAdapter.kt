package com.jun.delibary.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jun.delibary.databinding.SingleMproductBinding
import com.jun.delibary.model.MProduct
import java.util.ArrayList

class MagazineAdapter(private val context: Context, private val MProducts: ArrayList<MProduct> ) :
        RecyclerView.Adapter<MagazineAdapter.MagazineViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MagazineViewHolder {
        val itemBinding= SingleMproductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MagazineViewHolder(itemBinding)

    }

    override fun getItemCount()= MProducts.size

    override fun onBindViewHolder(holder: MagazineViewHolder, position: Int) {
        val mProduct: MProduct = MProducts[position]
        holder.bind(mProduct)
    }

    inner class MagazineViewHolder(private val itemBinding: SingleMproductBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(mProduct: MProduct){
            itemBinding.ivIcon.clipToOutline=true
            Glide.with(context)
                    .load(mProduct.imageUrl)
                    .into(itemBinding.ivIcon)
            }
        }

    }

