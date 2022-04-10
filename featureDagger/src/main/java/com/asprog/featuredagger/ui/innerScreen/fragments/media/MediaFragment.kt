package com.asprog.featuredagger.ui.innerScreen.fragments.media

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.asprog.featuredagger.databinding.MediaFragmentBinding
import com.asprog.featuredagger.di.deps.AppDependencyComponentViewModel
import javax.inject.Inject

class MediaFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: MediaViewModel

    private var _binding: MediaFragmentBinding? = null
    private val binding: MediaFragmentBinding
        get() = _binding!!


    override fun onAttach(context: Context) {
        super.onAttach(context)
        ViewModelProvider(this)
            .get<AppDependencyComponentViewModel>()
            .newAppDependencyComponent
            .inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[MediaViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MediaFragmentBinding.inflate(inflater, container, false)
        _binding!!.mediaViewModel = viewModel
        _binding!!.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}