package com.example.marvel.hq.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.hq.model.ComicBook

class MainFragment : Fragment() {

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
        val hqAdapter = HqListAdapter(testeItens(40)) {
            val bundle = bundleOf(
                TUMBNAIL_KEY to it.tumbnail,
                COVER_KEY to it.cover,
                TITLE_KEY to it.title,
                SUMMARY_KEY to it.summary,
                PUBLISHED_KEY to it.published,
                PRICE_KEY to it.price,
                PAGE_KEY to it.pages
            )
            navController.navigate(R.id.action_mainFragment_to_comicDetailsFragment, bundle)
        }

        recyclerView.apply {
            layoutManager = viewManager
            adapter = hqAdapter
        }
    }

    fun testeItens(contador: Int): MutableList<ComicBook> {
        val list = mutableListOf<ComicBook>()

        for (i in 0 until contador) {
            list.add(
                ComicBook(
                    "Amazing Spider Man(2014)",
                    103,
                    getString(R.string.lorenIpsun),
                    "May 31, 1991",
                    99.99,
                    29,
                    R.drawable.cover_test,
                    R.drawable.tumbnail_test
                )
            )
        }

        return list
    }

    companion object {
        const val COLLUNM_SIZE = 3
        const val TUMBNAIL_KEY = "TUMBNAIL"
        const val COVER_KEY = "COVER"
        const val TITLE_KEY = "TITLE"
        const val SUMMARY_KEY = "SUMMARY"
        const val PUBLISHED_KEY = "PUBLISHED"
        const val PRICE_KEY = "PRICE"
        const val PAGE_KEY = "PAGE"
    }

}