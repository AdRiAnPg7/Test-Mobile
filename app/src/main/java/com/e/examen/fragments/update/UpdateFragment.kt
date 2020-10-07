package com.e.examen.fragments.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.e.examen.R
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_update, container, false)

        view.updateTitle_et.setText(args.currentBook.title)
        view.updatePages_et.setText(args.currentBook.pages.toString())
        view.updateEditorial_et.setText(args.currentBook.editorial)
        view.updateAuthor_et.setText(args.currentBook.author)
        view.updateDescription_et.setText(args.currentBook.description)
        view.updatePhotoUrl_et.setText(args.currentBook.photoUrl)

        return  view
    }

}