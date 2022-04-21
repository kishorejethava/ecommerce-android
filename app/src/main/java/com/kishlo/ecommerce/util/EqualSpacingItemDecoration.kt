package com.kishlo.ecommerce.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.RecyclerView.LayoutManager

/**
 * Created by Kishore Jethava on 3/11/2019.
 */
class EqualSpacingItemDecoration @JvmOverloads constructor(
    private val top: Int,
    private val left: Int,
    private val bottom: Int,
    private val right: Int,
    private var displayMode: Int = -1
) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildViewHolder(view).adapterPosition
        val itemCount = state.itemCount
        val layoutManager = parent.layoutManager
        setSpacingForDirection(outRect, layoutManager, position, itemCount)
    }

    private fun setSpacingForDirection(
        outRect: Rect,
        layoutManager: LayoutManager?,
        position: Int,
        itemCount: Int
    ) {

        // Resolve display mode automatically
        if (displayMode == -1) {
            displayMode = resolveDisplayMode(layoutManager)
        }
        when (displayMode) {
            HORIZONTAL -> {
                outRect.left = left
                outRect.right = if (position == itemCount - 1) right else 0
                outRect.top = top
                outRect.bottom = bottom
            }
            VERTICAL -> {
                outRect.left = left
                outRect.right = right
                outRect.top = top
                outRect.bottom = if (position == itemCount - 1) bottom else 0
            }
            GRID -> if (layoutManager is GridLayoutManager) {
                val cols = layoutManager.spanCount
                //  3 = 7 / 2
                var rows = itemCount / cols

                //if rows is odd number make it even
                if (rows and 1 != 0) {
                    rows += 1
                }
                outRect.left = left
                outRect.right = if (position % cols == cols - 1) right else 0
                outRect.top = top
                outRect.bottom = if (position / cols == rows - 1) bottom else 0
            }
        }
    }

    private fun resolveDisplayMode(layoutManager: LayoutManager?): Int {
        if (layoutManager is GridLayoutManager) return GRID
        return if (layoutManager!!.canScrollHorizontally()) HORIZONTAL else VERTICAL
    }

    companion object {
        const val HORIZONTAL = 0
        const val VERTICAL = 1
        const val GRID = 2
    }
}