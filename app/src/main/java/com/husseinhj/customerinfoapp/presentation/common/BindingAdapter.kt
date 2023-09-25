package com.husseinhj.customerinfoapp.presentation.common

import com.bumptech.glide.Glide
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.husseinhj.customerinfoapp.data.remote.dto.Customer
import com.google.android.material.imageview.ShapeableImageView
import com.husseinhj.customerinfoapp.util.applyDividerConfiguration
import com.husseinhj.customerinfoapp.presentation.user_list.component.adapter.UserItemAdapter

@BindingAdapter("remoteSrc")
fun bindRemoteImageSource(imageView: ShapeableImageView, src: String?) {
    Glide.with(imageView.context).load(src).into(imageView)
}

@BindingAdapter("userList")
fun bindUserListAdapter(recyclerView: RecyclerView, users: List<Customer>) {
    val adapter = recyclerView.adapter as? UserItemAdapter ?: UserItemAdapter()

    recyclerView.applyDividerConfiguration()
    recyclerView.adapter = adapter
    adapter.submitList(users)
}