package com.asprog.featuredagger.ui.innerScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject


class DagInnerViewModel @Inject constructor(
//    private val repository: DaggerInnerRepository
) : ViewModel() {

    fun showLog(msg: String) {
        Log.e("TAG", msg)
    }


}

/*@Singleton
class ViewModelFactory @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>,
        @JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        viewModels[modelClass]?.get() as T
}*/

