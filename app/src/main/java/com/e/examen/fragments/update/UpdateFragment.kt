package com.e.examen.fragments.update

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.e.examen.R
import com.e.examen.model.Book
import com.e.examen.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mBookViewModel :BookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_update, container, false)

        mBookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        view.updateTitle_et.setText(args.currentBook.title)
        view.updatePages_et.setText(args.currentBook.pages.toString())
        view.updateEditorial_et.setText(args.currentBook.editorial)
        view.updateAuthor_et.setText(args.currentBook.author)
        view.updateDescription_et.setText(args.currentBook.description)
        view.updatePhotoUrl_et.setText(args.currentBook.photoUrl)

        view.updateBook_btn.setOnClickListener {
            updateItem()
        }

        return  view
    }

    private  fun updateItem(){
        val title = updateTitle_et.text.toString()
        val pages = Integer.parseInt(updatePages_et.text.toString())
        val editorial  = updateEditorial_et.text.toString()
        val author  = updateAuthor_et.text.toString()
        val description = updateDescription_et.text.toString()
        val photoUrl = updatePhotoUrl_et.text.toString()

        if(inputCheck(title, updatePages_et.text, editorial, author, description, photoUrl)){
            // Create Book Object
            val updateBook = Book (args.currentBook.id, title, pages, editorial, author, description, photoUrl)
            //Update Book Data
            mBookViewModel.updateBook(updateBook)
            Toast.makeText(requireContext(), "Book Updated Succesfully!!", Toast.LENGTH_SHORT).show()
            // Go to List
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please Fill All Fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck (title:String, pages: Editable, editorial: String, author: String, description: String, photoUrl: String): Boolean{
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(editorial) && TextUtils.isEmpty(author) && TextUtils.isEmpty(description) && TextUtils.isEmpty(photoUrl) && pages.isEmpty()  )
    }
}