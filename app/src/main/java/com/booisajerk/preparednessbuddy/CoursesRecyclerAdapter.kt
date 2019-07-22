package com.booisajerk.preparednessbuddy

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recommended_course_item.view.*

class CoursesRecyclerAdapter(private val courses: ArrayList<Course>) :
    RecyclerView.Adapter<CoursesRecyclerAdapter.CourseHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesRecyclerAdapter.CourseHolder {
        val inflatedView = parent.inflate(R.layout.recommended_course_item, false)
        return CourseHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return courses.size
    }

    override fun onBindViewHolder(holder: CoursesRecyclerAdapter.CourseHolder, position: Int) {
        val itemCourse = courses[position]
        holder.bindCourseInfo(itemCourse)
    }

    class CourseHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var course: Course? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Log.d("Parker", "Recyclerview CLICK!")
        }

        fun bindCourseInfo(course: Course) {
            this.course = course
            view.card_title.text = course.courseTitle
            view.card_level.text = course.courseDifficulty
            view.card_image.setImageResource(course.courseImage)
        }
    }
}


