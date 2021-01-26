package com.jun.delibary.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jun.delibary.databinding.*
import com.jun.delibary.model.MainSlide
import com.jun.delibary.model.Subject
import com.squareup.picasso.Picasso
import java.util.*

class SubjectAdapter(private val subjects: ArrayList<Subject>, private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            Subject.IMAGE_TYPE-> {
                val itemBinding=SingleSubjectBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                SingleViewHolder(itemBinding)
            }
            Subject.SLIDE_TYPE-> {
                val itemBinding= SingleSlideBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                 MainSliderViewHolder(itemBinding)
            }
            Subject.TEXT_TYPE-> {
                val itemBinding= MainBennerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                BannerNameViewHolder(itemBinding)
            }
            else -> throw RuntimeException("View Error")
        }

    }

    override fun getItemCount(): Int {
        Log.d("getcount","${subjects.size}")
        return subjects.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val obj = subjects[position]
        when (obj.type) {
            Subject.IMAGE_TYPE -> (holder as SingleViewHolder).bind(obj)
            Subject.SLIDE_TYPE -> {
                (holder as MainSliderViewHolder).bind(obj)
            }
            Subject.TEXT_TYPE->{
                (holder as BannerNameViewHolder).bind(obj)
            }
            else -> throw RuntimeException("Bind Error")
        }
    }
    override fun getItemViewType(position: Int): Int {
        Log.d("MultiViewTypeAdapter", "Hi, getItemViewType")
        return subjects[position].type

    }
    inner class SingleViewHolder(private val itemBinding: SingleSubjectBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(subject:Subject){
            //아이템이 변경하지 않을것을 명시하여 성능하락 방지 == setHasFixedSize
            itemBinding.rvChapters.run{
                setHasFixedSize(true)
                adapter = subject.chapters?.let { ChapterAdapter(context, it) }
                layoutManager = LinearLayoutManager(
                        context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                )
            }
            itemBinding.tvSubjectName.text = subject.subjectName
        }
    }
    inner class MainSliderViewHolder(private val itemBinding: SingleSlideBinding): RecyclerView.ViewHolder(itemBinding.root){

        fun bind(subject:Subject){
            itemBinding.mainViewPager.run{
                adapter = subject.mainSliders?.let { MainSliderAdapter(context, it) }
                orientation=this.orientation

            }
        }
    }
    inner class BannerNameViewHolder(private val itemBinding: MainBennerBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(subject:Subject){
            itemBinding.toolbarText.text=subject.subjectName
        }
    }
}
