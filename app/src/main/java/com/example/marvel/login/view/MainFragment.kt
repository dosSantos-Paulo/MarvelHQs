package com.example.marvel.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R

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
        val hqAdapter = HqListAdapter(testeItens(10))

        recyclerView.apply {
            layoutManager = viewManager
            adapter = hqAdapter
        }
    }

    fun testeItens (contador: Int): MutableList<Int>{
        val list = mutableListOf<Int>()

        for (i in 0 until contador) {
            list.add(R.drawable.ic_launcher_background)
        }

        return list
    }

    companion object {
        const val COLLUNM_SIZE = 3
    }

}