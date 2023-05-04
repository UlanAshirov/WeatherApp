package com.example.core.ext

import android.view.View
import android.widget.ImageView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).centerCrop().into(this)
}

fun View.visible() {
    this.isVisible = true
}

fun View.gone() {
    this.isGone = true
}