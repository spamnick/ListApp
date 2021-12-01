package com.github.kolya.listapp.ext

import android.view.View
import androidx.annotation.DimenRes
import androidx.annotation.Px

@Px
fun View.dimen(@DimenRes dimenRes: Int): Int {
    return resources.getDimensionPixelSize(dimenRes)
}