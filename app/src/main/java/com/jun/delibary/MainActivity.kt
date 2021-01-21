package com.jun.delibary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jun.delibary.adapters.SubjectAdapter
import com.jun.delibary.databinding.ActivityMainBinding
import com.jun.delibary.model.Chapter
import com.jun.delibary.model.Subject
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private var subjectAdapter: SubjectAdapter? = null
    private var subjects: ArrayList<Subject>? = null
    private lateinit var dataBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)

        var subjects = prepareData()

        subjectAdapter = SubjectAdapter(subjects, this@MainActivity)
        val manager = LinearLayoutManager(this@MainActivity)
        dataBinding.rvSubject?.apply{
            setLayoutManager(manager)
            setAdapter(subjectAdapter)
        }
    }

    private fun prepareData(): ArrayList<Subject> {
        var subjects: ArrayList<Subject> = ArrayList<Subject>()
        var physics = Subject()
        physics.id = 1
        physics.subjectName = "Physics"
        physics.chapters = ArrayList<Chapter>()
        val chapter1 = Chapter()
        chapter1.id = 1
        chapter1.chapterName = "Atomic power"
        chapter1.imageUrl = "http://ashishkudale.com/images/phy/atoms.png"
        val chapter2 = Chapter()
        chapter2.id = 2
        chapter2.chapterName = "Theory of relativity"
        chapter2.imageUrl = "http://ashishkudale.com/images/phy/sigma.png"
        val chapter3 = Chapter()
        chapter3.id = 3
        chapter3.chapterName = "Magnetic field"
        chapter3.imageUrl = "http://ashishkudale.com/images/phy/magnet.png"
        val chapter4 = Chapter()
        chapter4.id = 4
        chapter4.chapterName = "Practical 1"
        chapter4.imageUrl = "http://ashishkudale.com/images/phy/caliper.png"
        val chapter5 = Chapter()
        chapter5.id = 5
        chapter5.chapterName = "Practical 2"
        chapter5.imageUrl = "http://ashishkudale.com/images/phy/micrometer.png"
        physics.chapters.add(chapter1)
        physics.chapters.add(chapter2)
        physics.chapters.add(chapter3)
        physics.chapters.add(chapter4)
        physics.chapters.add(chapter5)

        val chem = Subject()
        chem.id = 2
        chem.subjectName = "Chemistry"
        chem.chapters = ArrayList<Chapter>()
        val chapter6 = Chapter()
        chapter6.id = 6
        chapter6.chapterName = "Chemical bonds"
        chapter6.imageUrl = "http://ashishkudale.com/images/chem/bonds.png"
        val chapter7 = Chapter()
        chapter7.id = 7
        chapter7.chapterName = "Sodium"
        chapter7.imageUrl = "http://ashishkudale.com/images/chem/sodium.png"
        val chapter8 = Chapter()
        chapter8.id = 8
        chapter8.chapterName = "Periodic table"
        chapter8.imageUrl = "http://ashishkudale.com/images/chem/periodic_table.png"
        val chapter9 = Chapter()
        chapter9.id = 9
        chapter9.chapterName = "Acid and Base"
        chapter9.imageUrl = "http://ashishkudale.com/images/chem/chem.png"
        chem.chapters.add(chapter6)
        chem.chapters.add(chapter7)
        chem.chapters.add(chapter8)
        chem.chapters.add(chapter9)

        val bio = Subject()
        bio.id = 3
        bio.subjectName = "Biology"
        bio.chapters = ArrayList<Chapter>()
        val chapter10 = Chapter()
        chapter10.id = 10
        chapter10.chapterName = "Bacteria"
        chapter10.imageUrl = "http://ashishkudale.com/images/bio/bacteria.png"
        val chapter11 = Chapter()
        chapter11.id = 11
        chapter11.chapterName = "DNA and RNA"
        chapter11.imageUrl = "http://ashishkudale.com/images/bio/dna.png"
        val chapter12 = Chapter()
        chapter12.id = 12
        chapter12.chapterName = "Study of microscope"
        chapter12.imageUrl = "http://ashishkudale.com/images/bio/microscope.png"
        val chapter13 = Chapter()
        chapter13.id = 13
        chapter13.chapterName = "Protein and fibers"
        chapter13.imageUrl = "http://ashishkudale.com/images/bio/protein.png"
        bio.chapters.add(chapter10)
        bio.chapters.add(chapter11)
        bio.chapters.add(chapter12)
        bio.chapters.add(chapter13)
        val maths = Subject()
        maths.id = 4
        maths.subjectName = "Maths"
        maths.chapters = ArrayList<Chapter>()
        val chapter14 = Chapter()
        chapter14.id = 14
        chapter14.chapterName = "Circle"
        chapter14.imageUrl = "http://ashishkudale.com/images/maths/circle.png"
        val chapter15 = Chapter()
        chapter15.id = 15
        chapter15.chapterName = "Geometry"
        chapter15.imageUrl = "http://ashishkudale.com/images/maths/geometry.png"
        val chapter16 = Chapter()
        chapter16.id = 16
        chapter16.chapterName = "Linear equations"
        chapter16.imageUrl = "http://ashishkudale.com/images/maths/linear.png"
        val chapter17 = Chapter()
        chapter17.id = 17
        chapter17.chapterName = "Graph"
        chapter17.imageUrl = "http://ashishkudale.com/images/maths/plot.png"
        val chapter18 = Chapter()
        chapter18.id = 18
        chapter18.chapterName = "Trigonometry"
        chapter18.imageUrl = "http://ashishkudale.com/images/maths/trigonometry.png"
        maths.chapters.add(chapter14)
        maths.chapters.add(chapter18)
        maths.chapters.add(chapter15)
        maths.chapters.add(chapter16)
        maths.chapters.add(chapter17)
        subjects.add(physics)
        subjects.add(chem)
        subjects.add(maths)
        subjects.add(bio)
        return subjects
    }
}