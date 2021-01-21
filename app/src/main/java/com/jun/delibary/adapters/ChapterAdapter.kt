package com.jun.delibary.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jun.delibary.databinding.SingleChapterBinding
import com.jun.delibary.model.Chapter
import com.squareup.picasso.Picasso
import java.util.*

class ChapterAdapter(private val context: Context, private val chapters: ArrayList<Chapter>) :
    RecyclerView.Adapter<ChapterAdapter.CustomViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemBinding=SingleChapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CustomViewHolder(itemBinding)

    }

    override fun getItemCount()= chapters.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val chapter: Chapter = chapters[position]
        holder.bind(chapter)
    }

    inner class CustomViewHolder(private val itemBinding: SingleChapterBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(chapter: Chapter){
            itemBinding.tvChapterName.setText(chapter.chapterName)
            Picasso.get().load(chapter.imageUrl).into(itemBinding.ivChapter)
        }

    }

}