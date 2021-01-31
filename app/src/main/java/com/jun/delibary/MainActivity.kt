package com.jun.delibary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jun.delibary.adapters.RecentlyProductAdapter
import com.jun.delibary.databinding.ActivityMainBinding
import com.jun.delibary.model.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private var recentlyProductAdapter: RecentlyProductAdapter? = null
    private lateinit var dataBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)

        var subjects = prepareData()
        val manager = LinearLayoutManager(this@MainActivity)

        recentlyProductAdapter = RecentlyProductAdapter( subjects,this@MainActivity)

        dataBinding.rvSubject.apply{
            layoutManager = manager
            adapter = recentlyProductAdapter
        }
    }

}