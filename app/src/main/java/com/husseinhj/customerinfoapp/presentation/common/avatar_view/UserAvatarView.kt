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

    private var binding: UserAvatarViewLayoutBinding = UserAvatarViewLayoutBinding.inflate(
        LayoutInflater.from(context), this, true
    )

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

    init {

        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.UserAvatarView)
            if (typedArray.hasValue(R.styleable.UserAvatarView_avatar_url)) {
                avatarUrl = typedArray.getString(R.styleable.UserAvatarView_avatar_url) ?: avatarUrl
            } else {
                binding.showAlt = true
            }

            if (typedArray.hasValue(R.styleable.UserAvatarView_avatar_alt)) {
                avatarAlt = typedArray.getString(R.styleable.UserAvatarView_avatar_alt) ?: avatarAlt
            }
            if (typedArray.hasValue(R.styleable.UserAvatarView_avatar_first_name) &&
                typedArray.hasValue(R.styleable.UserAvatarView_avatar_last_name)) {
                val firstName = typedArray.getString(R.styleable.UserAvatarView_avatar_first_name) ?: ""
                val lastName = typedArray.getString(R.styleable.UserAvatarView_avatar_last_name) ?: ""

                val firstCharOfName = firstName.firstOrNull() ?: ""
                val firstCharOfLastName = lastName.firstOrNull() ?: ""

                avatarAlt = "$firstCharOfName$firstCharOfLastName"
            }

            typedArray.recycle()
        } else {
            binding.avatarAlt = "ab"
            binding.showAlt = true
        }
    }

    private fun downloadImage(url: String, imageView: ShapeableImageView) {
        if (url.isEmpty() || url.isBlank()) {
            binding.showAlt = true
            return
        }
        Glide.with(context)
            .load(url)
            .onCompletion { drawable, _ ->
                binding.showAlt = drawable == null
            }
            .into(imageView)
    }
}