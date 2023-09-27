package com.husseinhj.customerinfoapp.presentation.user_list.component.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.husseinhj.customerinfoapp.data.remote.dto.Customer
import com.husseinhj.customerinfoapp.databinding.UserListItemLayoutBinding

class UserListItemViewHolder (private val binding: UserListItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    fun setBind(model: Customer) {
        binding.model = model
    }

    fun setOnClick(listener: UserListItemOnClickListener?) {
        binding.onClickedListener = View.OnClickListener {
            listener?.onClickListener(binding.model!!)
        }
    }
}