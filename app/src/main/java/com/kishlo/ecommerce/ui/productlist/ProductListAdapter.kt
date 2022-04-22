package com.kishlo.ecommerce.ui.productlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kishlo.ecommerce.databinding.ItemProductBinding
import com.kishlo.ecommerce.model.Product


class ProductListAdapter(var productList: List<Product> = ArrayList()) :
    RecyclerView.Adapter<ProductListAdapter.PhotoViewHolder>() {

    private val _liveDataAddCartClick = MutableLiveData<Product>()
    val liveDataAddCartClick: LiveData<Product> get() = _liveDataAddCartClick

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

            itemProductBinding.btnAdd.setOnClickListener {
                _liveDataAddCartClick.value = product
            }
        }

    }

    override fun getItemCount(): Int {
        return productList.size
    }
}