package com.example.marvel.hq.model

data class ComicDataWrapModel(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHtml: String,
    val data: ComicDataContainerModel,
    val etag: String
)