package com.example.topnews.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.topnews.ui.MockData


import com.example.topnews.ui.News
import com.example.topnews.ui.models.topnewsresponse
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun TopNews(navController: NavController ,articles: List<News>){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        LazyColumn{

            items(articles.size){
index->
                TopNewItem(article = articles[index],
                onNewClick = {navController.navigate("Detail/$index")})
            }
        }
    }
}
@Composable
fun TopNewItem(article:News,onNewClick:()->Unit = {}){



        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(top = 16.dp, start = 16.dp)
                .clickable {
                           onNewClick()
                }
        ,verticalArrangement = Arrangement.SpaceBetween

        ) {
            CoilImage(
                imageModel = article.urlToImage,
                contentScale = ContentScale.Crop,

            )

            Text(
                text = article.author?:"no avaliable",
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
        }
    }


@Preview(showBackground = true)
@Composable
fun TopNewsPreview(){
News(
    id = 1,
author = "juca"
   )
}