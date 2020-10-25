package com.tp.newsletter.repository

import com.google.gson.GsonBuilder
import com.tp.newsletter.model.Article
import com.tp.newsletter.services.ArticleService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ArticleRepository(val articleType: String) {
    private val service: ArticleService
    private val url = "https://newsapi.org/v2/"
    private var type = "sports"
    init {
        val gson = GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create()
        val retrofit = Retrofit.Builder().apply {
            baseUrl(url)
        }.addConverterFactory(GsonConverterFactory.create(gson)).build()

        service = retrofit.create(ArticleService::class.java)
    }
    fun list(): List<Article> {
        val response = service.list().execute()
        return response.body() ?: emptyList()
    }
    //get articles

    suspend fun getArticles() = service.listArticles(articleType).articles
}