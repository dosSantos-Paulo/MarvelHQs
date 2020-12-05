package com.example.marvel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import com.squareup.picasso.Picasso


class OpenCardFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_open_card, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val closeButton = view.findViewById<ImageView>(R.id.closeButton_openCard)
        val fullCardImage = view.findViewById<ImageView>(R.id.card_openCard)
        val navController = Navigation.findNavController(view)
        val cover = arguments?.getString("COVER")

        Picasso.get().load(cover).into(fullCardImage)



        closeButton.setOnClickListener {
            navController.popBackStack()
        }
    }
}