package com.example.marvel.hq.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.marvel.R
import com.example.marvel.hq.view.MainFragment.Companion.COVER_KEY
import com.example.marvel.hq.view.MainFragment.Companion.PAGE_KEY
import com.example.marvel.hq.view.MainFragment.Companion.PRICE_KEY
import com.example.marvel.hq.view.MainFragment.Companion.PUBLISHED_KEY
import com.example.marvel.hq.view.MainFragment.Companion.SUMMARY_KEY
import com.example.marvel.hq.view.MainFragment.Companion.TITLE_KEY
import com.example.marvel.hq.view.MainFragment.Companion.TUMBNAIL_KEY
import com.squareup.picasso.Picasso

class ComicDetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comic_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        val newTumbnail = arguments?.getInt(TUMBNAIL_KEY)
        val newConver = arguments?.getInt(COVER_KEY)
        val newPage = arguments?.getInt(PAGE_KEY)

        val newPrice = arguments?.getDouble(PRICE_KEY)

        val newTitle = arguments?.getString(TITLE_KEY)
        val newSummary = arguments?.getString(SUMMARY_KEY)
        val newPublished = arguments?.getString(PUBLISHED_KEY)

        val tumbnail = view.findViewById<ImageView>(R.id.img_tumbnail_comicDetails)
        val cover = view.findViewById<ImageView>(R.id.img_cover_comicDetails)

        val pages = view.findViewById<TextView>(R.id.txt_totalPages_comicDetails)
        val price = view.findViewById<TextView>(R.id.txt_price_comicDetails)
        val title = view.findViewById<TextView>(R.id.toolbar_title_comicDetails)
        val summary = view.findViewById<TextView>(R.id.txt_summary_comicDetals)
        val published = view.findViewById<TextView>(R.id.txt_published_comicDetails)

        val arrowBack = view.findViewById<ImageView>(R.id.arrowBack_comicDetails)

        newTumbnail?.let { Picasso.get().load(it).into(tumbnail) }
        newConver?.let { Picasso.get().load(it).into(cover) }

        pages.text = newPage.toString()
        price.text = newPrice.toString()
        title.text = newTitle.toString()
        summary.text = newSummary.toString()
        published.text = newPublished.toString()

        arrowBack.setOnClickListener {
            navController.popBackStack()
        }

    }

}