package com.husseinhj.customerinfoapp.presentation.user_list.component.adapter

import javax.inject.Inject
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.husseinhj.customerinfoapp.data.remote.dto.Customer
import com.husseinhj.customerinfoapp.databinding.UserListItemLayoutBinding
import com.husseinhj.customerinfoapp.presentation.user_list.component.viewholder.UserListItemViewHolder

class UserItemAdapter @Inject constructor(): ListAdapter<Customer, UserListItemViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserListItemLayoutBinding.inflate(inflater, parent, false)

        return UserListItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserListItemViewHolder, position: Int) {
        holder.setBind(getItem(position))
    }

    class DiffCallback: DiffUtil.ItemCallback<Customer>() {
        override fun areItemsTheSame(oldItem: Customer, newItem: Customer, ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Customer, newItem: Customer): Boolean {
            return oldItem.id == newItem.id
        }
    }
}