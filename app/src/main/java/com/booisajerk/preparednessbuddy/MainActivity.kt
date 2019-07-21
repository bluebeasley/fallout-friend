package com.booisajerk.preparednessbuddy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.booisajerk.preparednessbuddy.ui.login.LoginActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.carousel_view.*
import kotlinx.android.synthetic.main.current_progress_view.*
import kotlinx.android.synthetic.main.recommended_courses_view.*


class MainActivity : AppCompatActivity() {

    private var courses: ArrayList<Course>? = null

    private lateinit var adapter: RecyclerAdapter

    //TODO add real images here
    private var sampleImages =
        intArrayOf(R.drawable.shop)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeCourseData()

        // Recommended courses recyclerView
        val gridLayoutManager = GridLayoutManager(this, 2)
        recyclerview.setLayoutManager(gridLayoutManager)

        adapter = courses?.let { RecyclerAdapter(it) }!!
        recyclerview.adapter = adapter

        // Bottom Navigation
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        progress_button.setOnClickListener {
            startActivity(Intent(this, AccountSetupActivity::class.java))
        }

        // Carousel View
        carouselView.pageCount = sampleImages.size
        carouselView.setImageListener(imageListener)
    }

    var imageListener: ImageListener = ImageListener { position, imageView ->
        imageView.setImageResource(sampleImages[position])
    }


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                //TODO do something
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_chat -> {
                //TODO do something
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_alert -> {
                //TODO do something
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_profile -> {
                startActivity(Intent(this, LoginActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    fun initializeCourseData() {
        courses = ArrayList()
        (courses as ArrayList<Course>).add(Course("Living Alone", "Beginner", R.drawable.family))
        (courses as ArrayList<Course>).add(Course("Pets", "Intermediate", R.drawable.pets))
        (courses as ArrayList<Course>).add(Course("Urban Survival", "Beginner", R.drawable.earthquake))
        (courses as ArrayList<Course>).add(Course("Foreign Travel", "Intermediate", R.drawable.earthquake))
    }
}
