package com.jun.delibary.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jun.delibary.databinding.SingleSubjectBinding
import com.jun.delibary.model.Subject
import java.util.*

class SubjectAdapter(private val subjects: ArrayList<Subject>, private val context: Context) :
    RecyclerView.Adapter<SubjectAdapter.ViewHolder?>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding=
            SingleSubjectBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)

    }

    override fun getItemCount(): Int {
        return subjects.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(subjects[position])
    }
    inner class ViewHolder(private val itemBinding: SingleSubjectBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(subject:Subject){
            itemBinding.rvChapters.setHasFixedSize(true)
            itemBinding.rvChapters.setAdapter(ChapterAdapter(context, subject.chapters))
            itemBinding.rvChapters.setLayoutManager(
                LinearLayoutManager(
                    context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            )
            itemBinding.tvSubjectName.setText(subject.subjectName)
        }

    }

}
