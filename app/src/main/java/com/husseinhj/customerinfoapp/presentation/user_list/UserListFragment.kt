package com.husseinhj.customerinfoapp.presentation.user_list

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.husseinhj.customerinfoapp.R
import com.husseinhj.customerinfoapp.data.remote.dto.Customer
import dagger.hilt.android.AndroidEntryPoint
import com.husseinhj.customerinfoapp.databinding.FragmentUserListBinding
import com.husseinhj.customerinfoapp.presentation.user_detail.UserDetailFragmentArgs
import com.husseinhj.customerinfoapp.presentation.user_list.component.viewholder.UserListItemOnClickListener

@AndroidEntryPoint
class UserListFragment : Fragment() {

    private lateinit var binding: FragmentUserListBinding
    private val viewModel: UserListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentUserListBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.onItemClickListener = object: UserListItemOnClickListener {
            override fun onClickListener(customer: Customer) {
                val args = UserDetailFragmentArgs(customer.id)
                findNavController().navigate(R.id.userDetailFragment, args.toBundle())
            }
        }

        return binding.root
    }
}