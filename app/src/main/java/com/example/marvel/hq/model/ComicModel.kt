package com.example.marvel.hq.model

data class ComicModel(
    val id: Int,
    val title: String,
    val issueNumber: Double,
    val description: String,
    val prices: List<ComicPriceModel>,
    val dates: List<ComicDateModel>,
    val images: List<ImageModel>,
    val thumbnail: ImageModel,
    val pageCount: Int
)
