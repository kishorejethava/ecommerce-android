package com.kishlo.ecommerce.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kishlo.ecommerce.databinding.ItemProductBinding
import com.kishlo.ecommerce.model.Product


class ProductListAdapter(private var productList: List<Product>) :
    RecyclerView.Adapter<ProductListAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    inner class PhotoViewHolder(private val itemProductBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(itemProductBinding.root) {
        fun bind(product: Product) {
            Glide.with(itemProductBinding.root.context)
                .load(product.image_url)
                .into(itemProductBinding.ivProduct)
            itemProductBinding.tvProductName.text = product.name
            itemProductBinding.tvProductPrice.text = product.price
            product.rating?.let { itemProductBinding.rbProduct.rating = it.toFloat() }

        }

    }

    override fun getItemCount(): Int {
        return productList.size
    }
}