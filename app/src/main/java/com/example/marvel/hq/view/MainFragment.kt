package com.example.marvel.hq.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.hq.model.ComicBook
import com.example.marvel.hq.model.ComicModel
import com.example.marvel.hq.viewmodel.ComicViewModel
import com.example.marvel.repository.ComicRepository
import java.lang.Exception

class MainFragment : Fragment() {

    private lateinit var _viewModel: ComicViewModel
    private lateinit var _adapter: HqListAdapter

    private var _comicList = mutableListOf<ComicModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val viewManager = GridLayoutManager(view.context, COLLUNM_SIZE)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_main)

        _comicList = mutableListOf()
        _adapter = HqListAdapter(_comicList) {

            val bundle = bundleOf(ID_KEY to it.id)
            navController.navigate(R.id.action_mainFragment_to_comicDetailsFragment, bundle)
        }

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = _adapter
        }

        _viewModel = ViewModelProvider(
            this,
            ComicViewModel.ComicViewModelFactory(ComicRepository())
        ).get(ComicViewModel::class.java)


        _viewModel.getAllComics().observe(viewLifecycleOwner, {
            it.let { _comicList.addAll(it) }
            _adapter.notifyDataSetChanged()
        })


    }

    companion object {
        const val COLLUNM_SIZE = 3
        const val ID_KEY = "ID"
    }

}