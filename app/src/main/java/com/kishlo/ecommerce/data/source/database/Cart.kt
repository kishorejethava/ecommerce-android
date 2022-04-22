package com.kishlo.ecommerce.data.source.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cart(
    @ColumnInfo(name = "image_url") val imageUrl: String?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "price") val price: String?,
    @ColumnInfo(name = "rating") val rating: Int?
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var uid: Long = 0
}