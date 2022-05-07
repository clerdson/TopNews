package com.example.topnews.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.topnews.ui.models.topnewsresponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Manager {
    private val _newResponse = mutableStateOf(topnewsresponse())
    val newResponse: State<topnewsresponse>
    @Composable get() = remember {
        _newResponse
    }
    init {
        getArticles()
    }
    private  fun getArticles(){
         val service  = Api.retrofitServise.getArticles("us","717d3e541fa1492e8aa2e7f163972bf5")
        service.enqueue(object : Callback<topnewsresponse> {
            override fun onResponse(
                call: Call<topnewsresponse>,
                response: Response<topnewsresponse>
            ) {
               if (response.isSuccessful){
                   _newResponse.value = response.body()!!
                   Log.d("new","${_newResponse.value}")
               }
            }

            override fun onFailure(call: Call<topnewsresponse>, t: Throwable) {
                Log.d("error","${t.printStackTrace()}")
            }
        })
    }
}