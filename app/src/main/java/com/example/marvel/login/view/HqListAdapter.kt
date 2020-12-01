package com.example.marvel.login.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.squareup.picasso.Picasso

class HqListAdapter (
    private val _dataSet: List<Int>
): RecyclerView.Adapter<HqListAdapter.HqViewHolder>(){

    class HqViewHolder (view: View): RecyclerView.ViewHolder(view){

        private val _hqImage: ImageView = view.findViewById(R.id.img_item)

        fun bind(item: Int){
            Picasso.get().load(item).into(_hqImage)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HqViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return HqViewHolder(view)
    }

    override fun onBindViewHolder(holder: HqViewHolder, position: Int) {
        val item = _dataSet[position]
        holder.bind(item)
    }

    override fun getItemCount() = _dataSet.size

}