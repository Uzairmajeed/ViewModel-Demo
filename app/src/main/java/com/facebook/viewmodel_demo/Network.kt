package com.facebook.viewmodel_demo

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONException

class Network{
    companion object {
        // This is a companion object where you can define static methods or properties
        fun fetchServerData(url: String, requestQueue: RequestQueue, onDataReceived: (Int, String, String) -> Unit) {
            val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET, url, null,
                { response ->
                    try {
                        val id = response.getInt("id")
                        val description = response.getString("description")
                        val title = response.getString("title")
                        onDataReceived(id, description, title)
                    } catch (e: JSONException) {
                        throw RuntimeException(e)
                    }
                },
                { error ->
                    error.printStackTrace()
                }
            )
            requestQueue.add(jsonObjectRequest)
        }
    }
}
