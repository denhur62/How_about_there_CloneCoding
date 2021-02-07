package com.jun.delibary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jun.delibary.databinding.ActivityEventBinding
import com.jun.delibary.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_event.*

class EventActivity : AppCompatActivity(){
    private lateinit var dataBinding: ActivityEventBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)
        if(intent.hasExtra("eventAll")){
            dataBinding.tvAddress.text=intent.getStringExtra("eventAll")+"이벤트"
        }
        if(intent.hasExtra("slideEvent")){
            dataBinding.tvAddress.text=intent.getStringExtra("slideEvent")+"번째 이벤트"
        }
        if(intent.hasExtra("recentlyEvent")){
            dataBinding.tvAddress.text="최근 본 상품 "
            dataBinding.imageView2.setImageResource(intent.getStringExtra("recentlyEvent")!!.toInt())
        }
        dataBinding.ivClose.setOnClickListener {
            finish()
        }
    }
}