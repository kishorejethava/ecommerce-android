package com.kishlo.ecommerce.ui.cart

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil

class CartDiffCallback(private val oldList: List<CartItem>, private val newList: List<CartItem>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        val (oldImageUrl, oldName,_,_) = oldList[oldPosition]
        val (newImageUrl, newName,_,_) = newList[newPosition]

        return oldImageUrl == newImageUrl && oldName == newName
    }

    @Nullable
    override fun getChangePayload(oldPosition: Int, newPosition: Int): Any? {
        return super.getChangePayload(oldPosition, newPosition)
    }
}