package com.husseinhj.customerinfoapp.presentation.common.avatar_view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.husseinhj.customerinfoapp.R
import com.husseinhj.customerinfoapp.databinding.UserAvatarViewLayoutBinding
import com.husseinhj.customerinfoapp.util.onCompletion

class UserAvatarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    var avatarUrl: String = ""
        set(value) {
            field = value
            binding.showAlt = true
            downloadImage(value, binding.avatarIv)
        }

    var avatarAlt: String = ""
        set(value) {
            field = value
            binding.avatarAlt = field
        }

    private var binding: UserAvatarViewLayoutBinding = UserAvatarViewLayoutBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    init {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.UserAvatarView)
            if (typedArray.hasValue(R.styleable.UserAvatarView_avatar_url)) {
                avatarUrl = typedArray.getString(R.styleable.UserAvatarView_avatar_url) ?: avatarUrl
            }

            if (typedArray.hasValue(R.styleable.UserAvatarView_avatar_alt)) {
                avatarAlt = typedArray.getString(R.styleable.UserAvatarView_avatar_alt) ?: avatarAlt
            }

            typedArray.recycle()
        }
    }

    private fun downloadImage(url: String, imageView: ShapeableImageView) {
        Glide.with(imageView.context)
            .load(url)
            .onCompletion { drawable, e ->
                binding.showAlt = drawable == null
            }
            .into(imageView)
    }
}