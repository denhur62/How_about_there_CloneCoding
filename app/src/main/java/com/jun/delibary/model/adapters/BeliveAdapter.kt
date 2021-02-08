package com.jun.delibary.model.adapters



import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jun.delibary.databinding.BProductBinding
import com.jun.delibary.model.data.BProduct
import java.util.ArrayList

class BeliveAdapter(private val context: Context, private val BProducts: ArrayList<BProduct>) :
        RecyclerView.Adapter<BeliveAdapter.BProductViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BProductViewHolder {
        val itemBinding=
                BProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BProductViewHolder(itemBinding)

    }

    override fun getItemCount()= BProducts.size

    override fun onBindViewHolder(holder: BProductViewHolder, position: Int) {
        val bProduct: BProduct = BProducts[position]
        holder.bind(bProduct)
    }

    inner class BProductViewHolder(private val itemBinding: BProductBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(bProduct: BProduct){
            Glide.with(context)
                    .load(bProduct.imageUrl)
                    .centerCrop()
                    .into(itemBinding.ivBProduct)
            itemBinding.clBProduct.outlineProvider = ViewOutlineProvider.BACKGROUND
            itemBinding.clBProduct.clipToOutline = true

            itemBinding.tvName.text=bProduct.name
            itemBinding.tvDescription.text=bProduct.description
            itemBinding.tvBox.text=bProduct.textBox
            itemBinding.tvBoxOther.text=bProduct.textBox2


        }

    }

}