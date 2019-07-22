package com.booisajerk.preparednessbuddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_course_details.*
import kotlinx.android.synthetic.main.course_details_item.*

class CourseDetailsActivity : AppCompatActivity() {

    private var courseDetails: ArrayList<CourseDetails>? = null

    private lateinit var adapter: CourseDetailsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_details)

        initializeCourseDetailsData()

        val linearLayoutManager = LinearLayoutManager(this)
        details_recyclerview.setLayoutManager(linearLayoutManager)

        adapter = courseDetails?.let { CourseDetailsRecyclerAdapter(it) }!!
        details_recyclerview.adapter = adapter
    }

    fun initializeCourseDetailsData() {
        courseDetails = ArrayList()
        (courseDetails as ArrayList<CourseDetails>).add(CourseDetails(0, resources.getString(R.string.earthquake_text_1), true))
        (courseDetails as ArrayList<CourseDetails>).add(CourseDetails(1, resources.getString(R.string.earthquake_text_2), true))
        (courseDetails as ArrayList<CourseDetails>).add(CourseDetails(2, resources.getString(R.string.earthquake_text_3), false))
        (courseDetails as ArrayList<CourseDetails>).add(CourseDetails(3, resources.getString(R.string.earthquake_text_4), false))
        (courseDetails as ArrayList<CourseDetails>).add(CourseDetails(4, resources.getString(R.string.earthquake_text_5), false))
        (courseDetails as ArrayList<CourseDetails>).add(CourseDetails(5, resources.getString(R.string.earthquake_text_6), false))
        (courseDetails as ArrayList<CourseDetails>).add(CourseDetails(6, resources.getString(R.string.earthquake_text_7), false))
    }
}
