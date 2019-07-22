package com.booisajerk.preparednessbuddy

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.course_details_item.view.*
import kotlinx.android.synthetic.main.recommended_course_item.view.*

class CourseDetailsRecyclerAdapter(private val courseDetails: ArrayList<CourseDetails>) :
    RecyclerView.Adapter<CourseDetailsRecyclerAdapter.CourseDetailsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseDetailsRecyclerAdapter.CourseDetailsHolder {
        val inflatedView = parent.inflate(R.layout.course_details_item, false)
        return CourseDetailsHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return courseDetails.size
    }

    override fun onBindViewHolder(holder: CourseDetailsHolder, position: Int) {
        val itemCourseDetail = courseDetails[position]
        holder.bindCourseDetailsInfo(itemCourseDetail)
    }

    class CourseDetailsHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var courseDetail: CourseDetails? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Log.d("Parker", "Recyclerview CLICK!")
        }

        fun bindCourseDetailsInfo(courseDetails: CourseDetails) {
            this.courseDetail = courseDetails

            if(courseDetails.isComplete) {
                view.check_item_image.visibility = View.VISIBLE
            }

            view.check_item.text = courseDetails.itemTitle
        }
    }
}