package com.example.marvel.hq.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.marvel.hq.model.ComicModel
import com.example.marvel.repository.ComicRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class ComicViewModel(
    private val _repository: ComicRepository
) : ViewModel() {

    private var _comicsList: List<ComicModel> = listOf()
    private lateinit var _comic: ComicModel

    fun getAllComics() = liveData(Dispatchers.IO) {
        try{
            val response = _repository.getAllComics().data.results
            _comicsList = response
            emit(response)
        } catch (ex: Exception){
            println("ERRO: ${ex.message}")
        }

    }

    fun getComic(id: Int) = liveData(Dispatchers.IO) {
        val response = _repository.getComic(id).data.results[0]
        _comic = response
        emit(response)
    }

    class ComicViewModelFactory(private val _repository: ComicRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ComicViewModel(_repository) as T
        }
    }
}
