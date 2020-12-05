package com.example.marvel.hq.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.marvel.R
import com.example.marvel.hq.model.ComicModel
import com.example.marvel.hq.view.MainFragment.Companion.ID_KEY
import com.example.marvel.hq.viewmodel.ComicViewModel
import com.example.marvel.repository.ComicRepository
import com.squareup.picasso.Picasso

class ComicDetailsFragment : Fragment() {

    private lateinit var _viewModel: ComicViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comic_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val getId = arguments?.getInt(ID_KEY)
        var comic: ComicModel




        _viewModel = ViewModelProvider(
            this,
            ComicViewModel.ComicViewModelFactory(ComicRepository())
        ).get(ComicViewModel::class.java)

        if (getId != null) {
            _viewModel.getComic(getId).observe(viewLifecycleOwner) {
                val newThumbnail  = "${it.thumbnail.path}.${it.thumbnail.extension}"
                val newConver = "${it.thumbnail.path}/portrait_uncanny.${it.thumbnail.extension}"
                val newPage = it.pageCount

                val newPrice = it.prices[0].price

                val newTitle = it.title
                val newSummary = it.description
                val newPublished = it.dates[0].date.split("T")

                val thumbnail = view.findViewById<ImageView>(R.id.img_tumbnail_comicDetails)
                val cover = view.findViewById<ImageView>(R.id.img_cover_comicDetails)

                val pages = view.findViewById<TextView>(R.id.txt_totalPages_comicDetails)
                val price = view.findViewById<TextView>(R.id.txt_price_comicDetails)
                val title = view.findViewById<TextView>(R.id.toolbar_title_comicDetails)
                val summary = view.findViewById<TextView>(R.id.txt_summary_comicDetals)
                val published = view.findViewById<TextView>(R.id.txt_published_comicDetails)

                pages.text = newPage.toString()
                price.text = newPrice.toString()
                title.text = newTitle
                summary.text = newSummary
                published.text = newPublished.toString()

                Picasso.get().load(newConver).into(cover)
                Picasso.get().load(newThumbnail).into(thumbnail)
            }
        }

        val navController = Navigation.findNavController(view)

        val arrowBack = view.findViewById<ImageView>(R.id.arrowBack_comicDetails)

        arrowBack.setOnClickListener {
            navController.popBackStack()
        }

    }

}