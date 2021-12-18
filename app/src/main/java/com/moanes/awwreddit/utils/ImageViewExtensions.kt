package com.moanes.awwreddit.utils

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.moanes.awwreddit.R

fun AppCompatImageView.setImageURL(url: String, placeholder: Int = R.drawable.item_place_holder) {

    Glide.with(this)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .placeholder(placeholder)
        .into(this)
}

