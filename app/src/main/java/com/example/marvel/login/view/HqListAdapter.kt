package com.example.marvel.login.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.hq.ComicBook
import com.squareup.picasso.Picasso

class HqListAdapter(
    private val _dataSet: MutableList<ComicBook>,
    private val _listener: (ComicBook) -> Unit
) : RecyclerView.Adapter<HqListAdapter.HqViewHolder>() {

    class HqViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val _hqImage: ImageView = view.findViewById(R.id.img_item)
        private val _hqNumbEdition: TextView = view.findViewById(R.id.txt_number_item)

        @SuppressLint("SetTextI18n")
        fun bind(item: ComicBook) {
            Picasso.get().load(item.cover).into(_hqImage)
            _hqNumbEdition.text = "# ${item.numberEdition}"
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HqViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return HqViewHolder(view)
    }

    override fun onBindViewHolder(holder: HqViewHolder, position: Int) {
        val item = _dataSet[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { _listener(item) }
    }

    override fun getItemCount() = _dataSet.size

}