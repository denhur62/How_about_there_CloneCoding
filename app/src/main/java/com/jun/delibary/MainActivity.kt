package com.jun.delibary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jun.delibary.adapters.MainSliderAdapter
import com.jun.delibary.adapters.SubjectAdapter
import com.jun.delibary.databinding.ActivityMainBinding
import com.jun.delibary.model.Chapter
import com.jun.delibary.model.MainSlide
import com.jun.delibary.model.Subject
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private var subjectAdapter: SubjectAdapter? = null
    private lateinit var dataBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)

        var subjects = prepareData()
        val manager = LinearLayoutManager(this@MainActivity)

        subjectAdapter = SubjectAdapter( subjects,this@MainActivity)

        dataBinding.rvSubject.apply{
            layoutManager = manager
            adapter = subjectAdapter
        }
    }

    private fun prepareData(): ArrayList<Subject> {
        var subjects: ArrayList<Subject> = ArrayList<Subject>()

        val bannerName=Subject(Subject.TEXT_TYPE,"여기 어때?",null,null)
        subjects.add(bannerName)

        val slideList=ArrayList<MainSlide>()
        val mainSlide1=MainSlide(R.drawable.image1)
        val mainSlide2=MainSlide(R.drawable.image2)
        val mainSlide3=MainSlide(R.drawable.image3)
        slideList.add(mainSlide1)
        slideList.add(mainSlide2)
        slideList.add(mainSlide3)
        val mainSliders=Subject(Subject.SLIDE_TYPE,null,null,slideList)

        subjects.add(mainSliders)


        val chapterList1=ArrayList<Chapter>()
        val chapter1 = Chapter(1,"Atomic power","http://ashishkudale.com/images/phy/atoms.png")
        val chapter2 = Chapter(2,"Theory of relativity","http://ashishkudale.com/images/phy/sigma.png")
        val chapter3 = Chapter(3,"Magnetic field","http://ashishkudale.com/images/phy/magnet.png")
        val chapter4 = Chapter(4,"Practical 1","http://ashishkudale.com/images/phy/caliper.png")
        val chapter5 = Chapter(5,"Practical 2","http://ashishkudale.com/images/phy/micrometer.png")
        chapterList1.add(chapter1)
        chapterList1.add(chapter2)
        chapterList1.add(chapter3)
        chapterList1.add(chapter4)
        chapterList1.add(chapter5)
        val physics = Subject(Subject.IMAGE_TYPE,"Physics",chapterList1,null)


        val chapterList2=ArrayList<Chapter>()
        val chapter6=Chapter(6,"Bacteria","http://ashishkudale.com/images/bio/bacteria.png")
        val chapter7=Chapter(7,"DNA and RNA","http://ashishkudale.com/images/bio/dna.png")
        val chapter8=Chapter(8,"Study of microscope","http://ashishkudale.com/images/bio/microscope.png")
        val chapter9=Chapter(9,"Protein and fibers","http://ashishkudale.com/images/bio/protein.png")
        chapterList2.add(chapter6)
        chapterList2.add(chapter7)
        chapterList2.add(chapter8)
        chapterList2.add(chapter9)
        val bio = Subject(Subject.IMAGE_TYPE,"Biology",chapterList2,null)

        val chapterList3=ArrayList<Chapter>()
        val chapter10=Chapter(10,"Circle","http://ashishkudale.com/images/maths/circle.png")
        val chapter11=Chapter(11,"Geometry","http://ashishkudale.com/images/maths/geometry.png")
        val chapter12=Chapter(12,"Linear equations","http://ashishkudale.com/images/maths/linear.png")
        val chapter13=Chapter(13,"Graph","http://ashishkudale.com/images/maths/plot.png")
        val chapter14=Chapter(14,"Trigonometry","http://ashishkudale.com/images/maths/trigonometry.png")
        chapterList3.add(chapter10)
        chapterList3.add(chapter11)
        chapterList3.add(chapter12)
        chapterList3.add(chapter13)
        chapterList3.add(chapter14)
        val maths = Subject(Subject.IMAGE_TYPE,"Maths",chapterList3,null)
        val maths1 = Subject(Subject.IMAGE_TYPE,"Math",chapterList3,null)


        subjects.add(physics)
        subjects.add(maths)
        subjects.add(maths1)
        subjects.add(bio)
        return subjects
    }
}