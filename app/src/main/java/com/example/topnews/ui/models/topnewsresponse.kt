package com.example.topnews.ui.models

import com.example.topnews.ui.News

data class topnewsresponse (
    val status:String?  =null,
    val totalResult:Int?  = null,
    val articles:List<News>? = null
        )