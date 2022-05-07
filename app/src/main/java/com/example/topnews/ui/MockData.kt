package com.example.topnews.ui

import com.example.topnews.R
 object  MockData {
    val topNewsList = listOf<News>(
        News(
            id = 1,

            author = "clerdson juca dos santos"
        ),
                News(
                id = 2,

        author = "matheus juca "
    ),
                        News(
                        id = 3,

        author = "cleide barbosa juca"
    ),
        News(
            id = 4,

            author = "claudiene paixao dos santos"
        )
    ,  News(
            id = 5,

            author = "Antonio "
        )
    )
     fun getNews(id: Int?):News{
         return topNewsList.first{it.id == id}
     }
}