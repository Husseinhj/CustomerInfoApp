package com.husseinhj.customerinfoapp.presentation.common

import android.widget.LinearLayout
import com.husseinhj.customerinfoapp.R
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.husseinhj.customerinfoapp.data.remote.dto.Sticker
import com.husseinhj.customerinfoapp.data.remote.dto.Customer
import com.husseinhj.customerinfoapp.util.applyDividerConfiguration
import com.husseinhj.customerinfoapp.presentation.common.sticker_view.StickerView
import com.husseinhj.customerinfoapp.presentation.user_list.component.adapter.UserItemAdapter

@BindingAdapter("userList")
fun bindUserListAdapter(recyclerView: RecyclerView, users: List<Customer>) {
    val adapter = recyclerView.adapter as? UserItemAdapter ?: UserItemAdapter()

    recyclerView.applyDividerConfiguration()
    recyclerView.adapter = adapter
    adapter.submitList(users)
}

@BindingAdapter("userStickers")
fun bindUserStickers(linearLayout: LinearLayout, stickers: List<Sticker>) {
    linearLayout.removeAllViews()

    val context = linearLayout.context
    stickers.forEach { item ->
        val stickerView = StickerView(context)
        stickerView.stickerTitle = item.name

        if (item == Sticker.Ban) {
            stickerView.stickerTextColor = R.color.Content_Alert
            stickerView.stickerBackgroundColor = R.color.Background_Alert_Subtle
        } else {
            stickerView.stickerTextColor = R.color.Content_Subtle
            stickerView.stickerBackgroundColor = R.color.Background_Surface_Alt
        }

        linearLayout.addView(stickerView)
    }
}