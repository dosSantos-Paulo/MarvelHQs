package com.example.marvel.repository

import com.example.marvel.api.MY_PUPLIC_KEY
import getHash
import getTimeStamp

class ComicRepository {
    private val _client = ComicEndpoint.endpoint

    suspend fun getAllComics() = _client.getAllComics(
        "comic",
        "comic",
        true,
        getTimeStamp(),
        getHash(),
        MY_PUPLIC_KEY
    )

    suspend fun getComic(id: Int) = _client.getComic(
        id,
        "comic",
        "comic",
        true,
        getTimeStamp(),
        getHash(),
        MY_PUPLIC_KEY
    )
}