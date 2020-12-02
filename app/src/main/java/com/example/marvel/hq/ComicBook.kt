package com.example.marvel.hq

data class ComicBook(
    val title: String,
    val numberEdition: Int,
    val summary: String,
    val published: String,
    val price: Double,
    val pages: Int,
    val cover: Int,
    val tumbnail: Int
)