package com.asprog.featuredagger.ui.innerScreen.fragments.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asprog.featuredagger.sample.MyHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChatViewModel @Inject constructor(
    private val helper: MyHelper
) : ViewModel() {

    private val _counter = MutableStateFlow(0)
    val counter: StateFlow<Int> = _counter

    val viewModelName = "ChatViewModel"

    init {
        doAction(msg = "$viewModelName init!")
        viewModelScope.launch {
            while (true) {
                delay(1000)
                _counter.value = counter.value + 1
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        doAction(msg = "$viewModelName cleared!")
    }

    private fun doAction(msg: String = "ViewModel") {
        helper.showToast(msg)
    }
}
