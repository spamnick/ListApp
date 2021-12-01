package com.github.kolya.listapp.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.kolya.listapp.databinding.UserListFragmentBinding
import com.github.kolya.listapp.models.UserDataUI
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class UserListFragment : Fragment() {
    private var viewBinding: UserListFragmentBinding? = null
    private val binding get() = viewBinding!!

    private val viewModel: UserListViewModel by viewModel { parametersOf() }

    lateinit var userListAdapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = UserListFragmentBinding.inflate(inflater, container, false)
        setupRecyclerVIew()
        setupViewModel()
        return binding.root
    }

    private fun setupViewModel() {
        viewModel.listUiData.observe(viewLifecycleOwner) { listState ->
            when (listState) {
                is UserListViewModel.ListState.ListLoaded -> {
                    hideLoading()
                    displayList(listState.list)
                }
                UserListViewModel.ListState.Loading -> {
                    showLoading()
                }
            }
        }
    }

    private fun setupRecyclerVIew() {
        userListAdapter = UserListAdapter()
        userListAdapter.onItemClickListener = { userDataUI ->
            findNavController().navigate(
                UserListFragmentDirections.actionUserListFragmentToUserDetailsFragment(userDataUI)
            )
        }
        with(binding) {
            recyclerView.run {
                adapter = userListAdapter
            }
        }
    }

    private fun displayList(list: List<UserDataUI>) {
        userListAdapter.submitList(list)
    }

    private fun hideLoading() {
        binding.progressBar.isVisible = false
        binding.recyclerView.isVisible = true
    }

    private fun showLoading() {
        binding.progressBar.isVisible = true
        binding.recyclerView.isVisible = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

}