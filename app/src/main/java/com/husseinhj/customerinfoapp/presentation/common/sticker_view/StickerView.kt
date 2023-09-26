package com.husseinhj.customerinfoapp.presentation.common.sticker_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.husseinhj.customerinfoapp.R
import androidx.core.content.res.ResourcesCompat
import com.husseinhj.customerinfoapp.databinding.StickerViewLayoutBinding

class StickerView : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    var stickerTitle: String = ""
        set(value) {
            field = value
            binding.stickerTitle = value
        }

    var stickerTextColor: Int = R.color.Background_Surface_Alt
        set(value) {
            field = value
            binding.stickerTextColor = ResourcesCompat.getColor(
                this.resources,
                field, this.context.theme
            )
        }
    var stickerBackgroundColor: Int = R.color.Content_Subtle
        set(value) {
            field = value
            binding.stickerBackgroundColor = ResourcesCompat.getColor(
                this.resources,
                field, this.context.theme
            )
        }

    private var binding: StickerViewLayoutBinding = StickerViewLayoutBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )
}