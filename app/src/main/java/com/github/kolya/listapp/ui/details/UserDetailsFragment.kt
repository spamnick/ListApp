package com.github.kolya.listapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.github.kolya.listapp.databinding.UserDetailsFragmentBinding
import com.github.kolya.listapp.models.UserDataUI
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class UserDetailsFragment : Fragment() {
    private var viewBinding: UserDetailsFragmentBinding? = null
    private val binding get() = viewBinding!!

    private val args by navArgs<UserDetailsFragmentArgs>()

    private val viewModel: UserDetailsViewModel by viewModel { parametersOf(args.user) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = UserDetailsFragmentBinding.inflate(inflater, container, false)
        viewModel.uiData.observe(viewLifecycleOwner) {
            when (it) {
                UserDetailsViewModel.UiState.Loading -> {
                    showLoading()
                }
                is UserDetailsViewModel.UiState.UserLoaded -> {
                    hideLoading()
                    displayData(it.userDataUI)
                }
            }
        }
        return binding.root
    }

    private fun displayData(userDataUI: UserDataUI) {
        with(binding) {
            imageView.load(userDataUI.imageUrl)
            titleView.text = userDataUI.name
            linkView.text = userDataUI.link
        }
    }

    private fun showLoading() {
        with(binding) {
            progressBar.isVisible = true
            imageView.isVisible = false
            titleView.isVisible = false
            linkView.isVisible = false
        }
    }

    private fun hideLoading() {
        with(binding) {
            progressBar.isVisible = false
            imageView.isVisible = true
            titleView.isVisible = true
            linkView.isVisible = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

}