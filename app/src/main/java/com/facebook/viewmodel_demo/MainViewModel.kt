package com.facebook.viewmodel_demo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.toolbox.Volley

class MainViewModel(private val context: Context) : ViewModel() {
    private val _ids = MutableLiveData<Int>()
    val ids: LiveData<Int> get() = _ids

    private val _descriptions = MutableLiveData<String>()
    val descriptions: LiveData<String> get()  = _descriptions

    private val _titles = MutableLiveData<String>()
    val titles: LiveData<String> get()  = _titles

    fun fetchData() {
        val requestQueue =Volley.newRequestQueue(context)

        val url = "https://dummyjson.com/products/5"

        Network.fetchServerData(url, requestQueue) { id, description, title ->
            _ids.value = id
            _descriptions.value = description
            _titles.value = title
        }
    }
}
