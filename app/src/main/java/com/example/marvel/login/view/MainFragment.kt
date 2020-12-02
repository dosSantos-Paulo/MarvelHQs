package com.example.marvel.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.hq.ComicBook

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewManager = GridLayoutManager(view.context, COLLUNM_SIZE)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_main)
        val hqAdapter = HqListAdapter(testeItens(40))

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
                    15,
                    "the Gratest Super Hero",
                    "April 30, 2014",
                    5.99,
                    38,
                    R.drawable.cover_test,
                    R.drawable.tumbnail_test
                )
            )
        }

        return list
    }

    companion object {
        const val COLLUNM_SIZE = 3
    }

}