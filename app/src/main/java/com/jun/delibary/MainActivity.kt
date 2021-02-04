package com.jun.delibary

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jun.delibary.adapters.HomeAdapter
import com.jun.delibary.databinding.ActivityMainBinding
import com.jun.delibary.model.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private var recentlyProductAdapter: HomeAdapter? = null
    private lateinit var dataBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)
        var subjects = prepareData()
        Log.d("response","$subjects")
        val manager = LinearLayoutManager(this)

        recentlyProductAdapter = HomeAdapter( subjects,this,dataBinding.rvSubject)


        dataBinding.rvSubject.apply{
            layoutManager = manager
            adapter = recentlyProductAdapter
        }
    }

}