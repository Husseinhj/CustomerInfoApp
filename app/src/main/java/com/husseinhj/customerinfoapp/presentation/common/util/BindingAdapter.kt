package com.husseinhj.customerinfoapp.presentation.common.util

import android.widget.LinearLayout
import android.widget.TextView
import com.husseinhj.customerinfoapp.R
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.husseinhj.customerinfoapp.data.remote.dto.Address
import com.husseinhj.customerinfoapp.data.remote.dto.Sticker
import com.husseinhj.customerinfoapp.data.remote.dto.Customer
import com.husseinhj.customerinfoapp.util.applyDividerConfiguration
import com.husseinhj.customerinfoapp.presentation.common.sticker_view.StickerView
import com.husseinhj.customerinfoapp.presentation.user_list.component.adapter.UserItemAdapter
import com.husseinhj.customerinfoapp.presentation.user_list.component.viewholder.UserListItemOnClickListener

@BindingAdapter("userList", "onItemClickListener", requireAll = true)
fun bindUserListAdapter(recyclerView: RecyclerView, users: List<Customer>, onItemClickListener: UserListItemOnClickListener) {
    val adapter = recyclerView.adapter as? UserItemAdapter ?: UserItemAdapter()
    adapter.setOnItemClickListener(onItemClickListener)

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

@BindingAdapter("userAddress")
fun bindUserAddress(textView: TextView, address: Address) {
    textView.text =
        textView.context.getString(
            R.string.user_address_format,
            address.street,
            address.zip,
            address.city
        )
}