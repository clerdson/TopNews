package com.example.topnews.ui

import com.example.topnews.ui.models.topnewsresponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface newService {
@GET("top-headlines")
fun getArticles(
    @Query("country")country:String,
    @Query("apiKey")apiKey:String
): Call<topnewsresponse>

}