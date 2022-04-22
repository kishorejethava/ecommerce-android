package com.kishlo.ecommerce.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kishlo.ecommerce.databinding.ItemCartBinding


class CartAdapter(var cartItemList: ArrayList<CartItem> = ArrayList()) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(cartItemList[position])
    }

    inner class CartViewHolder(private val itemCartBinding: ItemCartBinding) :
        RecyclerView.ViewHolder(itemCartBinding.root) {
        fun bind(cartItem: CartItem) {
            Glide.with(itemCartBinding.root.context)
                .load(cartItem.image_url)
                .into(itemCartBinding.ivCartItem)
            itemCartBinding.tvCartItemName.text = cartItem.name
            itemCartBinding.tvCartItemPrice.text = cartItem.price
            cartItem.rating?.let { itemCartBinding.rbCartItem.rating = it.toFloat() }
        }

    }

    override fun getItemCount(): Int {
        return cartItemList.size
    }

    fun setData(newCartItemList: ArrayList<CartItem>) {
        val diffCallback = CartDiffCallback(newCartItemList, cartItemList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        cartItemList.clear()
        cartItemList.addAll(newCartItemList)
        diffResult.dispatchUpdatesTo(this)
    }
}