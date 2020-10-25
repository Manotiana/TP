package com.tp.newsletter.services

import com.tp.newsletter.model.Article
import com.tp.newsletter.model.ArticleResponse
import com.tp.newsletter.model.Category
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {

    @GET("/articles")
    fun list(): Call<List<Article>>


    //suspend fun listArticles(@Query("q") q : String, @Query("apiKey") apiKey: String = "d919a51ac9404a64ab2a81d7674219a1") : List<Article>
    @GET("everything?apiKey=d919a51ac9404a64ab2a81d7674219a1")
    suspend fun listArticles(@Query("q") categoryArticle: String): ArticleResponse
}
