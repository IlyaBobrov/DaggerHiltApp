package com.asprog.featuredagger.ui.innerScreen.fragments.chat

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.asprog.featuredagger.databinding.ChatFragmentBinding
import com.asprog.featuredagger.di.deps.AppDependencyComponentViewModel
import javax.inject.Inject

class ChatFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: ChatViewModel

    private var _binding: ChatFragmentBinding? = null
    private val binding: ChatFragmentBinding
        get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ViewModelProvider(this)
            .get<AppDependencyComponentViewModel>()
            .newAppDependencyComponent
            .inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[ChatViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ChatFragmentBinding.inflate(inflater, container, false)
        _binding!!.chatViewModel = viewModel
        _binding!!.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNavigateMedia.setOnClickListener {
            val action = ChatFragmentDirections.actionChatFragmentToMediaFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}