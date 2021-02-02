package com.jun.delibary.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jun.delibary.databinding.SingleIproductBinding
import com.jun.delibary.model.IProduct
import java.util.ArrayList

class IProductAdapter (private val context: Context, private val IProducts: ArrayList<IProduct>) :
    RecyclerView.Adapter<IProductAdapter.IProductViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IProductViewHolder {
        val itemBinding=
            SingleIproductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return IProductViewHolder(itemBinding)

    }

    override fun onBindViewHolder(holder: IProductAdapter.IProductViewHolder, position: Int) {
        val IProduct: IProduct = IProducts[position]
        holder.bind(IProduct)
    }
    override fun getItemCount()= IProducts.size

    inner class IProductViewHolder(private val itemBinding: SingleIproductBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(IProduct: IProduct){
            itemBinding.tvId.text=IProduct.title
            Glide.with(context).load(IProduct.imageUrl).into(itemBinding.ivIcon)
        }

    }



}