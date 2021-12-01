package com.github.kolya.listapp.ui.users

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.updatePadding
import coil.load
import coil.transform.CircleCropTransformation
import com.github.kolya.listapp.R
import com.github.kolya.listapp.databinding.UserViewBinding
import com.github.kolya.listapp.ext.dimen
import com.github.kolya.listapp.models.UserDataUI

class UserView(context: Context) : LinearLayoutCompat(context) {
    private val binding = UserViewBinding.inflate(LayoutInflater.from(context), this)

    init {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        updatePadding(
            left = dimen(R.dimen.space_2x),
            top = dimen(R.dimen.space_1x),
            right = dimen(R.dimen.space_2x),
            bottom = dimen(R.dimen.space_1x)
        )
    }

    fun bindView(item: UserDataUI) {
        with(binding){
            imageView.load(item.imageUrl) {
                transformations(CircleCropTransformation())
            }

            titleView.text = item.name
        }
    }
}