package com.example.topnews.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.topnews.R
import com.example.topnews.ui.screens.DetailsScren
import com.example.topnews.ui.screens.TopNews

@Composable
fun NewsApp() {
Navigation()
}
@Composable
fun Navigation(manager: Manager = Manager()){
    val articles = manager.newResponse.value.articles
    Log.d("new","$articles")
    val navController = rememberNavController()
    val manager = Manager()
    articles?.let {
        NavHost(
            navController = navController,
            startDestination = "TopNews"
        ){
            composable("TopNews"){
                TopNews(navController = navController,articles)
            }
            composable(
                "Detail/{index}",
                arguments = listOf(navArgument("index"){type = NavType.IntType})
            ){
                    navBackStackEntry->
                val index = navBackStackEntry.arguments?.getInt("index")
              index?.let {
                  val articles = articles[index]
                  DetailsScren(articles,navController)
              }

            }
        }
    }

}