package com.jun.delibary.model

import java.util.*

data class Subject(var type:Int , var subjectName:String?, var chapters:ArrayList<Chapter>?, var mainSliders:ArrayList<MainSlide>? ) {
    companion object {
        const val IMAGE_TYPE = 1
        const val SLIDE_TYPE = 0
        const val TEXT_TYPE=2
    }
}