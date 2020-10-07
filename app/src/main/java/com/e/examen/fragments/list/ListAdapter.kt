package com.e.examen.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.examen.R
import com.e.examen.model.Book
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.book_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var bookList = emptyList<Book>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.book_row, parent, false))
    }

    override fun getItemCount(): Int {
        return  bookList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val picasso = Picasso.get()
        val currentItem =  bookList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.title_txt.text = currentItem.title
        holder.itemView.editorial_txt.text = currentItem.editorial
        holder.itemView.author_txt.text = currentItem.author
        holder.itemView.pages_txt.text = currentItem.pages.toString()
        holder.itemView.description_txt.text = currentItem.description
        picasso.load(currentItem.photoUrl)
            .into(holder.itemView.my_image_view)
    }

    fun setData (books : List <Book>){
        this.bookList = books
        notifyDataSetChanged()
    }



}