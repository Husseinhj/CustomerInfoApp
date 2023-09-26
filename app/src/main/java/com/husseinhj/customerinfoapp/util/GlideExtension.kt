package com.husseinhj.customerinfoapp.util

import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.DataSource
import android.graphics.drawable.Drawable
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.load.engine.GlideException

fun RequestBuilder<Drawable>.onCompletion(action: (drawable: Drawable?, e: GlideException?) -> Unit): RequestBuilder<Drawable> {
    return this.addListener(object : RequestListener<Drawable> {
        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Drawable>,
            isFirstResource: Boolean
        ): Boolean {
            action.invoke(null, e)
            return false
        }

        override fun onResourceReady(
            resource: Drawable,
            model: Any,
            target: Target<Drawable>?,
            dataSource: DataSource,
            isFirstResource: Boolean
        ): Boolean {
            action.invoke(resource, null)
            return false
        }
    })
}