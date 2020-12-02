package com.example.marvel.repository

import com.example.marvel.api.NetworkUtils
import com.example.marvel.hq.model.ComicDataWrapModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicEndpoint {
    @GET("/v1/public/comics")
    suspend fun getAllComics(
        @Query("format") format: String?,
        @Query("formatType") formatType: String?,
        @Query("noVariants") noVariants: Boolean,
        @Query("ts") ts: String?,
        @Query("hash") hash: String?,
        @Query("apikey") apikey: String?
    ): ComicDataWrapModel

    @GET("/v1/public/comics/{id}")
    suspend fun getComic(
        @Path("id") id:Int,
        @Query("format") format: String?,
        @Query("formatType") formatType: String?,
        @Query("noVariants") noVariants: Boolean,
        @Query("ts") ts: String?,
        @Query("hash") hash: String?,
        @Query("apikey") apikey: String?
    ): ComicDataWrapModel

    companion object {
        val endpoint: ComicEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(ComicEndpoint::class.java)
        }
    }
}